package co.com.enterpriseal.servicehost.service;

import co.com.enterpriseal.businesslayer.business.ActiveStatusBusiness;
import co.com.enterpriseal.businesslayer.business.ActiveTypeBusiness;
import co.com.enterpriseal.businesslayer.business.CityBusiness;
import co.com.enterpriseal.businesslayer.business.ColorBusiness;
import co.com.enterpriseal.businesslayer.business.DocumentTypeBusiness;
import co.com.enterpriseal.commons.model.ActiveStatusModel;
import co.com.enterpriseal.commons.model.ActiveTypeModel;
import co.com.enterpriseal.commons.model.CityModel;
import co.com.enterpriseal.commons.model.ColorModel;
import co.com.enterpriseal.commons.model.DocumentTypeModel;
import co.com.enterpriseal.transverse.util.Logger;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Host que le da salida a los servicios de las tablas parametros
 * @since 2017-02-10
 * @author aye
 */
@RestController
public class SettingsService {

    private final ActiveStatusBusiness statusBusiness;
    private final ActiveTypeBusiness typeBusiness;
    private final ColorBusiness colorBusiness;
    private final CityBusiness cityBusiness;
    private final DocumentTypeBusiness documentTypeBusiness;

    /**
     * Constructor
     */
    public SettingsService() {
        statusBusiness = new ActiveStatusBusiness();
        typeBusiness = new ActiveTypeBusiness();
        colorBusiness = new ColorBusiness();
        cityBusiness = new CityBusiness();
        documentTypeBusiness = new DocumentTypeBusiness();
    }

    /**
     * Servicio que obtiene los estados de activos
     * @return Objeto ResponseEntity completo con exito
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/listActiveStatus", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listActiveStatus() {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            List<ActiveStatusModel> listStatus = statusBusiness.listActiveStatus();
            if (listStatus != null && listStatus.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listStatus, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listActiveStatus");
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listActiveStatus");
        }
        return responseEntity;
    }

    /**
     * Crea nuevo registro de estados de activo
     * @param pActiveStatusModel Objeto ActiveStatusModel
     * @return objeto ActiveStatusModel
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/insertActiveStatus", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity insertActiveStatus(@RequestBody ActiveStatusModel pActiveStatusModel) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean resp = statusBusiness.insertActiveStatus(pActiveStatusModel);
            if (resp) {
                headers.set("myResponse", "La operacion se realizo con exito.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.OK); // 200
            }else{
                headers.set("myResponse", "Faltan datos para crear un estado de activo.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); // 400
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "insertActiveStatus");
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "insertActiveStatus");
        }
        return responseEntity;
    }

    /**
     * Lista los tipos de activos parametrizado en el sistema
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/listActiveType", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listActiveType() {
        ResponseEntity responseEntity;
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            List<ActiveTypeModel> listActiveType = typeBusiness.listActiveType();
            if (listActiveType != null && listActiveType.size() > 0) {
                responseHeaders.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listActiveType, responseHeaders, HttpStatus.OK); // 200
            } else {
                responseHeaders.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(responseHeaders, HttpStatus.NOT_FOUND); // 404
            }
        } catch (IOException ex) {
            responseHeaders.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listActiveType");
        } catch (Exception ex) {
            responseHeaders.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listActiveType");
        }
        return responseEntity;
    }
    
    /**
     * Crea un nuevo registro de tipo de activo
     * @param pActiveTypeModel Objeto ActiveTypeModel
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/insertActiveType", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity insertActiveType(@RequestBody ActiveTypeModel pActiveTypeModel) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean resp = typeBusiness.insertActiveType(pActiveTypeModel);
            if (resp) {
                headers.set("myResponse", "La operacion se realizo con exito.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "Faltan datos para crear un tipo de activo.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); // 400
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, ex.getStackTrace()[0].getClassName(), ex.getStackTrace()[0].getMethodName());
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "insertActiveType");
        }
        return responseEntity;
    }

    /**
     * Lista los colores parametrizados en el sistema
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/listColor", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listColor() {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            List<ColorModel> listColor = colorBusiness.listColor();
            if (listColor != null && listColor.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listColor, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listColor");
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listColor");
        }
        return responseEntity;
    }
    
    /**
     * Crea un nuevo registro en la tabla de parametros de colores
     * @param pColorModel Objeto ColorModel
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/insertColor", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity insertColor(@RequestBody ColorModel pColorModel) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean resp = colorBusiness.insertColor(pColorModel);
            if (resp) {
                headers.set("myResponse", "La operacion se realizo con exito.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "Faltan datos para crear un color.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); // 400
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "insertColor");
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "insertColor");
        }
        return responseEntity;
    }

    /**
     * Lista las ciudades parametrizadas en el sistema
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/listCity", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listCity() {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            List<CityModel> listCity = cityBusiness.listCity();
            if (listCity != null && listCity.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listCity, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listCity");
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listCity");
        }
        return responseEntity;
    }

    /**
     * Crea un nuevo registro en la tabla de parametros ciudad
     * @param pCityModel Objeto CityModel
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/insertCity", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity insertCity(@RequestBody CityModel pCityModel) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean resp = cityBusiness.insertCity(pCityModel);
            if (resp) {
                headers.set("myResponse", "La operacion se realizo con exito.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "Faltan datos para crear ciudad.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); // 400
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "insertCity");
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "insertCity");
        }
        return responseEntity;
    }
    
    /**
     * Lista los tipos de documentos parametrizadas en el sistema
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/listDocumentType", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listDocumentType() {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            List<DocumentTypeModel> listDocumentType = documentTypeBusiness.listDocumentType();
            if (listDocumentType != null && listDocumentType.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listDocumentType, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listDocumentType");
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "listDocumentType");
        }
        return responseEntity;
    }

    /**
     * Crea un nuevo registro en la tabla de parametros tipos documentos
     * @param pDocumentTypeModel Objeto DocumentTypeModel
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/para/insertDocumentType", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity insertDocumentType(@RequestBody DocumentTypeModel pDocumentTypeModel) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean resp = documentTypeBusiness.insertDocumentType(pDocumentTypeModel);
            if (resp) {
                headers.set("myResponse", "La operacion se realizo con exito.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "Faltan datos para crear tipo documento.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); // 400
            }
        } catch (IOException ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "insertDocumentType");
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            Logger.writeError(ex.getMessage(), 0, "Service", "insertDocumentType");
        }
        return responseEntity;
    }
}
