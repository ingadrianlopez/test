package co.com.enterpriseal.fixedassets.service.ibusiness;

import co.com.enterpriseal.fixedassets.persistence.model.ActiveStatusModel;
import java.util.List;

/**
 * Especifica la implementacion de la clase ActiveStatusBusiness
 * @author aye
 */
public interface IActiveStatusBusiness {

    /**
     * Especificacion metodo listar los estados del activo
     *
     * @return listado de los estado de los activos
     */
    List<ActiveStatusModel> listActiveStatus();

    /**
     * Especificacion metodo crear nuevo registro estado activo
     *
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion se completo con exito
     */
    boolean insertActiveStatus(ActiveStatusModel pStatusModel);

}
