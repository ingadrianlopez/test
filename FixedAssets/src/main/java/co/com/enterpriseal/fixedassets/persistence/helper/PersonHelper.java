package co.com.enterpriseal.fixedassets.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.enterpriseal.fixedassets.persistence.model.PersonModel;

/**
 * Clase que implementa la interfaz RowMapper para el mapeo de los datos al objeto PersonModel
 * @author AdrianL
 */
public class PersonHelper implements RowMapper<PersonModel> {

	/**
     * Implementa metodo mapRow para mapear el resultSet al objeto PersonModel
     * @param rs resultSet
     * @param i iteraciones
     * @return objeto PersonModel
     * @throws SQLException 
     */
	@Override
	public PersonModel mapRow(ResultSet rs, int i) throws SQLException {
		PersonModel personModel = new PersonModel();
        personModel.setId(rs.getInt("id"));
        personModel.setIdentification(rs.getBigDecimal("identificacion"));
        personModel.setDocumentType(rs.getInt("tipo_ident"));
        personModel.setName(rs.getString("nombre"));
        personModel.setLastName(rs.getString("apellido"));
        return personModel;
	}

}
