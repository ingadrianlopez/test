package co.com.enterpriseal.fixedassets.service.ibusiness;

import co.com.enterpriseal.fixedassets.persistence.model.ColorModel;
import java.util.List;

/**
 * Especifica la implementacion de la clase IColorBusiness
 * @since 2017-02-14
 * @author aye
 */
public interface IColorBusiness {
    /**
     * Especifica el metodo listar colores
     * @return listado de los colores
     */
    List<ColorModel> listColor();
    
    /**
     * Especifica el metodo crear nuevo registro color
     * @param pColorModel objeto ColorModel
     * @return
     */
    boolean insertColor(ColorModel pColorModel);
}
