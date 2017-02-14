package co.com.enterpriseal.fixedassets.service.business;

import java.util.List;
import co.com.enterpriseal.fixedassets.persistence.model.DocumentTypeModel;
import co.com.enterpriseal.fixedassets.persistence.idao.IDocumentTypeDao;
import co.com.enterpriseal.fixedassets.service.ibusiness.IDocumentTypeBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que maneja la logica de negocio de la tabla tipos de documentos
 * @since 2017-02-10
 * @author aye
 */
@Service
public class DocumentTypeBusiness implements IDocumentTypeBusiness{

    @Autowired
    IDocumentTypeDao documentTypeDao;
    
    /**
     * Obtiene los tipos de documentos parametrizados en la base de datos
     * @return listado de los tipos de documentos
     */
    @Override
    public List<DocumentTypeModel> listDocumentType(){
        return documentTypeDao.listDocumentType();
    }
    
    /**
     * Crea un nuevo registro en la tabla tipos documentos de la base de datos
     * @param pDocumentTypeModel Objeto DocumentTypeModel
     * @return true si la operacion se completo con exito
     */
    @Override
    public boolean insertDocumentType(DocumentTypeModel pDocumentTypeModel){
        if(pDocumentTypeModel != null && pDocumentTypeModel.getName() != null && pDocumentTypeModel.getDescription() != null){
            return documentTypeDao.insertDocumentType(pDocumentTypeModel);
        } else {
            return false;
        }
    }
}
