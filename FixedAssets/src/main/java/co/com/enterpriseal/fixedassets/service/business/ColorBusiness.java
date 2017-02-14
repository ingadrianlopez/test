package co.com.enterpriseal.fixedassets.service.business;

import java.util.List;
import co.com.enterpriseal.fixedassets.persistence.model.ColorModel;
import co.com.enterpriseal.fixedassets.persistence.idao.IColorDao;
import co.com.enterpriseal.fixedassets.service.ibusiness.IColorBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que maneja la logica de negocio de la tabla parametro colores
 * @since 2017-02-10
 * @author aye
 */
@Service
public class ColorBusiness implements IColorBusiness {

    @Autowired
    IColorDao colorDao;
    
    /**
     * Lista los colores parametrizados en la bd
     * @return Listado con todos los colores
     */
    @Override
    public List<ColorModel> listColor(){
        return colorDao.listColor();
    }
    
    /**
     * Crea nuevo registro de colores
     * @param pColorModel Objeto ColorModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean insertColor(ColorModel pColorModel){
        if(pColorModel != null && pColorModel.getName() != null && pColorModel.getDescription() != null){
            return colorDao.insertColor(pColorModel);
        } else{
            return false;
        }
    }
}
