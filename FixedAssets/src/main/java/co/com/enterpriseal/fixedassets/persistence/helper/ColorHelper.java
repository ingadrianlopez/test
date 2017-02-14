package co.com.enterpriseal.fixedassets.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.enterpriseal.fixedassets.persistence.model.ColorModel;

/**
 * Clase que implementa la interfaz RowMapper para el mapeo de los datos al objeto ColorModel
 * @since 2017-02-10
 * @author AdrianL
 */
public class ColorHelper implements RowMapper<ColorModel> {

	/**
     * Mapea el objeto resultSet al objeto ColorModel
     * @param rs objeto resultSet
     * @param i iteraciones
     * @return objeto ColorModel
     * @throws SQLException
     */
	@Override
	public ColorModel mapRow(ResultSet rs, int i) throws SQLException {
		ColorModel colorModel = new ColorModel();
        colorModel.setId(rs.getInt("id"));
        colorModel.setName(rs.getString("nombre"));
        colorModel.setDescription(rs.getString("descripcion"));
        return colorModel;
	}

}
