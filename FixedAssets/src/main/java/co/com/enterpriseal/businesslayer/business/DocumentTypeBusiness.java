package co.com.enterpriseal.businesslayer.business;

import java.io.IOException;
import java.util.List;

import co.com.enterpriseal.commons.model.DocumentTypeModel;
import co.com.enterpriseal.dataaccesslayer.dao.DocumentTypeDao;
import co.com.enterpriseal.dataaccesslayer.idao.IDocumentTypeDao;

/**
 * Clase que maneja la logica de negocio de la tabla tipos de documentos
 * @since 2017-02-10
 * @author aye
 */
public class DocumentTypeBusiness {
	
    private final IDocumentTypeDao documentTypeDao;

    /**
     * Constructor
     */
    public DocumentTypeBusiness() {
        documentTypeDao = new DocumentTypeDao();
    }
    
    /**
     * Obtiene los tipos de documentos parametrizados en la base de datos
     * @return listado de los tipos de documentos
     * @throws IOException 
     */
    public List<DocumentTypeModel> listDocumentType() throws IOException{
        return documentTypeDao.listDocumentType();
    }
    
    /**
     * Crea un nuevo registro en la tabla tipos documentos de la base de datos
     * @param pDocumentTypeModel Objeto DocumentTypeModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    public boolean insertDocumentType(DocumentTypeModel pDocumentTypeModel) throws IOException{
        if(pDocumentTypeModel != null && pDocumentTypeModel.getName() != null && pDocumentTypeModel.getDescription() != null){
            return documentTypeDao.insertDocumentType(pDocumentTypeModel);
        } else {
            return false;
        }
    }
}
