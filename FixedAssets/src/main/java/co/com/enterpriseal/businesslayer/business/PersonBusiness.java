package co.com.enterpriseal.businesslayer.business;

import java.util.List;
import co.com.enterpriseal.commons.model.PersonModel;
import co.com.enterpriseal.dataaccesslayer.dao.PersonDao;
import co.com.enterpriseal.dataaccesslayer.idao.IPersonDao;
import java.io.IOException;

/**
 * Clase que maneja la logica de negocio de la tabla personas
 * @since 2017-02-11
 * @author aye
 */
public class PersonBusiness {
    private final IPersonDao personDao;

    /**
     * Constructor
     */
    public PersonBusiness() {
        personDao = new PersonDao();
    }
    
    /**
     * Obtiene listado de personas
     * @return listado de personas
     * @throws IOException 
     */
    public List<PersonModel> listPerson() throws IOException{
        return personDao.listPerson();
    }
    
    /**
     * Crea nuevo registro de persona
     * @param pPersonModel Objeto PersonModel
     * @return true si la operacion se completo con exito, false si faltan datos para el insert
     * @throws IOException 
     */
    public boolean insertPerson(PersonModel pPersonModel) throws IOException{
        if(pPersonModel != null && pPersonModel.getIdentification() != null && pPersonModel.getDocumentType() > 0
                && pPersonModel.getName() != null && pPersonModel.getLastName() != null){
            return personDao.insertPerson(pPersonModel);
        }else
            return false;
    }
}
