package co.com.enterpriseal.businesslayer.business;

import java.util.List;
import co.com.enterpriseal.commons.model.ActiveStatusModel;
import co.com.enterpriseal.dataaccesslayer.dao.ActiveStatusDao;
import co.com.enterpriseal.dataaccesslayer.idao.IActiveStatusDao;
import java.io.IOException;

/**
 * Clase que maneja la logica de negocio de la tabla estados activos
 * @since 2017-02-10
 * @author aye
 */
public class ActiveStatusBusiness {
	
    private final IActiveStatusDao statusDao;
    
    /**
     * Constructor
     */
    public ActiveStatusBusiness(){
        statusDao = new ActiveStatusDao();
    }
    
    /**
     * Obtiene la lista con los estados de los activos
     * @return listado de estados
     * @throws IOException 
     */
    public List<ActiveStatusModel> listActiveStatus() throws IOException{
        return statusDao.listActiveStatus();
    }
    
    /**
     * Crea nuevo estado activo
     * @param pStatusModel Objeto ActiveStatusModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    public boolean insertActiveStatus(ActiveStatusModel pStatusModel) throws IOException{
        if(pStatusModel != null && pStatusModel.getName() != null && pStatusModel.getDescription() != null){
            return statusDao.insertActiveStatus(pStatusModel);
        }else{
            return false;
        }
    }
}
