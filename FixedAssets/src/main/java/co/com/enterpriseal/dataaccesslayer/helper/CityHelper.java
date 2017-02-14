package co.com.enterpriseal.dataaccesslayer.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.enterpriseal.commons.model.CityModel;

/**
 * Clase que implementa la interfaz RowMapper para el mapeo de los datos al objeto CityModel
 * @since 2017-02-10
 * @author AdrianL
 */
public class CityHelper implements RowMapper<CityModel> {

	/**
     * Implementa metodo mapRow para mapear el resultSet al objeto CityModel
     * @param rs resultSet
     * @param i iteraciones
     * @return Objeto cityModel
     * @throws SQLException 
     */
	@Override
	public CityModel mapRow(ResultSet rs, int i) throws SQLException {
		CityModel cityModel = new CityModel();
        cityModel.setId(rs.getInt("id"));
        cityModel.setName(rs.getString("nombre"));
        cityModel.setDescription(rs.getString("descripcion"));
        return cityModel;
	}

}
