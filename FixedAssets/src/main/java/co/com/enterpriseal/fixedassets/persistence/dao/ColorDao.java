package co.com.enterpriseal.fixedassets.persistence.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.com.enterpriseal.fixedassets.persistence.model.ColorModel;
import co.com.enterpriseal.fixedassets.persistence.helper.ColorHelper;
import co.com.enterpriseal.fixedassets.persistence.idao.IColorDao;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase que maneja el acceso a datos de la tabla para_colo
 * @since 2017-02-10
 * @author AdrianL
 */
@Component
public class ColorDao implements IColorDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM PARA_COLO";
    private final static String SQL_INSERT = "INSERT INTO PARA_COLO(ID, NOMBRE, DESCRIPCION) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM PARA_COLO), ?, ?)";
    
    /**
     * Implementa el metodo listar colores
     * @return listado de colores
     */
    @Override
    public List<ColorModel> listColor() {
        return jdbcTemplate.query(SQL_SELECT, new ColorHelper());
    }

    /**
     * Implementa el metodo crear nuevo registro Color
     * @param pColorModel ColorModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean insertColor(ColorModel pColorModel) {
        jdbcTemplate.update(SQL_INSERT, new Object[]{pColorModel.getName(), pColorModel.getDescription()});
        return true;
    }

    /**
     * Implementa el metodo actualizar registro color
     * @param pColorModel objeto ColorModel
     * @return true si la operacion se completo con exito
     
     */
    @Override
    public boolean updateColor(ColorModel pColorModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementa el metodo eliminar registro color
     * @param pColorModel objeto ColorModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean deleteColor(ColorModel pColorModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
