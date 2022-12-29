package us.proentel.service;

import us.proentel.domain.*;
import us.proentel.dto.*;

import java.util.List;
import java.util.Optional;

public interface BusinessManager {

    String createUser (UserDto user);
    JwtDto loginUser (LoginDto login);

    String createRol (RolDto rol);
    Optional<User> loadUser (LoginDto login);

    List<MenuDto> getMenuByRol(String rol);

    List<FunctionDto> getFunctionByEntityId(String id, String rol);


}
