package co.com.enterpriseal.dataaccesslayer.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.com.enterpriseal.commons.model.FixedAssetsModel;
import co.com.enterpriseal.dataaccesslayer.helper.FiexedAssetsHelper;
import co.com.enterpriseal.dataaccesslayer.idao.IFixedAssetsDao;
import co.com.enterpriseal.transverse.util.Util;
import java.io.IOException;

/**
 * Clase maneja el acceso a datos de la tabla gest_acti
 * @since 2017-02-10
 * @author AdrianL
 */
@Component
public class FixedAssetsDao implements IFixedAssetsDao {
	
    private JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM GEST_ACTI";
    private final static String SQL_INSERT = "INSERT INTO GEST_ACTI(NUMERO_INVENTARIO, SERIAL, NOMBRE, "
            + "DESCRIPCION, PESO, ALTO, ANCHO, LARGO, VALOR, FECHA_COMPRA, ESTADO, TIPO, COLOR) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String SQL_UPDATE = "UPDATE GEST_ACTI SET NUMERO_INVENTARIO = ?, FECHA_DE_BAJA = ? "
            + "WHERE SERIAL = ?";
    
    /**
     * Implementa metodo obtener activos
     * @return Listado de los activos
     * @throws IOException 
     */
    @Override
    public List<FixedAssetsModel> listFixedAssets() throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        return jdbcTemplate.query(SQL_SELECT, new FiexedAssetsHelper());
    }

    /**
     * Implementa metodo crear nuevo activo
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean insertFixedAssets(FixedAssetsModel pFixedAssetsModel) throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        jdbcTemplate.update(SQL_INSERT, new Object[]{pFixedAssetsModel.getInventoryNumber(), 
            pFixedAssetsModel.getSerial().trim(),
            pFixedAssetsModel.getName().trim(), pFixedAssetsModel.getDescription().trim(), 
            pFixedAssetsModel.getWeight(),
            pFixedAssetsModel.getHigh(), pFixedAssetsModel.getWidth(), pFixedAssetsModel.getLength(),
            pFixedAssetsModel.getValue(), pFixedAssetsModel.getDateBuy(), pFixedAssetsModel.getState(),
            pFixedAssetsModel.getActiveType(), pFixedAssetsModel.getColor()});
        return true;
    }

    /**
     * Implementa metodo actualizar activo
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean updateFixedAssets(FixedAssetsModel pFixedAssetsModel) throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        jdbcTemplate.update(SQL_UPDATE, new Object[]{pFixedAssetsModel.getInventoryNumber(), pFixedAssetsModel.getDischargeDate(), pFixedAssetsModel.getSerial()});
        return true;
    }

    /**
     * Implementa metodo eliminar activo
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean deleteFixedAssets(FixedAssetsModel pFixedAssetsModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
