package co.com.enterpriseal.fixedassets.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.enterpriseal.fixedassets.persistence.model.FixedAssetsModel;

/**
 * Clase que implementa la interfaz RowMapper para el mapeo de los datos al objeto FixedAssetsModel
 * @since 2017-02-10
 * @author AdrianL
 */
public class FiexedAssetsHelper implements RowMapper<FixedAssetsModel> {

	/**
     * Implementa metodo mapRow para mapear el resultSet al objeto FixedAssetsModel
     * @param rs resultSet
     * @param i iteraciones
     * @return objeto FixedAssetsModel
     * @throws SQLException 
     */
	@Override
	public FixedAssetsModel mapRow(ResultSet rs, int i) throws SQLException {
		FixedAssetsModel assetsModel = new FixedAssetsModel();
        assetsModel.setInventoryNumber(rs.getInt("numero_inventario"));
        assetsModel.setSerial(rs.getString("serial"));
        assetsModel.setName(rs.getString("nombre"));
        assetsModel.setDescription(rs.getString("descripcion"));
        assetsModel.setWeight(rs.getBigDecimal("peso"));
        assetsModel.setHigh(rs.getBigDecimal("alto"));
        assetsModel.setWidth(rs.getBigDecimal("ancho"));
        assetsModel.setLength(rs.getBigDecimal("largo"));
        assetsModel.setValue(rs.getBigDecimal("valor"));
        assetsModel.setDateBuy(rs.getDate("fecha_compra"));
        assetsModel.setDischargeDate(rs.getDate("fecha_de_baja"));
        assetsModel.setState(rs.getInt("estado"));
        assetsModel.setActiveType(rs.getInt("tipo"));
        assetsModel.setColor(rs.getInt("color"));
        return assetsModel;
	}

}
