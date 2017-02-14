package co.com.enterpriseal.fixedassets.persistence.dao;

import java.util.List;

import co.com.enterpriseal.fixedassets.persistence.model.ActiveStatusModel;
import co.com.enterpriseal.fixedassets.persistence.helper.ActiveStatusHelper;
import co.com.enterpriseal.fixedassets.persistence.idao.IActiveStatusDao;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Clase que maneja el acceso a los datos de la tabla para_est_acti
 * @since 2017-02-10
 * @author aye
 */
@Component
public class ActiveStatusDao implements IActiveStatusDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM PARA_ESTA_ACTI";
    private final static String SQL_INSERT = "INSERT INTO PARA_ESTA_ACTI(ID, NOMBRE, DESCRIPCION) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM PARA_ESTA_ACTI), ?, ?)";

    /**
     * Implementa el metodo listar estados de activo
     * @return Lista de estados de activo
     */
    @Override
    public List<ActiveStatusModel> listActiveStatus() {
        return jdbcTemplate.query(SQL_SELECT, new ActiveStatusHelper());
    }

    /**
     * Implementa metodo registrar un estado de activo
     *
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion fue exitosa
     */
    @Override
    public boolean insertActiveStatus(ActiveStatusModel pStatusModel) {
        jdbcTemplate.update(SQL_INSERT, new Object[]{pStatusModel.getName(), pStatusModel.getDescription()});
        return true;
    }

    /**
     * Implementa el metodo actualizar registro estado activo
     *
     * @param pStatusModel objeto ActiveStatusModel
     * @return true si la operacion fue exitosa
     */
    @Override
    public boolean updateActiveStatus(ActiveStatusModel pStatusModel) {
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
    public boolean deleteActiveStatus(ActiveStatusModel pStatusModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
