package co.com.enterpriseal.dataaccesslayer.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.com.enterpriseal.commons.model.ActiveTypeModel;
import co.com.enterpriseal.dataaccesslayer.helper.ActiveTypeHelper;
import co.com.enterpriseal.dataaccesslayer.idao.IActiveTypeDao;
import co.com.enterpriseal.transverse.util.Util;
import java.io.IOException;

/**
 * Clase que maneja el acceso a datos a la tabla para_tipo_acti
 *
 * @since 2017-02-10
 * @author AdrianL
 */
@Component
public class ActiveTypeDao implements IActiveTypeDao {

    private JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM PARA_TIPO_ACTI";
    private final static String SQL_INSERT = "INSERT INTO PARA_TIPO_ACTI(ID, NOMBRE, DESCRIPCION) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM PARA_TIPO_ACTI), ?, ?)";

    /**
     * Implementa el metodo listar tipos de activo
     *
     * @return listado con los tipos de activos
     * @throws IOException
     */
    @Override
    public List<ActiveTypeModel> listActiveType() throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        return jdbcTemplate.query(SQL_SELECT, new ActiveTypeHelper());
    }

    /**
     * Implementa el metodo crear nuevo registro tipo de activo
     *
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException
     */
    @Override
    public boolean insertActiveType(ActiveTypeModel pTypeModel) throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        jdbcTemplate.update(SQL_INSERT, new Object[]{pTypeModel.getName(), pTypeModel.getDescription()});
        return true;
    }

    /**
     * Implementa el metodo actualizar registro tipo de activo
     *
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException
     */
    @Override
    public boolean updateActiveType(ActiveTypeModel pTypeModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementa el metodo eliminar registro tipo de activo
     *
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException
     */
    @Override
    public boolean deleteActiveType(ActiveTypeModel pTypeModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
