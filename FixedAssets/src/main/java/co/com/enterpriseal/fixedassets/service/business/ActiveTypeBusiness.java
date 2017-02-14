package co.com.enterpriseal.fixedassets.service.business;

import java.util.List;
import co.com.enterpriseal.fixedassets.persistence.model.ActiveTypeModel;
import co.com.enterpriseal.fixedassets.persistence.idao.IActiveTypeDao;
import co.com.enterpriseal.fixedassets.service.ibusiness.IActiveTypeBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que maneja la logica de negocio de la tabla tipos de activo
 * @since 2017-02-10
 * @author aye
 */
@Service
public class ActiveTypeBusiness implements IActiveTypeBusiness{
    
    @Autowired
    IActiveTypeDao activeTypeDao;
    
    /**
     * Obtiene la lista de los tipos de activo
     * @return listado de los tipos de activo
     */
    @Override
    public List<ActiveTypeModel> listActiveType(){
        return activeTypeDao.listActiveType();
    }
    
    /**
     * Crea nuevo registro tipo de activo
     * @param pActiveTypeModel Objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean insertActiveType(ActiveTypeModel pActiveTypeModel){
        if(pActiveTypeModel != null && pActiveTypeModel.getName() != null && pActiveTypeModel.getDescription() != null){
            return activeTypeDao.insertActiveType(pActiveTypeModel);
        }else{
            return false;
        }
    }
}
