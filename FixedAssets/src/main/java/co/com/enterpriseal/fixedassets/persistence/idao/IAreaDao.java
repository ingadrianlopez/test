package co.com.enterpriseal.fixedassets.persistence.idao;

import java.util.List;

import co.com.enterpriseal.fixedassets.persistence.model.AreaModel;
import java.io.IOException;

/**
 * Interfaz que especifica la implementacion de la clase AreaDao
 * @since 2017-02-10
 * @author AdrianL
 */
public interface IAreaDao {
	/**
     * Especifica el metodo obtener las areas de la base de datos
     * @return listado de areas
     * @throws IOException 
     */
    List<AreaModel> listArea() throws IOException;
    
    /**
     * Especifica el metodo crear una nueva area en la base de datos
     * @param pAreaModel Objeto Area Model
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean insertArea(AreaModel pAreaModel) throws IOException;
    
    /**
     * Especifica el metodo actualizar area en la base de datos
     * @param pAreaModel Objeto Area Model
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean updateArea(AreaModel pAreaModel) throws IOException;
    
    /**
     * Especifica el metodo eliminar area en la base de datos
     * @param pAreaModel Objeto Area Model
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean deleteArea(AreaModel pAreaModel) throws IOException;
}
