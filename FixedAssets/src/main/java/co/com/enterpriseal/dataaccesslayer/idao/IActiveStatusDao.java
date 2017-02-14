package co.com.enterpriseal.dataaccesslayer.idao;

import java.util.List;

import co.com.enterpriseal.commons.model.ActiveStatusModel;
import java.io.IOException;

/**
 * Interfaz que especifica la implementacion de la clase ActiveStatusDao
 * @since 2017-02-10
 * @author AdrianL
 */
public interface IActiveStatusDao {
	/**
     * Especificacion metodo listar los estados del activo
     * @return listado de los estado de los activos
     * @throws IOException 
     */
    List<ActiveStatusModel> listActiveStatus() throws IOException;
    
    /**
     * Especificacion metodo crear nuevo registro estado activo
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion se completo con exito 
     * @throws IOException 
     */
    boolean insertActiveStatus(ActiveStatusModel pStatusModel) throws IOException;
    
    /**
     * Especificacion metodo actualizar registro estado activo
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion se completo con exito  
     * @throws IOException    
     */
    boolean updateActiveStatus(ActiveStatusModel pStatusModel) throws IOException;
    
    /**
     * Especificacion metodo eliminar registro estado activo
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean deleteActiveStatus(ActiveStatusModel pStatusModel) throws IOException;
}
