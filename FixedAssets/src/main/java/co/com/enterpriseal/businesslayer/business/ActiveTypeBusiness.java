package co.com.enterpriseal.businesslayer.business;

import java.util.List;
import co.com.enterpriseal.commons.model.ActiveTypeModel;
import co.com.enterpriseal.dataaccesslayer.dao.ActiveTypeDao;
import co.com.enterpriseal.dataaccesslayer.idao.IActiveTypeDao;
import java.io.IOException;

/**
 * Clase que maneja la logica de negocio de la tabla tipos de activo
 * @since 2017-02-10
 * @author aye
 */
public class ActiveTypeBusiness {
    
    private final IActiveTypeDao activeTypeDao;
    
    /**
     * Constructor
     */
    public ActiveTypeBusiness(){
        activeTypeDao = new ActiveTypeDao();
    }
    
    /**
     * Obtiene la lista de los tipos de activo
     * @return listado de los tipos de activo
     * @throws IOException 
     */
    public List<ActiveTypeModel> listActiveType() throws IOException{
        return activeTypeDao.listActiveType();
    }
    
    /**
     * Crea nuevo registro tipo de activo
     * @param pActiveTypeModel Objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    public boolean insertActiveType(ActiveTypeModel pActiveTypeModel) throws IOException{
        if(pActiveTypeModel != null && pActiveTypeModel.getName() != null && pActiveTypeModel.getDescription() != null){
            return activeTypeDao.insertActiveType(pActiveTypeModel);
        }else{
            return false;
        }
    }
}
