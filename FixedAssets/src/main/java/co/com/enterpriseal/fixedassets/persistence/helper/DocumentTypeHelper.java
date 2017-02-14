package co.com.enterpriseal.fixedassets.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.enterpriseal.fixedassets.persistence.model.DocumentTypeModel;

/**
 * Clase que implementa la interfaz RowMapper para el mapeo de los datos al
 * objeto DocumentTypeModel
 * @since 2017-02-10
 * @author AdrianL
 */
public class DocumentTypeHelper implements RowMapper<DocumentTypeModel> {

	/**
     * Implementa metodo mapRow para mapear el resultSet al objeto DocumentTypeModel
     * @param rs resultSet
     * @param i iteraciones
     * @return objeto DocumentTypeModel
     * @throws SQLException
     */
	@Override
	public DocumentTypeModel mapRow(ResultSet rs, int i) throws SQLException {
		DocumentTypeModel typeModel = new DocumentTypeModel();
        typeModel.setId(rs.getInt("id"));
        typeModel.setName(rs.getString("nombre"));
        typeModel.setDescription(rs.getString("descripcion"));
        return typeModel;
	}

}
