/**
 * -----------------------------------------------
 * @description: Js para la configuracion de las url de los servicios
 * @since: 2017-02-10
 * @author: Adrian Sair Lopez Morales
 * -----------------------------------------------
 */

/**
 * Obtiene la url de servicio rest
 * @param {type} nameUrl url a obtener
 * @returns url buscada
 */
function obtenerUrlService(nameUrl) {
    var url = '';
    var serviceBase = window.location.protocol + '//' + window.location.hostname + ':' + '8083' + '';
    switch (nameUrl) {
        // ActiveStatusModel
        case 'getListActiveStatus':
            url = serviceBase + '/web/fixedAssets/para/listActiveStatus';
            break;
        case 'getInsertActiveStatus':
            url = serviceBase + '/web/fixedAssets/para/insertActiveStatus';
            break;
        // ActiveType
        case 'getListActiveType':
            url = serviceBase + '/web/fixedAssets/para/listActiveType';
            break;
        case 'getInsertActiveType':
            url = serviceBase + '/web/fixedAssets/para/insertActiveType';
            break;
        // ColorModel
        case 'getListColor':
            url = serviceBase + '/web/fixedAssets/para/listColor';
            break;
        case 'getInsertColor':
            url = serviceBase + '/web/fixedAssets/para/insertColor';
            break;
        // DocumentTypeModel
        case 'getListDocumentType':
            url = serviceBase + '/web/fixedAssets/para/listDocumentType';
            break;
        case 'getInsertDocumentType':
            url = serviceBase + '/web/fixedAssets/para/insertDocumentType';
            break;
        // CityModel
        case 'getListCity':
            url = serviceBase + '/web/fixedAssets/para/listCity';
            break;
        case 'getInsertCity':
            url = serviceBase + '/web/fixedAssets/para/insertCity';
            break;
        // PersonModel
        case 'getInsertPerson':
            url = serviceBase + '/web/fixedAssets/gest/insertPerson';
            break;
        case 'getListPerson':
            url = serviceBase + '/web/fixedAssets/gest/listPerson';
            break;
        // AreaModel
        case 'getInsertArea':
            url = serviceBase + '/web/fixedAssets/gest/insertArea';
            break;
        case 'getListArea':
            url = serviceBase + '/web/fixedAssets/gest/listArea';
            break;    
        // FixedAssetsModel
        case 'getListFixedAssets':
            url = serviceBase + '/web/fixedAssets/gest/listFixedAssets';
            break;    
        case 'getInsertFixedAssets':
            url = serviceBase + '/web/fixedAssets/gest/insertFixedAssets';
            break;  
        case 'getUpdateFixedAssets':
            url = serviceBase + '/web/fixedAssets/gest/updateFixedAssets';
            break;  
        // filtros por tipo de activo
        case 'getListFixedAssetsByType':
            url = serviceBase + '/web/fixedAssets/gest/listFixedAssetsByType/';
            break;  
        // filtros por fecha compra
        case 'getListFixedAssetsByDateBuy':
            url = serviceBase + '/web/fixedAssets/gest/listFixedAssetsByDateBuy/';
            break;  
        // filtros por serial
        case 'getListFixedAssetsBySerial':
            url = serviceBase + '/web/fixedAssets/gest/listFixedAssetsBySerial/';
            break;  
        default:
            url = serviceBase + '/web/fixedAssets';
            break;
    }
    return url;
};
