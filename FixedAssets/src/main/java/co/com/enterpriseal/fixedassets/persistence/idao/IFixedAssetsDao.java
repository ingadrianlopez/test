package co.com.enterpriseal.fixedassets.persistence.idao;

import java.util.List;

import co.com.enterpriseal.fixedassets.persistence.model.FixedAssetsModel;

/**
 * Interfaz que especifica la implementacion de la clase FixedAssetsDao
 *
 * @since 2017-02-10
 * @author AdrianL
 */
public interface IFixedAssetsDao {

    /**
     * Especifica metodo listar activos fijos de la base de datos
     *
     * @return listado de activos fijos
     */
    List<FixedAssetsModel> listFixedAssets();

    /**
     * Especifica metodo crear un nuevo activo fijo en la base de datos
     *
     * @param pFixedAssetsModel objeto FixedAssetsModel
     * @return true si la operacion se completo con exito
     */
    boolean insertFixedAssets(FixedAssetsModel pFixedAssetsModel);

    /**
     * Especifica metodo actualizar activo fijo en la base de datos
     *
     * @param pFixedAssetsModel objeto FixedAssetsModel
     * @return true si la operacion se completo con exito
     */
    boolean updateFixedAssets(FixedAssetsModel pFixedAssetsModel);

    /**
     * Especifica metodo eliminar activo fijo en la base de datos
     *
     * @param pFixedAssetsModel objeto FixedAssetsModel
     * @return true si la operacion se completo con exito
     */
    boolean deleteFixedAssets(FixedAssetsModel pFixedAssetsModel);
}
