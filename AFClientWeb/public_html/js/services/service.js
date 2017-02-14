/* global activosFijosApp */

/**
 * -----------------------------------------------
 * @description: Factoria que maneja el repositorio de servicios
 * @since: 2017-02-10
 * @author: Adrian Sair Lopez Morales
 * -----------------------------------------------
 */

activosFijosApp.factory('myService', ['$http', function ($http) {
        return {
            // Estados de activo
            getListActiveStatus: function (pUrl) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {}
                });
            },
            getInsertActiveStatus: function (pUrl, pActiveStatus) {
                return $http({
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {name: pActiveStatus.name, description: pActiveStatus.description}
                });
            },
            
            // Tipos de activo
            getListActiveType: function (pUrl) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {}
                });
            },
            
            getInsertActiveType: function (pUrl, pActiveType) {
                return $http({
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {name: pActiveType.name, description: pActiveType.description}
                });
            },
            
            // Color
            getListColor: function (pUrl) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {}
                });
            },
            
            getInsertColor: function (pUrl, pColor) {
                return $http({
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {name: pColor.name, description: pColor.description}
                });
            },
            
            // Tipos de documento
            getListDocumentType: function (pUrl) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {}
                });
            },
            
            getInsertDocumentType: function (pUrl, pDocumentType) {
                return $http({
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {name: pDocumentType.name, description: pDocumentType.description}
                });
            },
            
            // Ciudades
            getListCity: function (pUrl) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {}
                });
            },
            
            getInsertCity: function (pUrl, pCity) {
                return $http({
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {name: pCity.name, description: pCity.description}
                });
            },
            
            // Areas
            getInsertArea: function (pUrl, pArea) {
                return $http({
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {name: pArea.name, description: pArea.description, city: pArea.city}
                });
            },
            
            getListArea: function (pUrl) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {}
                });
            },
            
            // Personas
            getInsertPerson: function (pUrl, pPerson) {
                return $http({
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {identification: pPerson.identification, documentType: pPerson.documentType,
                        name: pPerson.name, lastName: pPerson.lastName}
                });
            },
            
            getListPerson: function (pUrl) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {}
                });
            },
            
            // Activo fijo 
            getInsertFixedAssets: function (pUrl, pFixedAssets) {
                return $http({
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {
                        inventoryNumber: pFixedAssets.inventoryNumber,
                        serial: pFixedAssets.serial,
                        name: pFixedAssets.name,
                        description: pFixedAssets.description,
                        weight: pFixedAssets.weight,
                        high: pFixedAssets.high,
                        width: pFixedAssets.width,
                        length: pFixedAssets.length,
                        value: pFixedAssets.value,
                        dateBuy: pFixedAssets.dateBuy,
                        dischargeDate: pFixedAssets.dischargeDate,
                        state: pFixedAssets.state,
                        activeType: pFixedAssets.activeType,
                        color: pFixedAssets.color
                    }
                });
            },
            
            getListFixedAssets: function (pUrl) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: {}
                });
            },
            
            getUpdateFixedAssets: function (pUrl, pFixedAssets) {
                return $http({
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl,
                    data: { serial: pFixedAssets.serial, dischargeDate: pFixedAssets.dischargeDate, inventoryNumber: pFixedAssets.inventoryNumber }
                });
            },
            
            getListFixedAssetsByType: function (pUrl, pFixedAssets) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl + pFixedAssets.activeType,
                    data: { }
                });
            },
            
            getListFixedAssetsByDateBuy: function (pUrl, pFixedAssets) {
                var resp = pFixedAssets.dateBuy.yyyymmdd();
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl + resp                  
                });
            },
            
            getListFixedAssetsBySerial: function (pUrl, pFixedAssets) {
                return $http({
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    },
                    url: pUrl + pFixedAssets.serial
                });
            }

        };
    }]);



