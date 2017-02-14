package co.com.enterpriseal.dataaccesslayer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.com.enterpriseal.commons.model.DocumentTypeModel;
import co.com.enterpriseal.dataaccesslayer.helper.DocumentTypeHelper;
import co.com.enterpriseal.dataaccesslayer.idao.IDocumentTypeDao;
import co.com.enterpriseal.transverse.util.Util;
import java.io.IOException;

/**
 * Clase que mapea el acceso a datos de la tabla param_tipo_docu
 * @since 2017-02-10
 * @author AdrianL
 */
@Component
public class DocumentTypeDao implements IDocumentTypeDao {
	
    private JdbcTemplate jdbcTemplate;
    private final static String SQL_SELECT = "SELECT * FROM PARA_TIPO_IDEN";
    private final static String SQL_INSERT = "INSERT INTO PARA_TIPO_IDEN(ID, NOMBRE, DESCRIPCION) "
            + "VALUES ((SELECT (CASE WHEN MAX(ID) IS NULL THEN 1 ELSE (MAX(ID) + 1) END) FROM PARA_TIPO_IDEN), ?, ?)";
    
    /**
     * Implementa metodo listar tipos documentos de la base de datos
     * @return listado con los tipos de documentos parametrizados en la base de datos
     * @throws IOException 
     */
    @Override
    public List<DocumentTypeModel> listDocumentType() throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        return jdbcTemplate.query(SQL_SELECT, new DocumentTypeHelper());
    }

    /**
     * Implementa metodo crear nuevo tipo documento en la base de datos
     * @param pDocumentTypeModel Objeto DocumentTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean insertDocumentType(DocumentTypeModel pDocumentTypeModel) throws IOException {
        jdbcTemplate = new JdbcTemplate(Util.getDataSource());
        jdbcTemplate.update(SQL_INSERT, new Object[]{pDocumentTypeModel.getName(), pDocumentTypeModel.getDescription()});
        return true;
    }

    /**
     * Implementa metodo actualizar tipo documento
     * @param pDocumentTypeModel Objeto DocumentTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean updateDocumentType(DocumentTypeModel pDocumentTypeModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implementa metodo eliminar tipo documento
     * @param pDocumentTypeModel Objeto DocumentTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    @Override
    public boolean deleteDocumentType(DocumentTypeModel pDocumentTypeModel) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
