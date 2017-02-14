/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.enterpriseal.fixedassets.service.ibusiness;

import co.com.enterpriseal.fixedassets.persistence.model.ActiveTypeModel;
import java.util.List;

/**
 * Especifica la implementacion de la clase ActiveTypeBusiness
 * @author aye
 */
public interface IActiveTypeBusiness {
    /**
     * Especifica el metodo listar los tipos de activos
     * @return lista con los datos de tipos de activo
     */
    List<ActiveTypeModel> listActiveType();
    
    /**
     * Especifica el metodo crear nuevo registro tipo de activo
     * @param pTypeModel objeto ActiveTypeModel
     * @return true si la operacion se completo con exito
     */
    boolean insertActiveType(ActiveTypeModel pTypeModel);
}
