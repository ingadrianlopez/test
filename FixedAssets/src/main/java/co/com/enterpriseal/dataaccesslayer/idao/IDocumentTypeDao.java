package co.com.enterpriseal.dataaccesslayer.idao;

import java.util.List;

import co.com.enterpriseal.commons.model.DocumentTypeModel;
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
     * @throws IOException 
     */
    List<DocumentTypeModel> listDocumentType() throws IOException;
    
    /**
     * Especifica metodo Crear un nuevo tipo documento en la base de datos
     * @param pDocumentTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean insertDocumentType(DocumentTypeModel pDocumentTypeModel) throws IOException;
    
    /**
     * Especifica metodo actualizar tipo documento en la base de datos
     * @param pDocumentTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean updateDocumentType(DocumentTypeModel pDocumentTypeModel) throws IOException;
    
    /**
     * Especifica metodo eliminar tipo documento en la base de datos
     * @param pDocumentTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean deleteDocumentType(DocumentTypeModel pDocumentTypeModel) throws IOException;
}
