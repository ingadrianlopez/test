package co.com.enterpriseal.fixedassets.persistence.idao;

import java.util.List;

import co.com.enterpriseal.fixedassets.persistence.model.ColorModel;
import java.io.IOException;

/**
 * Interfaz que especifica la implementacion de la clase ColorDao
 * @since 2017-02-10
 * @author AdrianL
 */
public interface IColorDao {
    /**
     * Especifica el metodo listar colores
     * @return listado de los colores
     * @throws IOException 
     */
    List<ColorModel> listColor() throws IOException;
    
    /**
     * Especifica el metodo crear nuevo registro color
     * @param pColorModel objeto ColorModel
     * @return
     * @throws IOException 
     */
    boolean insertColor(ColorModel pColorModel) throws IOException;
    
    /**
     * Especifica el metodo actualizar registro color
     * @param pColorModel objeto ColorModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean updateColor(ColorModel pColorModel) throws IOException;
    
    /**
     * Especifica el metodo eliminar registro color
     * @param pColorModel objeto ColorModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean deleteColor(ColorModel pColorModel) throws IOException;
}
