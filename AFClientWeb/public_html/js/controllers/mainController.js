/* global activosFijosApp */

/**
 * -----------------------------------------------
 * @description: Controlador que maneja la pantalla principal
 * @since: 2017-02-10
 * @author: Adrian Sair Lopez Morales
 * -----------------------------------------------
 */
activosFijosApp.controller('mainController', ['$scope', '$uibModal', '$timeout', 'myService', function ($scope, $modal, $timeout, myService) {

        ////////////////////////////////////////////////////////////////////////
        // Load js
        ///////////////////////////////////////////////////////////////////////
        $scope.gridApi = {};
        $scope.form = {};
        $scope.FixedAssetsUpdate = {};
        listActiveStatus();
        listActiveType();
        listColor();
        listDocumentType();
        listCity();
        listArea();
        listPerson();
        listFixedAssets();

        ////////////////////////////////////////////////////////////////////////
        // Region de Parametros
        ///////////////////////////////////////////////////////////////////////

        /////////////////////////
        // Estado de activos
        /////////////////////////

        $scope.gridActiveStatus = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true,
            flatEntityAccess: true
        };

        /**
         * Selection changed gridActiveStatus
         * @param {type} gridApi
         * @returns {undefined}
         */
        $scope.gridActiveStatus.onRegisterApi = function (gridApi) {
            $scope.gridApi['gridActiveStatus'] = gridApi;

            $scope.gridApi['gridActiveStatus'].cellNav.on.navigate($scope, function (newRowCol, oldRowCol) {
                if (angular.isUndefined(newRowCol.row.isSelected) || !newRowCol.row.isSelected) {
                    $scope.gridApi['gridActiveStatus'].selection.selectRow(newRowCol.row.entity);
                    $scope.rowSelectGridActiveStatus = newRowCol.row.entity;
                }
            });
        };

        /**
         * Obtiene el listado de los estados de los activos
         * @returns {undefined}
         */
        function listActiveStatus() {
            myService.getListActiveStatus(obtenerUrlService('getListActiveStatus')).success(function (data, status, headers, config) {
                $scope.vListActiveStatus = angular.copy(data);
                setListToGrid($scope.gridActiveStatus, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'alert');
            });
        };
        
        /**
         * Action Crear un nuevo registro de estado de activo
         * @param {type} pActiveStatus
         * @returns {undefined}
         */
        $scope.insertActiveStatusAction = function (pActiveStatus) {
            myService.getInsertActiveStatus(obtenerUrlService('getInsertActiveStatus'), pActiveStatus).success(function (data, status, headers, config) {
                messageBoxAlert('INFO', 'La operación se completó con éxito', 'info');
                listActiveStatus();
                pActiveStatus.name = null;
                pActiveStatus.description = null;
                $scope.form.formActiveStatus.$setPristine();
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 400)
                    messageBoxAlert('INFO', 'Faltan algunos datos para poder ejecutar la operación', 'alert');
            });
        };
        
        /////////////////////////
        // Tipos de activo
        /////////////////////////

        $scope.gridActiveType = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true,
            flatEntityAccess: true
        };

        /**
         * Selection changed gridActiveStatus
         * @param {type} gridApi
         * @returns {undefined}
         */
        $scope.gridActiveType.onRegisterApi = function (gridApi) {
            $scope.gridApi['gridActiveType'] = gridApi;
            $scope.gridApi['gridActiveType'].cellNav.on.navigate($scope, function (newRowCol, oldRowCol) {
                if (angular.isUndefined(newRowCol.row.isSelected) || !newRowCol.row.isSelected) {
                    $scope.gridApi['gridActiveType'].selection.selectRow(newRowCol.row.entity);
                    $scope.rowSelectGridActiveType = newRowCol.row.entity;
                }
            });
        };

        /**
         * Obtiene el listado de los tipos de activo
         * @returns {undefined}
         */
        function listActiveType() {
            myService.getListActiveType(obtenerUrlService('getListActiveType')).success(function (data, status, headers, config) {
                $scope.vListActiveType = angular.copy(data);
                setListToGrid($scope.gridActiveType, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'info');
            });
        };
        
        /**
         * Action Crear un nuevo tipo de activo
         * @param {type} pActiveType
         * @returns {undefined}
         */
        $scope.insertActiveTypeAction = function (pActiveType) {
            myService.getInsertActiveType(obtenerUrlService('getInsertActiveType'), pActiveType).success(function (data, status, headers, config) {
                messageBoxAlert('INFO', 'La operación se completó con éxito', 'info');
                listActiveType();
                pActiveType.name = null;
                pActiveType.description = null;
                $scope.form.formActiveTypes.$setPristine();
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 400)
                    messageBoxAlert('INFO', 'Faltan algunos datos para poder ejecutar la operación', 'alert');
            });
        };
        
        /////////////////////////
        // Colores
        /////////////////////////

        $scope.gridColor = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true,
            flatEntityAccess: true
        };

        /**
         * Selection changed gridColor
         * @param {type} gridApi
         * @returns {undefined}
         */
        $scope.gridColor.onRegisterApi = function (gridApi) {
            $scope.gridApi['gridColor'] = gridApi;

            $scope.gridApi['gridColor'].cellNav.on.navigate($scope, function (newRowCol, oldRowCol) {
                if (angular.isUndefined(newRowCol.row.isSelected) || !newRowCol.row.isSelected) {
                    $scope.gridApi['gridColor'].selection.selectRow(newRowCol.row.entity);
                    $scope.rowSelectGridColor = newRowCol.row.entity;
                }
            });
        };

        /**
         * Obtiene el listado de los colores
         * @returns {undefined}
         */
        function listColor() {
            myService.getListColor(obtenerUrlService('getListColor')).success(function (data, status, headers, config) {
                $scope.vListColor = angular.copy(data);
                setListToGrid($scope.gridColor, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'info');
            });
        };
        
        /**
         * Action crear nuevo registro color
         * @param {type} pColor
         * @returns {undefined}
         */
        $scope.insertColorAction = function (pColor) {
            myService.getInsertColor(obtenerUrlService('getInsertColor'), pColor).success(function (data, status, headers, config) {
                messageBoxAlert('INFO', 'La operación se completó con éxito', 'info');
                listColor();
                pColor.name = null;
                pColor.description = null;
                $scope.form.formColor.$setPristine();
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 400)
                    messageBoxAlert('INFO', 'Faltan algunos datos para poder ejecutar la operación', 'alert');
            });
        };
        
        /////////////////////////
        // Tipos de documento
        /////////////////////////

        $scope.gridDocumentType = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true,
            flatEntityAccess: true
        };

        /**
         * Selection changed gridDocumentType
         * @param {type} gridApi
         * @returns {undefined}
         */
        $scope.gridDocumentType.onRegisterApi = function (gridApi) {
            $scope.gridApi['gridDocumentType'] = gridApi;

            $scope.gridApi['gridDocumentType'].cellNav.on.navigate($scope, function (newRowCol, oldRowCol) {
                if (angular.isUndefined(newRowCol.row.isSelected) || !newRowCol.row.isSelected) {
                    $scope.gridApi['gridDocumentType'].selection.selectRow(newRowCol.row.entity);
                    $scope.rowSelectGridDocumentType = newRowCol.row.entity;
                }
            });
        };

        /**
         * Obtiene el listado de los tipos de documento
         * @returns {undefined}
         */
        function listDocumentType() {
            myService.getListDocumentType(obtenerUrlService('getListDocumentType')).success(function (data, status, headers, config) {
                $scope.vListDocumentType = angular.copy(data);
                setListToGrid($scope.gridDocumentType, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'info');
            });
        };
        
        /**
         * Action crear tipo de documento
         * @param {type} pDocumentType
         * @returns {undefined}
         */
        $scope.insertDocumentTypeAction = function (pDocumentType) {
            myService.getInsertDocumentType(obtenerUrlService('getInsertDocumentType'), pDocumentType).success(function (data, status, headers, config) {
                messageBoxAlert('INFO', 'La operación se completó con éxito', 'info');
                listDocumentType();
                pDocumentType.name = null;
                pDocumentType.description = null;
                $scope.form.formDocumentTypes.$setPristine();
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 400)
                    messageBoxAlert('INFO', 'Faltan algunos datos para poder ejecutar la operación', 'alert');
            });
        };
        
        /////////////////////////
        // Ciudades
        /////////////////////////

        $scope.gridCity = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false
        };

        /**
         * Selection changed gridCity
         * @param {type} gridApi
         * @returns {undefined}
         */
        $scope.gridCity.onRegisterApi = function (gridApi) {
            $scope.gridApi['gridCity'] = gridApi;

            $scope.gridApi['gridCity'].cellNav.on.navigate($scope, function (newRowCol, oldRowCol) {
                if (angular.isUndefined(newRowCol.row.isSelected) || !newRowCol.row.isSelected) {
                    $scope.gridApi['gridCity'].selection.selectRow(newRowCol.row.entity);
                    $scope.rowSelectGridCity = newRowCol.row.entity;
                }
            });
        };
        
        /**
         * Obtiene el listado de las ciudades
         * @returns {undefined}
         */
        function listCity() {
            myService.getListCity(obtenerUrlService('getListCity')).success(function (data, status, headers, config) {
                $scope.vListCity = angular.copy(data);
                setListToGrid($scope.gridCity, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'info');
            });
        };
        
        /**
         * Action Crear nuevo registro ciudad
         * @param {type} pCity
         * @returns {undefined}
         */
        $scope.insertCityAction = function (pCity) {
            myService.getInsertCity(obtenerUrlService('getInsertCity'), pCity).success(function (data, status, headers, config) {
                messageBoxAlert('INFO', 'La operación se completó con éxito', 'info');
                listCity();
                pCity.name = null;
                pCity.description = null;
                $scope.form.formCity.$setPristine();
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 400)
                    messageBoxAlert('INFO', 'Faltan algunos datos para poder ejecutar la operación', 'alert');
            });
        };
        
        /////////////////////////
        // Areas
        /////////////////////////

        $scope.gridArea = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false
        };

        /**
         * Selection changed gridArea
         * @param {type} gridApi
         * @returns {undefined}
         */
        $scope.gridArea.onRegisterApi = function (gridApi) {
            $scope.gridApi['gridArea'] = gridApi;

            $scope.gridApi['gridArea'].cellNav.on.navigate($scope, function (newRowCol, oldRowCol) {
                if (angular.isUndefined(newRowCol.row.isSelected) || !newRowCol.row.isSelected) {
                    $scope.gridApi['gridArea'].selection.selectRow(newRowCol.row.entity);
                    $scope.rowSelectGridArea = newRowCol.row.entity;
                }
            });
        };
        
        /**
         * Obtiene el listado de areas
         * @returns {undefined}
         */
        function listArea() {
            myService.getListArea(obtenerUrlService('getListArea')).success(function (data, status, headers, config) {
                setListToGrid($scope.gridArea, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'info');
            });
        };
        
        /**
         * Actio Crear nuevo registro area
         * @param {type} pCity
         * @returns {undefined}
         */
        $scope.insertAreaAction = function (pArea) {
            myService.getInsertArea(obtenerUrlService('getInsertArea'), pArea).success(function (data, status, headers, config) {
                messageBoxAlert('INFO', 'La operación se completó con éxito', 'info');
                listArea();
                pArea.name = null;
                pArea.description = null;
                pArea.city = null;
                $scope.form.formArea.$setPristine();
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 400)
                    messageBoxAlert('INFO', 'Faltan algunos datos para poder ejecutar la operación', 'alert');
            });
        };
        
        /////////////////////////
        // Personas
        /////////////////////////

        $scope.gridPerson = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true,
            flatEntityAccess: true
        };

        /**
         * Selection changed gridColor
         * @param {type} gridApi
         * @returns {undefined}
         */
        $scope.gridPerson.onRegisterApi = function (gridApi) {
            $scope.gridApi['gridPerson'] = gridApi;
            $scope.gridApi['gridPerson'].cellNav.on.navigate($scope, function (newRowCol, oldRowCol) {
                if (angular.isUndefined(newRowCol.row.isSelected) || !newRowCol.row.isSelected) {
                    $scope.gridApi['gridPerson'].selection.selectRow(newRowCol.row.entity);
                    $scope.rowSelectGridPerson = newRowCol.row.entity;
                }
            });
        };

        /**
         * Obtiene el listado de los colores
         * @returns {undefined}
         */
        function listPerson() {
            myService.getListPerson(obtenerUrlService('getListPerson')).success(function (data, status, headers, config) {
                setListToGrid($scope.gridPerson, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'info');
            });
        };
        
        /**
         * Action crear nuevo registro color
         * @param {type} pColor
         * @returns {undefined}
         */
        $scope.insertPersonAction = function (pPerson) {
            myService.getInsertPerson(obtenerUrlService('getInsertPerson'), pPerson).success(function (data, status, headers, config) {
                messageBoxAlert('INFO', 'La operación se completó con éxito', 'info');
                listPerson();
                pPerson.name = null;
                pPerson.lastName = null;
                pPerson.identification = null;
                pPerson.documentType = null;
                $scope.form.formPerson.$setPristine();
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 400)
                    messageBoxAlert('INFO', 'Faltan algunos datos para poder ejecutar la operación', 'alert');
            });
        };
        
        /////////////////////////
        // Activos fijos
        /////////////////////////

        $scope.gridFixedAssets = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true            
        };
        
        ////////////////////////////////
        // ACTUALIZAR ACTIVO
        ///////////////////////////////
        
        /**
         * Action actualizar activo
         * @param {type} pFixedAssets
         */
        $scope.updateFixedAssetsAction = function (pFixedAssets) {
            myService.getUpdateFixedAssets(obtenerUrlService('getUpdateFixedAssets'), pFixedAssets).success(function (data, status, headers, config) {
                messageBoxAlert('INFO', 'La operación se completó con éxito', 'info');
                listFixedAssets();
                pFixedAssets.inventoryNumber = null;
                pFixedAssets.serial = null;
                pFixedAssets.dischargeDate = new Date();
                $scope.form.formUpdateFixedAssets.$setPristine();
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 400)
                    messageBoxAlert('INFO', 'Faltan algunos datos para poder ejecutar la operación', 'alert');
            });
        };
        
        // Grid actualizar activo
        $scope.gridFixedAssetsUpdate = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true
        };

        /**
         * Selection changed gridFixedAssetsUpdate
         * @param {type} gridApi
         * @returns {undefined}
         */
        $scope.gridFixedAssetsUpdate.onRegisterApi = function (gridApi) {
            $scope.gridApi['gridFixedAssetsUpdate'] = gridApi;
            $scope.gridApi['gridFixedAssetsUpdate'].cellNav.on.navigate($scope, function (newRowCol, oldRowCol) {
                if (angular.isUndefined(newRowCol.row.isSelected) || !newRowCol.row.isSelected) {
                    $scope.gridApi['gridFixedAssetsUpdate'].selection.selectRow(newRowCol.row.entity);
                    $scope.rowSelectGridFixedAssetsUpdate = newRowCol.row.entity;
                    setVarUpdateFixedAssets($scope.rowSelectGridFixedAssetsUpdate);
                }
            });
        };
        
        /**
         * Action cancelar actualizacion activo
         * @returns {undefined}
         */
        $scope.cancelUpdateFixedAssetsAction = function (){
            $scope.rowSelectGridFixedAssetsUpdate = undefined;
            $scope.gridApi['gridFixedAssetsUpdate'].selection.clearSelectedRows();
            $scope.FixedAssetsUpdate.serial = null;
            $scope.FixedAssetsUpdate.inventoryNumber = null;
            $scope.FixedAssetsUpdate.dischargeDate = new Date();
        };
        
        /**
         * Asigna las propiedades de activo para editar
         * @param {type} rowSelect
         * @returns {undefined}
         */
        function setVarUpdateFixedAssets(rowSelect){
            if(rowSelect !== null){
                for(var property in rowSelect){
                    if(property.toUpperCase() === 'SERIAL'){
                        $scope.FixedAssetsUpdate.serial = rowSelect[property];
                    }
                    if(property.toUpperCase() === 'INVENTORYNUMBER'){
                        $scope.FixedAssetsUpdate.inventoryNumber = rowSelect[property];
                    }
                    if(property.toUpperCase() === 'DISCHARGEDATE'){
                        $scope.FixedAssetsUpdate.dischargeDate = rowSelect[property];
                    }
                }
            }
        }

        /**
         * Obtiene el listado de los activos
         * @returns {undefined}
         */
        function listFixedAssets() {
            myService.getListFixedAssets(obtenerUrlService('getListFixedAssets')).success(function (data, status, headers, config) {
                setListToGrid($scope.gridFixedAssets, data);
                setListToGrid($scope.gridFixedAssetsUpdate, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al obtener los activos.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'No hay activos registrados.', 'info');
            });
        };
        
        //////////////////////////////////
        // Filtro por tipo de activo
        //////////////////////////////////
        
        $scope.gridActiveTypeFilter = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true,
            flatEntityAccess: true
        };
        
        /**
         * Action buscar activos por tipo
         * @param {type} pFilter
         * @returns {undefined}
         */
        $scope.listFixedAssetsByTypeAction = function (pFilter){
            myService.getListFixedAssetsByType(obtenerUrlService('getListFixedAssetsByType'), pFilter).success(function (data, status, headers, config) {
                setListToGrid($scope.gridActiveTypeFilter, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'info');
                $scope.gridActiveTypeFilter.data = [];
            });
        };
        
        //////////////////////////////////
        // Filtro por fecha compra
        //////////////////////////////////
        
        $scope.gridDateBuyFilter = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true,
            flatEntityAccess: true
        };
        
        /**
         * Action buscar activos por fecha de compra
         * @param {type} pFilter
         * @returns {undefined}
         */
        $scope.listFixedAssetsByDateBuyAction = function (pFilter){
            myService.getListFixedAssetsByDateBuy(obtenerUrlService('getListFixedAssetsByDateBuy'), pFilter).success(function (data, status, headers, config) {
                setListToGrid($scope.gridDateBuyFilter, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'info');
                $scope.gridDateBuyFilter.data = [];
            });
        };
        
        //////////////////////////////////
        // Filtro por serial
        //////////////////////////////////
        
        $scope.gridSerialFilter = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            enableFiltering: false,
            autoResize: true,
            multiSelect: false,
            noUnselect: true,
            flatEntityAccess: true
        };
        
        /**
         * Action buscar activos por serial
         * @param {type} pFilter
         * @returns {undefined}
         */
        $scope.listFixedAssetsBySerialAction = function (pFilter){
            myService.getListFixedAssetsBySerial(obtenerUrlService('getListFixedAssetsBySerial'), pFilter).success(function (data, status, headers, config) {
                setListToGrid($scope.gridSerialFilter, data);
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 404)
                    messageBoxAlert('INFO', 'La busqueda no arrojó resultado.', 'info');
                $scope.gridSerialFilter.data = [];
            });
        };
        
        /**
         * Action crear nuevo activo
         * @param {type} pFixedAssets
         * @returns {undefined}
         */
        $scope.insertFixedAssetsAction = function (pFixedAssets) {
            myService.getInsertFixedAssets(obtenerUrlService('getInsertFixedAssets'), pFixedAssets).success(function (data, status, headers, config) {
                messageBoxAlert('INFO', 'La operación se completó con éxito', 'info');
                listFixedAssets();
                pFixedAssets.inventoryNumber = null;
                pFixedAssets.serial = null;
                pFixedAssets.name = null;
                pFixedAssets.description = null;
                pFixedAssets.weight = null;
                pFixedAssets.high = null;
                pFixedAssets.width = null;
                pFixedAssets.length = null;
                pFixedAssets.value = null;
                pFixedAssets.dateBuy = null;
                pFixedAssets.dischargeDate = null;
                pFixedAssets.state = null;
                pFixedAssets.activeType = null;
                pFixedAssets.color = null;
                $scope.form.formFixedAssets.$setPristine();
            }).error(function (data, status, headers, config) {
                if (status === 500)
                    messageBoxAlert('WARNING', 'Ocurrió un error al procesar la solicitud.', 'error');
                else if (status === 400)
                    messageBoxAlert('INFO', 'Faltan algunos datos para poder ejecutar la operación', 'alert');
            });
        };

    }]);