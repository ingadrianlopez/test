package co.com.enterpriseal.fixedassets.service.ibusiness;

import co.com.enterpriseal.fixedassets.persistence.model.CityModel;
import java.util.List;

/**
 * Especifica la implementacion de la clase CityBusiness
 * @since 2017-02-14
 * @author aye
 */
public interface ICityBusiness {
    /**
     * Especifica el metodo obtener ciudades de la base de datos
     * @return listado de ciudades
     */
    List<CityModel> listCity();
    
    /**
     * Especifica el metodo crear una nueva ciudad en la base de datos
     * @param pCityModel Objeto City Model
     * @return true si la operacion se completo con exito     
     */
    boolean insertCity(CityModel pCityModel);
}
