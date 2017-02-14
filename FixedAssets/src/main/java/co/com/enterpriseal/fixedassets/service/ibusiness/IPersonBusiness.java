package co.com.enterpriseal.fixedassets.service.ibusiness;

import co.com.enterpriseal.fixedassets.persistence.model.PersonModel;
import java.util.List;

/**
 * Especifica la implementacion de la clase IPersonBusiness
 * @since 2017-02-14
 * @author aye
 */
public interface IPersonBusiness {
    /**
     * Especifica el metodo listar personas de la base de datos
     * @return listado de PersonModel
     */
    List<PersonModel> listPerson();
    
    /**
     * Especifica el metodo crear nueva persona en la base de datos
     * @param pPersonModel Objeto PersonModel
     * @return true si la operacion se completo con exito
     */
    boolean insertPerson(PersonModel pPersonModel); 
}
