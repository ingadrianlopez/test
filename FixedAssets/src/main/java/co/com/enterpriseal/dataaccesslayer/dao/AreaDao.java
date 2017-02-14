package co.com.enterpriseal.dataaccesslayer.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.enterpriseal.commons.model.AreaModel;
import co.com.enterpriseal.dataaccesslayer.helper.AreaHelper;
import co.com.enterpriseal.dataaccesslayer.idao.IAreaDao;
import co.com.enterpriseal.transverse.util.Util;
import java.io.IOException;

/**
 * Clase que maneja el acceso a datos a la tabla gest_area
 *
 * @since 2017-02-10
 * @author AdrianL
 */
public class AreaDao implements IAreaDao {

    private JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM GEST_AREA";
    private final static String SQL_INSERT = "INSERT INTO GEST_AREA(ID, NOMBRE, DESCRIPCION, CIUDAD) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM GEST_AREA), ?, ?, ?)";

    /**
     * Implementa metodo obtener las areas parametrizadas en la base de datos
     *
     * @return Listado de areas
     * @throws IOException
     */
    @Override
    public List<AreaModel> listArea() throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        return jdbcTemplate.query(SQL_SELECT, new AreaHelper());
    }

    /**
     * Implementa metodo crear nueva area en la base de datos
     *
     * @param pAreaModel objeto AreaModel
     * @return true si la operacion se completo con exito
     * @throws IOException
     */
    @Override
    public boolean insertArea(AreaModel pAreaModel) throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        jdbcTemplate.update(SQL_INSERT, new Object[]{pAreaModel.getName(), pAreaModel.getDescription(), pAreaModel.getCity()});
        return true;
    }

    /**
     * Implementa metodo actualizar area
     * @param pAreaModel objeto AreaModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean updateArea(AreaModel pAreaModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementa metodo eliminar area
     * @param pAreaModel objeto AreaModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean deleteArea(AreaModel pAreaModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
