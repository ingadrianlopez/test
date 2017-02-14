package co.com.enterpriseal.fixedassets.service.business;

import java.util.List;
import co.com.enterpriseal.fixedassets.persistence.model.AreaModel;
import co.com.enterpriseal.fixedassets.persistence.idao.IAreaDao;
import co.com.enterpriseal.fixedassets.service.ibusiness.IAreaBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que maneja que maneja la logica de negocio de la tabla Area
 * @since 2017-02-10
 * @author aye
 */
@Service
public class AreaBusiness implements IAreaBusiness{
    @Autowired
    IAreaDao areaDao;
    
    /**
     * Obtiene las areas paremetrizadas en la base de datos
     * @return listado de areas
     */
    @Override
    public List<AreaModel> listArea(){
        return areaDao.listArea();
    }
    
    /**
     * crea una nueva area en la base de datos
     * @param pAreaModel objeto AreaModel
     * @return true si la operacion fue exitosa
     */
    @Override
    public boolean insertArea(AreaModel pAreaModel){
        if (pAreaModel != null && pAreaModel.getName() != null && pAreaModel.getDescription() != null) {
            return areaDao.insertArea(pAreaModel);
        } else {
            return false;
        }
    }
}
