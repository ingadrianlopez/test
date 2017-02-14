package co.com.enterpriseal.dataaccesslayer.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import co.com.enterpriseal.commons.model.PersonModel;
import co.com.enterpriseal.dataaccesslayer.helper.PersonHelper;
import co.com.enterpriseal.dataaccesslayer.idao.IPersonDao;
import co.com.enterpriseal.transverse.util.Util;
import java.io.IOException;

/**
 * Clase que maneja el acceso a datos de la tabla gest_pers
 *
 * @since 2017-02-10
 * @author AdrianL
 */
public class PersonDao implements IPersonDao {

    private JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM GEST_PERS";
    private final static String SQL_INSERT = "INSERT INTO GEST_PERS(ID, IDENTIFICACION, TIPO_IDENT, NOMBRE, APELLIDO) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM GEST_PERS), ?, ?, ?, ? )";

    /**
     * Implementa metodo listar personas
     *
     * @return listado de personas
     * @throws IOException
     */
    @Override
    public List<PersonModel> listPerson() throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        return jdbcTemplate.query(SQL_SELECT, new PersonHelper());
    }

    /**
     * Implementa metodo crear nueva persona
     *
     * @param pPersonModel Objeto personModel
     * @return true si la operacion se completo con exito
     * @throws IOException
     */
    @Override
    public boolean insertPerson(PersonModel pPersonModel) throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        jdbcTemplate.update(SQL_INSERT, new Object[]{pPersonModel.getIdentification(), pPersonModel.getDocumentType(),
            pPersonModel.getName(), pPersonModel.getLastName()});
        return true;
    }

    /**
     * Implementa metodo actualizar persona
     * @param pPersonModel Objeto personModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean updatePerson(PersonModel pPersonModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementa metodo eliminar persona
     * @param pPersonModel Objeto personModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean deletePerson(PersonModel pPersonModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
