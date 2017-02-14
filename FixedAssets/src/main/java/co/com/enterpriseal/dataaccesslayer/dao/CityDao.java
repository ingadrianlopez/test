package co.com.enterpriseal.dataaccesslayer.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.com.enterpriseal.commons.model.CityModel;
import co.com.enterpriseal.dataaccesslayer.helper.CityHelper;
import co.com.enterpriseal.dataaccesslayer.idao.ICityDao;
import co.com.enterpriseal.transverse.util.Util;
import java.io.IOException;

/**
 * Clase que maneja el acceso a datos de la tabla para_ciud
 *
 * @since 2017-02-10
 * @author AdrianL
 */
@Component
public class CityDao implements ICityDao {

    private JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM PARA_CIUD";
    private final static String SQL_INSERT = "INSERT INTO PARA_CIUD(ID, NOMBRE, DESCRIPCION) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM PARA_CIUD), ?, ?)";

    /**
     * Implementa metodo que obtiene el listado de las ciudades parametrizadas
     * en la base de datos
     *
     * @return Listado de ciudades
     * @throws IOException
     */
    @Override
    public List<CityModel> listArea() throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        return jdbcTemplate.query(SQL_SELECT, new CityHelper());
    }

    /**
     * Implementa metodo crear una nueva ciudad en la base de datos
     *
     * @param pCityModel Objeto CityModel
     * @return true si la operacion se completo con exito
     * @throws IOException
     */
    @Override
    public boolean insertCity(CityModel pCityModel) throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        jdbcTemplate.update(SQL_INSERT, new Object[]{pCityModel.getName(), pCityModel.getDescription()});
        return true;
    }

    /**
     * Implementa metodo Actualizar ciudad
     * @param pCityModel Objeto CityModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean updateCity(CityModel pCityModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementa metodo eliminar ciudad
     * @param pCityModel Objeto CityModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean deleteCity(CityModel pCityModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
