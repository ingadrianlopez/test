package co.com.enterpriseal.fixedassets.service.ibusiness;

import co.com.enterpriseal.fixedassets.persistence.model.DocumentTypeModel;
import java.util.List;

/**
 * Especifica la implemetacion de la clase DocumentTypeBusiness
 * @since 
 * @author aye
 */
public interface IDocumentTypeBusiness {
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
}
