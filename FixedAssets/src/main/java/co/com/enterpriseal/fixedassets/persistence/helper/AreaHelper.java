package co.com.enterpriseal.fixedassets.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.enterpriseal.fixedassets.persistence.model.AreaModel;

/**
 * Clase que implementa la interfaz RowMapper para el mapeo de los datos al objeto AreaModel
 * @since 2017-02-10
 * @author AdrianL
 */
public class AreaHelper implements RowMapper<AreaModel> {

	/**
     * Implementa el objeto mapRow para el mapeo de los datos al objeto areamodel
     * @param rs resultSet
     * @param i iteraciones
     * @return objeto AreaModel
     * @throws SQLException 
     */
	@Override
	public AreaModel mapRow(ResultSet rs, int i) throws SQLException {
		AreaModel areaModel = new AreaModel();
        areaModel.setId(rs.getInt("id"));
        areaModel.setName(rs.getString("nombre"));
        areaModel.setDescription(rs.getString("descripcion"));
        areaModel.setCity(rs.getInt("ciudad"));
        return areaModel;
	}

}
