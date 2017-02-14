package co.com.enterpriseal.fixedassets.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.enterpriseal.fixedassets.persistence.model.ActiveTypeModel;

/**
 * Clase que implementa la interfaz RowMapper para el mapeo de los datos al objeto ActiveTypeModel
 * @since 2017-02-10
 * @author AdrianL
 */
public class ActiveTypeHelper implements RowMapper<ActiveTypeModel> {

	/**
     * Mapea el objeto resultset al objeto ActiveTypeModel
     * @param rs objeto resultSet
     * @param i iteraciones
     * @return objeto ActiveTypeModel
     * @throws SQLException 
     */
	@Override
	public ActiveTypeModel mapRow(ResultSet rs, int i) throws SQLException {
		ActiveTypeModel typeModel = new ActiveTypeModel();
        typeModel.setId(rs.getInt("id"));
        typeModel.setName(rs.getString("nombre"));
        typeModel.setDescription(rs.getString("descripcion"));
        return typeModel;
	}

}
