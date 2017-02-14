/**
 * -----------------------------------------------
 * @description: Js para guardar las funciones personalizadas
 * @since: 2017-02-10
 * @auto: Adrian Sair Lopez Morales
 * -----------------------------------------------
 */

Date.prototype.yyyymmdd = function() {
  var mm = this.getMonth() + 1; // getMonth() is zero-based
  var dd = this.getDate();

  return [this.getFullYear(), (mm>9 ? '' : '0') + mm, (dd>9 ? '' : '0') + dd].join('-');
};

/**
 * Asigna lista de valores a la grid dandole el ancho, nombre columna
 * @param {type} gridOptions Definición de la grid
 * @param {type} list Lista de items a pintar en la grid 
 * @returns {undefined}
 */
function setListToGrid(gridOptions, list) {
    var columns = [];
    if (isArrayNotNull(list)) {
        for (var property in list[0]) {
            if (list[0].hasOwnProperty(property)) {
                columns.push({name: property, field: property, width: 150});
            }
        }
        gridOptions.columnDefs = columns;
        gridOptions.data = list;
    }
};

/**
 * Mensaje confirmacion
 * @param {type} titulo
 * @param {type} contenido
 * @param {type} funcionSi
 * @param {type} funcionNo
 * @returns {undefined}
 */
function messageBoxConfirm(titulo, contenido, funcionSi, funcionNo) {
    $.confirm({
        //icon: 'images/confirmacion.png',
        title: titulo,
        content: contenido,
        confirmButtonClass: 'btn btn-primary',
        cancelButtonClass: 'btn btn-danger',
        confirmButton: 'Si',
        cancelButton: 'No',
        columnClass: 'col-md-6 col-md-offset-3',
        confirm: funcionSi,
        cancel: funcionNo
    });
};

/**
 * Mensaje info
 * @param {type} titulo
 * @param {type} contenido
 * @param {type} tipo
 * @returns {undefined}
 */
function messageBoxAlert(titulo, contenido, tipo) {
    var tipoBoton = '';
    var imagen = 'images/';

    switch (tipo) {
        case 'info':
            tipoBoton = 'btn btn-primary';
            imagen += 'info.png';
            break;
        case 'error':
            tipoBoton = 'btn btn-danger';
            imagen += 'error.png';
            break;
        case 'alert':
            tipoBoton = 'btn btn-warning';
            imagen += 'alert.png';
            break;
    }

    $.alert({
        //icon: imagen,
        title: titulo,
        content: contenido,
        confirmButtonClass: tipoBoton,
        confirmButton: 'Ok',
        columnClass: 'col-md-6 col-md-offset-3',
        confirm: function () {
        }
    });
};

/**
 * Valida que una lista no sea nula o vacia
 * @param {type} list
 * @returns {Boolean}
 */
function isArrayNotNull(list) {
    if (angular.isArray(list) && list.length > 0) {
        return true;
    }
    return false;
};
