package co.com.enterpriseal.dataaccesslayer.idao;

import java.util.List;

import co.com.enterpriseal.commons.model.CityModel;
import java.io.IOException;

/**
 * Interfaz que especifica la implementacion de la clase CityDao
 * @since 2017-02-10
 * @author AdrianL
 */	
public interface ICityDao {
	/**
     * Especifica el metodo obtener ciudades de la base de datos
     * @return listado de ciudades
     * @throws SQLException 
     */
    List<CityModel> listArea() throws IOException;
    
    /**
     * Especifica el metodo crear una nueva ciudad en la base de datos
     * @param pCityModel Objeto City Model
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean insertCity(CityModel pCityModel) throws IOException;
    
    /**
     * Especifica el metodo actualizar ciudad en la base de datos
     * @param pCityModel Objeto City Model
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean updateCity(CityModel pCityModel) throws IOException;
    
    /**
     * Especifica el metodo eliminar ciudad en la base de datos
     * @param pCityModel Objeto City Model
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean deleteCity(CityModel pCityModel) throws IOException;
}
