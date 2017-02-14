package co.com.enterpriseal.dataaccesslayer.dao;

import java.util.List;

import co.com.enterpriseal.commons.model.ActiveStatusModel;
import co.com.enterpriseal.dataaccesslayer.helper.ActiveStatusHelper;
import co.com.enterpriseal.dataaccesslayer.idao.IActiveStatusDao;
import co.com.enterpriseal.transverse.util.Util;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Clase que maneja el acceso a los datos de la tabla para_est_acti
 * @since 2017-02-10
 * @author aye
 */
public class ActiveStatusDao implements IActiveStatusDao {

    private JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM PARA_ESTA_ACTI";
    private final static String SQL_INSERT = "INSERT INTO PARA_ESTA_ACTI(ID, NOMBRE, DESCRIPCION) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM PARA_ESTA_ACTI), ?, ?)";

    /**
     * Implementa el metodo listar estados de activo
     * @return Lista de estados de activo
     * @throws IOException 
     */
    @Override
    public List<ActiveStatusModel> listActiveStatus() throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        return jdbcTemplate.query(SQL_SELECT, new ActiveStatusHelper());
    }

    /**
     * Implementa metodo registrar un estado de activo
     *
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion fue exitosa
     * @throws IOException
     */
    @Override
    public boolean insertActiveStatus(ActiveStatusModel pStatusModel) throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        jdbcTemplate.update(SQL_INSERT, new Object[]{pStatusModel.getName(), pStatusModel.getDescription()});
        return true;
    }

    /**
     * Implementa el metodo actualizar registro estado activo
     *
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion fue exitosa
     * @throws IOException
     */
    @Override
    public boolean updateActiveStatus(ActiveStatusModel pStatusModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementa el metodo eliminar registro estado activo
     *
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion fue exitosa
     * @throws IOException
     */
    @Override
    public boolean deleteActiveStatus(ActiveStatusModel pStatusModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
