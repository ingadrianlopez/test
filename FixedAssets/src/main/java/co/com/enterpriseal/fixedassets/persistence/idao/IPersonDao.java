package co.com.enterpriseal.fixedassets.persistence.idao;

import java.util.List;

import co.com.enterpriseal.fixedassets.persistence.model.PersonModel;
import java.io.IOException;

/**
 * Interface que especifica la implementacion de la clase PersonDao
 * @since 2017-02-10
 * @author AdrianL
 */
public interface IPersonDao {
	/**
     * Especifica el metodo listar personas de la base de datos
     * @return listado de PersonModel
     * @throws IOException 
     */
    List<PersonModel> listPerson() throws IOException;
    
    /**
     * Especifica el metodo crear nueva persona en la base de datos
     * @param pPersonModel Objeto PersonModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean insertPerson(PersonModel pPersonModel) throws IOException;
    
    /**
     * Especifica el metodo actualizar persona en la base de datos
     * @param pPersonModel Objeto PersonModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean updatePerson(PersonModel pPersonModel) throws IOException;
    
    /**
     * Especifica el metodo eliminar persona en la base de datos
     * @param pPersonModel Objeto PersonModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean deletePerson(PersonModel pPersonModel) throws IOException;
}
