package co.com.enterpriseal.fixedassets.persistence.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import co.com.enterpriseal.fixedassets.persistence.model.PersonModel;
import co.com.enterpriseal.fixedassets.persistence.helper.PersonHelper;
import co.com.enterpriseal.fixedassets.persistence.idao.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase que maneja el acceso a datos de la tabla gest_pers
 * @since 2017-02-10
 * @author AdrianL
 */
@Component
public class PersonDao implements IPersonDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM GEST_PERS";
    private final static String SQL_INSERT = "INSERT INTO GEST_PERS(ID, IDENTIFICACION, TIPO_IDENT, NOMBRE, APELLIDO) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM GEST_PERS), ?, ?, ?, ? )";

    /**
     * Implementa metodo listar personas
     * @return listado de personas
     */
    @Override
    public List<PersonModel> listPerson() {
        return jdbcTemplate.query(SQL_SELECT, new PersonHelper());
    }

    /**
     * Implementa metodo crear nueva persona
     * @param pPersonModel Objeto personModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean insertPerson(PersonModel pPersonModel) {
        jdbcTemplate.update(SQL_INSERT, new Object[]{pPersonModel.getIdentification(), pPersonModel.getDocumentType(),
            pPersonModel.getName(), pPersonModel.getLastName()});
        return true;
    }

    /**
     * Implementa metodo actualizar persona
     * @param pPersonModel Objeto personModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean updatePerson(PersonModel pPersonModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementa metodo eliminar persona
     * @param pPersonModel Objeto personModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean deletePerson(PersonModel pPersonModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
