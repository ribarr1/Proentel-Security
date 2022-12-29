package us.proentel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.client.HttpClientErrorException;
import us.proentel.data.*;
import us.proentel.domain.*;
import us.proentel.dto.*;
import us.proentel.jwt.JwtProvider;
import us.proentel.service.BusinessManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


import static us.proentel.utilities.Constants.USER_NOT_EXISTS;
import static us.proentel.utilities.Constants.USER_ALREADY_EXISTS;
import static us.proentel.utilities.Constants.ROL_ALREADY_EXISTS;


@Component
public class BussinessManagerImpl implements BusinessManager {

    @Autowired
    AuthenticationManager authenticationManager;



    private static UserRepository userRepository;
    private static RolRepository rolRepository;
    private static MenuRepository menuRepository;
    private static UserRolRepository userRolRepository;

    private final static Logger LOGGER = LogManager.getLogger(BussinessManagerImpl.class);



    public BussinessManagerImpl() {


        userRepository = new UserRepository();
        rolRepository = new RolRepository();
        menuRepository = new MenuRepository();
        userRolRepository = new UserRolRepository();


    }



//////////////////////////////USUARIOSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS


    @Override
    public String createUser(UserDto user) {

        if(userRepository.getUserByUserName(user.getUsername()).isPresent()) {
            return USER_ALREADY_EXISTS;
        }
        return userRepository.createUser(user);
    }

    @Override
    public JwtDto loginUser(LoginDto login) {
        JwtProvider jwtp = new JwtProvider();
        JwtDto jwt = new JwtDto();

        if(!userRepository.getUserByUserName(login.getUsername()).isPresent()) {
            jwt.setStatus("error");
            jwt.setMessage(USER_NOT_EXISTS);
            return jwt;
        }
        Optional<User> usuario = userRepository.getUserByUserName(login.getUsername());

        if(usuario.get().getPassword().equals(login.getPassword())){
            Optional<UserRol> userRol = userRolRepository.getByUserId(usuario.get().getId());
            Optional<Rol> rol = rolRepository.getRolById(userRol.get().getRolId());
            String token = jwtp.getJWTToken(usuario.get().getUsername(), usuario.get().getId(),rol.get().getName());
            jwt.setToken(token);
            jwt.setId(usuario.get().getId());
            jwt.setName(usuario.get().getName());
            jwt.setUsername(jwtp.getNombreUsuarioFromToken(token));
            jwt.setRol(jwtp.getUserRole(token));
            jwt.setStatus("success");
            jwt.setMessage("Logueo exitoso");

            return jwt;
        }
        jwt.setStatus("error");
        jwt.setMessage("Password Invalido");
        return jwt;
    }

    @Override
    public Optional<User> loadUser(LoginDto login) {
        Optional<User> usuario = userRepository.getUserByUserName(login.getUsername());

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

            if(!authentication.isAuthenticated())
                System.out.println("SU MADREEEEEEEEEEEEEEEE 1111");

            return usuario;


    }


    //ROLESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    @Override
    public String createRol(RolDto rol) {

        if(rolRepository.getRolByName(rol.getName()).isPresent()) {
            return ROL_ALREADY_EXISTS;
        }
        return rolRepository.createRol(rol);
    }



    /////////////////MENUUUUU

    @Override
    public List<MenuDto> getMenuByRol(String rol) {
        List<MenuDto> response = new LinkedList<>();
        List<Menu> menus =  menuRepository.getMenuByRol(rol);

        if(menus.isEmpty()){
            return  response;
        }

        for (Menu menu: menus ){
            MenuDto menuDto = new MenuDto();
            menuDto.setParent(menu.getName());
            menuDto.setParent_order(menu.getNumber());
            List<EntityMenu> entityMenus =  menuRepository.getEntityByMenuId(menu.getId(),rol);
            List<ItemsDto> items = new LinkedList<>();

            for (EntityMenu entityMenu: entityMenus ){
                List<FunctionDto> functions = new LinkedList<>();
                ItemsDto itemsDto = new ItemsDto();
                itemsDto.setOrder(entityMenu.getNumberEntity());
                itemsDto.setName(entityMenu.getNameEntity());
                itemsDto.setPath(entityMenu.getPath());
                List<EntityFunction> entityFunctions = menuRepository.getFunctionByEntityId(entityMenu.getIdEntity(),rol);
                for (EntityFunction entityFunction: entityFunctions ){
                    FunctionDto functionDto = new FunctionDto();
                    functionDto.setFunction(entityFunction.getNameFunction());
                    functions.add(functionDto);

                }
                itemsDto.setFunction(functions);
                items.add(itemsDto);
            }
            menuDto.setItems(items);
            response.add((menuDto));
        }
        return response;
    }




        @Override
        public List<FunctionDto> getFunctionByEntityId(String id, String rol) {
            List<EntityFunction> entityFunctions = menuRepository.getFunctionByEntityId(id, rol);
            List<FunctionDto> response = new LinkedList<>();
            if (entityFunctions.isEmpty()) {
                return response;
            }
            for (EntityFunction entityFunction : entityFunctions) {
                FunctionDto functionDto = new FunctionDto();
                functionDto.setFunction(entityFunction.getNameFunction());
                response.add((functionDto));

            }
            return response;
        }

}
