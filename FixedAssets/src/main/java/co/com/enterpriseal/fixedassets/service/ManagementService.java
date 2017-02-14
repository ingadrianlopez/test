package co.com.enterpriseal.fixedassets.service;


import co.com.enterpriseal.fixedassets.service.business.FixedAssetsBusiness;
import co.com.enterpriseal.fixedassets.service.ibusiness.IFixedAssetsBusiness;
import co.com.enterpriseal.fixedassets.persistence.model.AreaModel;
import co.com.enterpriseal.fixedassets.persistence.model.FixedAssetsModel;
import co.com.enterpriseal.fixedassets.persistence.model.PersonModel;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Host que le da salida a los servicios de las tablas gestion
 * @since 2017-02-10
 * @author aye
 */
@RestController
public class ManagementService {
    
    @Autowired
    IFixedAssetsBusiness assetsBusiness;
   
    /**
     * Obtiene listado de activos
     * @return objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/listFixedAssets", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listFixedAssets() {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            List<FixedAssetsModel> listFixedAssets = assetsBusiness.listFixedAssets();
            if (listFixedAssets != null && listFixedAssets.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listFixedAssets, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "listFixedAssets");
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "listFixedAssets");
        }
        return responseEntity;
    }
    
    
}
