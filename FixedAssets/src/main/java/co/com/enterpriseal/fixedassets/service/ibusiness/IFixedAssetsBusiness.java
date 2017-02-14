package co.com.enterpriseal.fixedassets.service.ibusiness;

import co.com.enterpriseal.fixedassets.persistence.model.FixedAssetsModel;
import java.io.IOException;
import java.util.List;

/**
 * Especifica la implementacion de la clase FixedAssetsBusiness
 * @since 
 * @author aye
 */
public interface IFixedAssetsBusiness {
     /**
     * Especifica metodo listar activos fijos de la base de datos
     * @return listado de activos fijos
     * @throws IOException 
     */
    List<FixedAssetsModel> listFixedAssets() throws IOException;
    
    /**
     * Especifica metodo Obtener los activos por tipo
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return listado de los activos
     * @throws IOException 
     */
    List<FixedAssetsModel> listFixedAssetsByType(FixedAssetsModel pFixedAssetsModel) throws IOException;

    /**
     * Especifica metodo obtener activos por fecha compra
     *
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return listado de los activos
     * @throws IOException
     */
    List<FixedAssetsModel> listFixedAssetsByDateBuy(FixedAssetsModel pFixedAssetsModel) throws IOException;

    /**
     * Especifica metodo obtener activos por serial
     *
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return listado de los activos
     * @throws IOException
     */
    List<FixedAssetsModel> listFixedAssetsBySerial(FixedAssetsModel pFixedAssetsModel) throws IOException;
    
    /**
     * Especifica metodo crear un nuevo activo fijo en la base de datos
     * @param pFixedAssetsModel objeto FixedAssetsModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean insertFixedAssets(FixedAssetsModel pFixedAssetsModel) throws IOException;
    
    /**
     * Especifica metodo actualizar activo fijo en la base de datos
     * @param pFixedAssetsModel objeto FixedAssetsModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean updateFixedAssets(FixedAssetsModel pFixedAssetsModel) throws IOException;
 
}
