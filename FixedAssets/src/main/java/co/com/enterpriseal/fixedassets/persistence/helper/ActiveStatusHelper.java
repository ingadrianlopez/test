package co.com.enterpriseal.fixedassets.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.enterpriseal.fixedassets.persistence.model.ActiveStatusModel;

/**
 * Clase que implementa la interfaz RowMapper para el mapeo de los datos al objeto ActiveStatusModel
 * @since 2017-02-10
 * @author AdrianL
 */
public class ActiveStatusHelper implements RowMapper<ActiveStatusModel>{

	/**
     * Implementa el metodo mapRow para mapear el objeto resultSet al objeto ActiveStatusModel
     * @param rs objeto resultSet
     * @param i iteraciones
     * @return objeto ActiveStatusModel
     * @throws SQLException 
     */
    @Override
    public ActiveStatusModel mapRow(ResultSet rs, int i) throws SQLException {
        ActiveStatusModel statusModel = new ActiveStatusModel();
        statusModel.setId(rs.getInt("id"));
        statusModel.setName(rs.getString("nombre"));
        statusModel.setDescription(rs.getString("descripcion"));
        return statusModel;
    }

}
