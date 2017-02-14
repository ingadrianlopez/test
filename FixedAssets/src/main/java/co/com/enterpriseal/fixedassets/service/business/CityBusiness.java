package co.com.enterpriseal.fixedassets.service.business;

import java.util.List;
import co.com.enterpriseal.fixedassets.persistence.model.CityModel;
import co.com.enterpriseal.fixedassets.persistence.idao.ICityDao;
import co.com.enterpriseal.fixedassets.service.ibusiness.ICityBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que maneja la logica de negocio de la tabla Ciudades
 * @since 2017-02-10
 * @author aye
 */
@Service
public class CityBusiness implements ICityBusiness {
    @Autowired
    ICityDao cityDao;
    
    /**
     * Obtiene el listado de ciudades parametrizadas en la base de datos
     * @return listado de ciudades
     */
    @Override
    public List<CityModel> listCity(){
        return cityDao.listCity();
    }
    
    /**
     * Crea una nueva ciudad en la base de datos
     * @param pCityModel Objeto CityModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean insertCity(CityModel pCityModel){
        if(pCityModel != null && pCityModel.getName() != null && pCityModel.getDescription() != null){
            return cityDao.insertCity(pCityModel);
        }else{
            return false;
        }
    }
}
