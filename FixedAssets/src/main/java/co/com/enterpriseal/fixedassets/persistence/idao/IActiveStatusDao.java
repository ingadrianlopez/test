package co.com.enterpriseal.fixedassets.persistence.idao;

import java.util.List;

import co.com.enterpriseal.fixedassets.persistence.model.ActiveStatusModel;

/**
 * Interfaz que especifica la implementacion de la clase ActiveStatusDao
 *
 * @since 2017-02-10
 * @author AdrianL
 */
public interface IActiveStatusDao {

    /**
     * Especificacion metodo listar los estados del activo
     * @return listado de los estado de los activos
     */
    List<ActiveStatusModel> listActiveStatus();

    /**
     * Especificacion metodo crear nuevo registro estado activo
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion se completo con exito
     */
    boolean insertActiveStatus(ActiveStatusModel pStatusModel);

    /**
     * Especificacion metodo actualizar registro estado activo
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion se completo con exito
     */
    boolean updateActiveStatus(ActiveStatusModel pStatusModel);

    /**
     * Especificacion metodo eliminar registro estado activo
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion se completo con exito
     */
    boolean deleteActiveStatus(ActiveStatusModel pStatusModel);
}
