package co.com.enterpriseal.fixedassets.service.business;

import java.util.List;
import co.com.enterpriseal.fixedassets.persistence.model.ActiveStatusModel;
import co.com.enterpriseal.fixedassets.persistence.dao.ActiveStatusDao;
import co.com.enterpriseal.fixedassets.persistence.idao.IActiveStatusDao;
import co.com.enterpriseal.fixedassets.service.ibusiness.IActiveStatusBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que maneja la logica de negocio de la tabla estados activos
 * @since 2017-02-10
 * @author aye
 */
@Service
public class ActiveStatusBusiness implements IActiveStatusBusiness{
	
    @Autowired
    IActiveStatusDao statusDao;
    
    /**
     * Constructor
     */
    public ActiveStatusBusiness(){
        statusDao = new ActiveStatusDao();
    }
    
    /**
     * Obtiene la lista con los estados de los activos
     * @return listado de estados
     */
    @Override
    public List<ActiveStatusModel> listActiveStatus() {
        return statusDao.listActiveStatus();
    }
    
    /**
     * Crea nuevo estado activo
     * @param pStatusModel Objeto ActiveStatusModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean insertActiveStatus(ActiveStatusModel pStatusModel) {
        if(pStatusModel != null && pStatusModel.getName() != null && pStatusModel.getDescription() != null){
            return statusDao.insertActiveStatus(pStatusModel);
        }else{
            return false;
        }
    }
}
