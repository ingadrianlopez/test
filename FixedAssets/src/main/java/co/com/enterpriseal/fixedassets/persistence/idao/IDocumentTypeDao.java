package co.com.enterpriseal.fixedassets.persistence.idao;

import java.util.List;

import co.com.enterpriseal.fixedassets.persistence.model.DocumentTypeModel;
import java.io.IOException;

/**
 * Interfaz que especifica la implemtacion de la clase DocumentTypeDao
 * @since 2017-02-10
 * @author AdrianL
 */
public interface IDocumentTypeDao {
    /**
     * Especifica metodo Listar los tipos de documentos de la base de datos
     * @return listado de los tipos de documentos
     */
    List<DocumentTypeModel> listDocumentType();
    
    /**
     * Especifica metodo Crear un nuevo tipo documento en la base de datos
     * @param pDocumentTypeModel
     * @return true si la operacion se completo con exito
     */
    boolean insertDocumentType(DocumentTypeModel pDocumentTypeModel);
    
    /**
     * Especifica metodo actualizar tipo documento en la base de datos
     * @param pDocumentTypeModel
     * @return true si la operacion se completo con exito
     */
    boolean updateDocumentType(DocumentTypeModel pDocumentTypeModel);
    
    /**
     * Especifica metodo eliminar tipo documento en la base de datos
     * @param pDocumentTypeModel
     * @return true si la operacion se completo con exito
     */
    boolean deleteDocumentType(DocumentTypeModel pDocumentTypeModel);
}
