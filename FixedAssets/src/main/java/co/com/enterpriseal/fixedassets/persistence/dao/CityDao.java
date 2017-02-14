package co.com.enterpriseal.fixedassets.persistence.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.com.enterpriseal.fixedassets.persistence.model.CityModel;
import co.com.enterpriseal.fixedassets.persistence.helper.CityHelper;
import co.com.enterpriseal.fixedassets.persistence.idao.ICityDao;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase que maneja el acceso a datos de la tabla para_ciud
 *
 * @since 2017-02-10
 * @author AdrianL
 */
@Component
public class CityDao implements ICityDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM PARA_CIUD";
    private final static String SQL_INSERT = "INSERT INTO PARA_CIUD(ID, NOMBRE, DESCRIPCION) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM PARA_CIUD), ?, ?)";

    /**
     * Implementa metodo que obtiene el listado de las ciudades parametrizadas
     * en la base de datos
     * @return Listado de ciudades
     * @throws IOException
     */
    @Override
    public List<CityModel> listCity() {
        return jdbcTemplate.query(SQL_SELECT, new CityHelper());
    }

    /**
     * Implementa metodo crear una nueva ciudad en la base de datos
     * @param pCityModel Objeto CityModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean insertCity(CityModel pCityModel) {
        jdbcTemplate.update(SQL_INSERT, new Object[]{pCityModel.getName(), pCityModel.getDescription()});
        return true;
    }

    /**
     * Implementa metodo Actualizar ciudad
     * @param pCityModel Objeto CityModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean updateCity(CityModel pCityModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementa metodo eliminar ciudad
     * @param pCityModel Objeto CityModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean deleteCity(CityModel pCityModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
