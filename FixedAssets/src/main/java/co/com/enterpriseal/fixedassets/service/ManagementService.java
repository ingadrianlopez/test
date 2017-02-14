package co.com.enterpriseal.fixedassets.service;

import co.com.enterpriseal.fixedassets.service.ibusiness.IFixedAssetsBusiness;
import co.com.enterpriseal.fixedassets.persistence.model.AreaModel;
import co.com.enterpriseal.fixedassets.persistence.model.FixedAssetsModel;
import co.com.enterpriseal.fixedassets.persistence.model.PersonModel;
import co.com.enterpriseal.fixedassets.service.ibusiness.IAreaBusiness;
import co.com.enterpriseal.fixedassets.service.ibusiness.IPersonBusiness;
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
 *
 * @since 2017-02-10
 * @author aye
 */
@RestController
public class ManagementService {

    @Autowired
    IFixedAssetsBusiness assetsBusiness;
    @Autowired
    IAreaBusiness areaBusiness;
    @Autowired
    IPersonBusiness personBusiness;

    /**
     * Lista las areas parametrizadas en el sistema
     *
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/listArea", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listArea() {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            List<AreaModel> listArea = areaBusiness.listArea();
            if (listArea != null && listArea.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listArea, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "listArea");
        }
        return responseEntity;
    }

    /**
     * Crea nuevo registro de area
     *
     * @param pAreaModel Objeto AreaModel
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/insertArea", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity insertArea(@RequestBody AreaModel pAreaModel) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean resp = areaBusiness.insertArea(pAreaModel);
            if (resp) {
                headers.set("myResponse", "La operacion se realizo con exito.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "Faltan datos para crear area.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); // 400
            }
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
        return responseEntity;
    }

    /**
     * Obtiene listado de personas
     *
     * @return objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/listPerson", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listPerson() {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            List<PersonModel> listPerson = personBusiness.listPerson();
            if (listPerson != null && listPerson.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listPerson, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "listPerson");
        }
        return responseEntity;
    }

    /**
     * Inserta nuevo registro en la tabla persona
     *
     * @param pPersonModel Objeto PersonModel
     * @return Objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/insertPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity insertPerson(@RequestBody PersonModel pPersonModel) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean resp = personBusiness.insertPerson(pPersonModel);
            if (resp) {
                headers.set("myResponse", "La operacion se realizo con exito.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "Faltan datos para crear persona.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); // 400
            }
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "insertPerson");
        }
        return responseEntity;
    }

    /**
     * Crea nuevo activo en la base de datos
     *
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/insertFixedAssets", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity insertFixedAssets(@RequestBody FixedAssetsModel pFixedAssetsModel) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean resp = assetsBusiness.insertFixedAssets(pFixedAssetsModel);
            if (resp) {
                headers.set("myResponse", "La operacion se realizo con exito.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "Faltan datos para crear activo.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); // 400
            }
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "insertFixedAssets");
        }
        return responseEntity;
    }

    /**
     * Obtiene listado de activos
     *
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
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "listFixedAssets");
        }
        return responseEntity;
    }

    /**
     * Obtiene listado de activos por tipo
     *
     * @return objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/listFixedAssetsByType/{type}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listFixedAssetsByType(@PathVariable("type") int activeType) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        // Creamos el objeto FixedAssetsModel para el seteo de las variables que vienen por parametro
        FixedAssetsModel vFixedAssetsModel = new FixedAssetsModel();
        vFixedAssetsModel.setActiveType(activeType);
        try {
            List<FixedAssetsModel> listFixedAssets = assetsBusiness.listFixedAssetsByType(vFixedAssetsModel);
            if (listFixedAssets != null && listFixedAssets.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listFixedAssets, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "listFixedAssetsByType");
        }
        return responseEntity;
    }

    /**
     * Obtiene listado de activos por fecha compra
     *
     * @return objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/listFixedAssetsByDateBuy/{date}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listFixedAssetsByDateBuy(@PathVariable("date") String dateBuy) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        // Creamos el objeto FixedAssetsModel para el seteo de las variables que vienen por parametro
        FixedAssetsModel vFixedAssetsModel = new FixedAssetsModel();
        vFixedAssetsModel.setDateBuy(java.sql.Date.valueOf(dateBuy));
        try {
            List<FixedAssetsModel> listFixedAssets = assetsBusiness.listFixedAssetsByDateBuy(vFixedAssetsModel);
            if (listFixedAssets != null && listFixedAssets.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listFixedAssets, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "listFixedAssetsByDateBuy");
        }
        return responseEntity;
    }

    /**
     * Obtiene listado de activos por serial
     *
     * @return objeto ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/listFixedAssetsBySerial/{serial}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity listFixedAssetsBySerial(@PathVariable("serial") String serial) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        // Creamos el objeto FixedAssetsModel para el seteo de las variables que vienen por parametro
        FixedAssetsModel vFixedAssetsModel = new FixedAssetsModel();
        vFixedAssetsModel.setSerial(serial);
        try {
            List<FixedAssetsModel> listFixedAssets = assetsBusiness.listFixedAssetsBySerial(vFixedAssetsModel);
            if (listFixedAssets != null && listFixedAssets.size() > 0) {
                headers.set("myResponse", "La consulta se realizo con exito.");
                responseEntity = new ResponseEntity<>(listFixedAssets, headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "La consulta no arrojo resultado.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.NOT_FOUND); // 404
            }
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "listFixedAssetsBySerial");
        }
        return responseEntity;
    }

    /**
     * Actualiza activo en la base de datos
     *
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/web/fixedAssets/gest/updateFixedAssets", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    public ResponseEntity updateFixedAssets(@RequestBody FixedAssetsModel pFixedAssetsModel) {
        ResponseEntity responseEntity;
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean resp = assetsBusiness.updateFixedAssets(pFixedAssetsModel);
            if (resp) {
                headers.set("myResponse", "La operacion se realizo con exito.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.OK); // 200
            } else {
                headers.set("myResponse", "Faltan datos para actualizar activo.");
                responseEntity = new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); // 400
            }
        } catch (Exception ex) {
            headers.set("myResponse", "Ocurrio un error al procesar la consulta. Error: " + ex.getMessage());
            responseEntity = new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR); // 500
            //Logger.writeError(ex.getMessage(), 0, "ManagementService", "updateFixedAssets");
        }
        return responseEntity;
    }
}
