package co.com.enterpriseal.fixedassets.service.ibusiness;

import co.com.enterpriseal.fixedassets.persistence.model.AreaModel;
import java.util.List;

/**
 * Especifica la implementacion de la clase IAreaBusiness
 * @since 2017-02-14
 * @author aye
 */
public interface IAreaBusiness {

    /**
     * Especifica el metodo obtener las areas de la base de datos
     * @return listado de areas
     */
    List<AreaModel> listArea();

    /**
     * Especifica el metodo crear una nueva area en la base de datos
     * @param pAreaModel Objeto Area Model
     * @return true si la operacion se completo con exito
     */
    boolean insertArea(AreaModel pAreaModel);
}
