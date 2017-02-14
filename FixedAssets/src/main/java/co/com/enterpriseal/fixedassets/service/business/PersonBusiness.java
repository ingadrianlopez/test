package co.com.enterpriseal.fixedassets.service.business;

import java.util.List;
import co.com.enterpriseal.fixedassets.persistence.model.PersonModel;
import co.com.enterpriseal.fixedassets.persistence.idao.IPersonDao;
import co.com.enterpriseal.fixedassets.service.ibusiness.IPersonBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que maneja la logica de negocio de la tabla personas
 * @since 2017-02-11
 * @author aye
 */
@Service
public class PersonBusiness implements IPersonBusiness {
    @Autowired
    IPersonDao personDao;

    /**
     * Obtiene listado de personas
     * @return listado de personas
     */
    @Override
    public List<PersonModel> listPerson(){
        return personDao.listPerson();
    }
    
    /**
     * Crea nuevo registro de persona
     * @param pPersonModel Objeto PersonModel
     * @return true si la operacion se completo con exito, false si faltan datos para el insert
     */
    @Override
    public boolean insertPerson(PersonModel pPersonModel) {
        if(pPersonModel != null && pPersonModel.getIdentification() != null && pPersonModel.getDocumentType() > 0
                && pPersonModel.getName() != null && pPersonModel.getLastName() != null){
            return personDao.insertPerson(pPersonModel);
        }else
            return false;
    }
}
