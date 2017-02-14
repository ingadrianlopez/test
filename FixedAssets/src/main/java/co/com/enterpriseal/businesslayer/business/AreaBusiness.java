package co.com.enterpriseal.businesslayer.business;

import java.util.List;
import co.com.enterpriseal.commons.model.AreaModel;
import co.com.enterpriseal.dataaccesslayer.dao.AreaDao;
import co.com.enterpriseal.dataaccesslayer.idao.IAreaDao;
import java.io.IOException;

/**
 * Clase que maneja que maneja la logica de negocio de la tabla Area
 * @since 2017-02-10
 * @author aye
 */
public class AreaBusiness {
	
    private final IAreaDao areaDao;
    
    /**
     * Constuctor
     */
    public AreaBusiness(){
        areaDao = new AreaDao();
    }
    
    /**
     * Obtiene las areas paremetrizadas en la base de datos
     * @return listado de areas
     * @throws IOException 
     */
    public List<AreaModel> listArea() throws IOException{
        return areaDao.listArea();
    }
    
    /**
     * crea una nueva area en la base de datos
     * @param pAreaModel objeto AreaModel
     * @return true si la operacion fue exitosa
     * @throws IOException 
     */
    public boolean insertArea(AreaModel pAreaModel) throws IOException{
        if (pAreaModel != null && pAreaModel.getName() != null && pAreaModel.getDescription() != null) {
            return areaDao.insertArea(pAreaModel);
        } else {
            return false;
        }
    }
}
