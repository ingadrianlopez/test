package co.com.enterpriseal.fixedassets.persistence.idao;

import java.util.List;

import co.com.enterpriseal.fixedassets.persistence.model.CityModel;

/**
 * Interfaz que especifica la implementacion de la clase CityDao
 * @since 2017-02-10
 * @author AdrianL
 */	
public interface ICityDao {
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
    
    /**
     * Especifica el metodo actualizar ciudad en la base de datos
     * @param pCityModel Objeto City Model
     * @return true si la operacion se completo con exito
     */
    boolean updateCity(CityModel pCityModel);
    
    /**
     * Especifica el metodo eliminar ciudad en la base de datos
     * @param pCityModel Objeto City Model
     * @return true si la operacion se completo con exito
     */
    boolean deleteCity(CityModel pCityModel);
}
