package co.com.enterpriseal.businesslayer.business;

import java.util.List;
import co.com.enterpriseal.commons.model.CityModel;
import co.com.enterpriseal.dataaccesslayer.dao.CityDao;
import co.com.enterpriseal.dataaccesslayer.idao.ICityDao;
import java.io.IOException;

/**
 * Clase que maneja la logica de negocio de la tabla Ciudades
 * @since 2017-02-10
 * @author aye
 */
public class CityBusiness {
    
    private final ICityDao cityDao;
    
    /**
     * Constructor
     */
    public CityBusiness(){
        cityDao = new CityDao();
    }
    
    /**
     * Obtiene el listado de ciudades parametrizadas en la base de datos
     * @return listado de ciudades
     * @throws IOException 
     */
    public List<CityModel> listCity() throws IOException{
        return cityDao.listArea();
    }
    
    /**
     * Crea una nueva ciudad en la base de datos
     * @param pCityModel Objeto CityModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    public boolean insertCity(CityModel pCityModel) throws IOException{
        if(pCityModel != null && pCityModel.getName() != null && pCityModel.getDescription() != null){
            return cityDao.insertCity(pCityModel);
        }else{
            return false;
        }
    }
}
