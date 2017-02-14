package co.com.enterpriseal.dataaccesslayer.idao;

import java.util.List;

import co.com.enterpriseal.commons.model.ActiveTypeModel;
import java.io.IOException;

/**
 * Interfaz que especifica la implementacion de la clase ActiveTypeDao
 * @since 2017-10
 * @author AdrianL
 */
public interface IActiveTypeDao {
	/**
     * Especifica el metodo listar los tipos de activos
     * @return lista con los datos de tipos de activo
     * @throws IOException 
     */
    List<ActiveTypeModel> listActiveType() throws IOException;
    
    /**
     * Especifica el metodo crear nuevo registro tipo de activo
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean insertActiveType(ActiveTypeModel pTypeModel) throws IOException;
    
    /**
     * Especifica el metodo actualizar registro tipo de activo
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean updateActiveType(ActiveTypeModel pTypeModel) throws IOException;
    
    /**
     * Especifica el metodo elimiar registro tipo de activo
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean deleteActiveType(ActiveTypeModel pTypeModel) throws IOException;
}
