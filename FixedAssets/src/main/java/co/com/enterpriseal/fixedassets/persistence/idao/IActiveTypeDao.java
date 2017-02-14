package co.com.enterpriseal.fixedassets.persistence.idao;

import java.util.List;

import co.com.enterpriseal.fixedassets.persistence.model.ActiveTypeModel;

/**
 * Interfaz que especifica la implementacion de la clase ActiveTypeDao
 * @since 2017-10
 * @author AdrianL
 */
public interface IActiveTypeDao {
    /**
     * Especifica el metodo listar los tipos de activos
     * @return lista con los datos de tipos de activo
     */
    List<ActiveTypeModel> listActiveType();
    
    /**
     * Especifica el metodo crear nuevo registro tipo de activo
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     */
    boolean insertActiveType(ActiveTypeModel pTypeModel);
    
    /**
     * Especifica el metodo actualizar registro tipo de activo
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     */
    boolean updateActiveType(ActiveTypeModel pTypeModel);
    
    /**
     * Especifica el metodo elimiar registro tipo de activo
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     */
    boolean deleteActiveType(ActiveTypeModel pTypeModel);
}
