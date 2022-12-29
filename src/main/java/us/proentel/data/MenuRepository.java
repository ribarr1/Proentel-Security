package us.proentel.data;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;
import us.proentel.domain.EntityFunction;
import us.proentel.domain.EntityMenu;
import us.proentel.domain.Menu;
import us.proentel.domain.Rol;
import us.proentel.dto.RolDto;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MenuRepository {

    private final DataSource ds;

    public MenuRepository() {

        this.ds = DataSourceSingleton.getInstance();
    }


   public List<Menu> getMenuByRol(String rol) {
        QueryRunner run = new QueryRunner(ds);
        List<Menu> menu = new LinkedList<>();
        try {
            String query = "select distinct menuid, namemenu,numbermenu from\n" +
                    " (select men.id menuid, men.name namemenu, men.number numbermenu  \n" +
                    " from rol rol, rol_entity_function ref, entity ent, menu men, `function` fun\n" +
                    " where rol.id = ref.rol_id\n" +
                    " and ent.id = ref.entity_id\n" +
                    " and men.id = ent.id_menu\n" +
                    " and fun.id = ref.function_id\n" +
                    " and rol.name = '"+ rol + "'\n" +
                    " order by men.number, ent.number) data";
            List<Menu> menuList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            menu.add(new Menu.Builder()
                                    .setId(rs.getString(1))
                                    .setName(rs.getString(2))
                                    .setNumber(rs.getString(3))
                                    .build());
                        }
                        return menu;
                    });
            return menuList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EntityMenu> getEntityByMenuId(String menuId, String rol) {
        QueryRunner run = new QueryRunner(ds);
        List<EntityMenu> entity = new LinkedList<>();
        try {
            String query = "select distinct menuid, identity, numberentity,nameentity, path from\n" +
                    "(select men.id menuid, men.name namemenu, men.number numbermenu, ent.id identity, ent.number numberentity, \n" +
                    "ent.name nameentity, ent.path, fun.name namefuction  \n" +
                    "from rol rol, rol_entity_function ref, entity ent, menu men, `function` fun\n" +
                    "where rol.name = '" + rol + "'\n" +
                    "and rol.id = ref.rol_id\n" +
                    "and ent.id = ref.entity_id\n" +
                    "and men.id = ent.id_menu\n" +
                    "and fun.id = ref.function_id\n" +
                    "order by men.number, ent.number) data\n" +
                    "where menuid = '"+menuId+"'";
            List<EntityMenu> EntityMenuList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            entity.add(new EntityMenu.Builder()
                                    .setIdEntity(rs.getString(2))
                                    .setNameEntity(rs.getString(4))
                                    .setNumberEntity(rs.getString(3))
                                    .setPath(rs.getString(5))
                                    .build());
                        }
                        return entity;
                    });
            return EntityMenuList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EntityFunction> getFunctionByEntityId(String entityId, String rol) {
        QueryRunner run = new QueryRunner(ds);
        List<EntityFunction> entityFunction = new LinkedList<>();
        try {
            String query = "select distinct namefuction from\n" +
                    "(select men.id menuid, men.name namemenu, men.number numbermenu, ent.id identity, ent.number numberentity, \n" +
                    "ent.name nameentity, ent.path, fun.name namefuction  \n" +
                    "from rol rol, rol_entity_function ref, entity ent, menu men, `function` fun\n" +
                    "where rol.name = '" + rol + "'\n" +
                    "and rol.id = ref.rol_id\n" +
                    "and ent.id = ref.entity_id\n" +
                    "and men.id = ent.id_menu\n" +
                    "and fun.id = ref.function_id\n" +
                    "order by men.number, ent.number) data\n" +
                    "where identity = '"+entityId+"'";
            List<EntityFunction> EntityFunctionList = run.query(query,
                    rs -> {
                        while (rs.next()) {
                            entityFunction.add(new EntityFunction.Builder()
                                    .setNameFunction(rs.getString(1))
                                    .build());
                        }
                        return entityFunction;
                    });
            return EntityFunctionList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
