package co.com.enterpriseal.dataaccesslayer.idao;

import java.util.List;

import co.com.enterpriseal.commons.model.FixedAssetsModel;
import java.io.IOException;

/**
 * Interfaz que especifica la implementacion de la clase FixedAssetsDao
 * @since 2017-02-10
 * @author AdrianL
 */
public interface IFixedAssetsDao {
	/**
     * Especifica metodo listar activos fijos de la base de datos
     * @return listado de activos fijos
     * @throws IOException 
     */
    List<FixedAssetsModel> listFixedAssets() throws IOException;
    
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
    
    /**
     * Especifica metodo eliminar activo fijo en la base de datos
     * @param pFixedAssetsModel objeto FixedAssetsModel
     * @return true si la operacion se completo con exito
     * @throws IOException 
     */
    boolean deleteFixedAssets(FixedAssetsModel pFixedAssetsModel) throws IOException;
}
