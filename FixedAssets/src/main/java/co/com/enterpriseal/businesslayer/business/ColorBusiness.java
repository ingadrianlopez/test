package co.com.enterpriseal.businesslayer.business;

import java.util.List;
import co.com.enterpriseal.commons.model.ColorModel;
import co.com.enterpriseal.dataaccesslayer.dao.ColorDao;
import co.com.enterpriseal.dataaccesslayer.idao.IColorDao;
import java.io.IOException;

/**
 * Clase que maneja la logica de negocio de la tabla parametro colores
 * @since 2017-02-10
 * @author aye
 */
public class ColorBusiness {
	
    private final IColorDao colorDao;
    
    /**
     * Constructor
     */
    public ColorBusiness(){
        colorDao = new ColorDao();
    }
    
    /**
     * Lista los colores parametrizados en la bd
     * @return Listado con todos los colores
     * @throws IOException 
     */
    public List<ColorModel> listColor() throws IOException{
        return colorDao.listColor();
    }
    
    /**
     * Crea nuevo registro de colores
     * @param pColorModel Objeto ColorModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    public boolean insertColor(ColorModel pColorModel) throws IOException{
        if(pColorModel != null && pColorModel.getName() != null && pColorModel.getDescription() != null){
            return colorDao.insertColor(pColorModel);
        } else{
            return false;
        }
    }
}
