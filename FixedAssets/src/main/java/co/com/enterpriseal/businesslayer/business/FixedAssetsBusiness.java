package co.com.enterpriseal.businesslayer.business;

import java.util.ArrayList;
import java.util.List;
import co.com.enterpriseal.commons.model.FixedAssetsModel;
import co.com.enterpriseal.dataaccesslayer.dao.FixedAssetsDao;
import co.com.enterpriseal.dataaccesslayer.idao.IFixedAssetsDao;
import java.io.IOException;

/**
 * Clase que maneja la logica de negocio de la tabla activos
 * @since 2017-02-11
 * @author aye
 */
public class FixedAssetsBusiness {
    private final IFixedAssetsDao fixedAssetsDao;
    
    /**
     * Constructor
     */
    public FixedAssetsBusiness(){
        fixedAssetsDao = new FixedAssetsDao();
    }
    
    /**
     * Lista los activos del sistema
     * @return listado de los activos
     * @throws IOException 
     */
    public List<FixedAssetsModel> listFixedAssets() throws IOException {
        return fixedAssetsDao.listFixedAssets();
    }
    
    /**
     * Obtiene los activos por tipo
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return listado de los activos
     * @throws IOException 
     */
    public List<FixedAssetsModel> listFixedAssetsByType(FixedAssetsModel pFixedAssetsModel) throws IOException{
        List<FixedAssetsModel> list = fixedAssetsDao.listFixedAssets();
        List<FixedAssetsModel> listResp = new ArrayList<>();
        if(list != null && list.size() > 0){
            for (FixedAssetsModel fixedAssetsModel : list) {
                if(fixedAssetsModel.getActiveType() == pFixedAssetsModel.getActiveType()){
                    listResp.add(fixedAssetsModel);
                }
            }
        }
        return listResp;
    }
    
    /**
     * Obtiene los activos por fecha compra
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return listado de los activos
     * @throws IOException 
     */
    public List<FixedAssetsModel> listFixedAssetsByDateBuy(FixedAssetsModel pFixedAssetsModel) throws IOException{
        List<FixedAssetsModel> list = fixedAssetsDao.listFixedAssets();
        List<FixedAssetsModel> listResp = new ArrayList<>();
        if(list != null && list.size() > 0){
            for (FixedAssetsModel fixedAssetsModel : list) {
                if(fixedAssetsModel.getDateBuy().compareTo(pFixedAssetsModel.getDateBuy()) == 0){
                    listResp.add(fixedAssetsModel);
                }
            }
        }
        return listResp;
    }
    
    /**
     * Obtiene los activos por serial
     * @param pFixedAssetsModel Objeto FixedAssetsModel
     * @return listado de los activos
     * @throws IOException 
     */
    public List<FixedAssetsModel> listFixedAssetsBySerial(FixedAssetsModel pFixedAssetsModel) throws IOException{
        List<FixedAssetsModel> list = fixedAssetsDao.listFixedAssets();
        List<FixedAssetsModel> listResp = new ArrayList<>();
        if(list != null && list.size() > 0){
            for (FixedAssetsModel fixedAssetsModel : list) {
                if(fixedAssetsModel.getSerial() != null && fixedAssetsModel.getSerial().trim().equalsIgnoreCase(pFixedAssetsModel.getSerial().trim())){
                    listResp.add(fixedAssetsModel);
                }
            }
        }
        return listResp;
    }
    
    /**
     * Crea nuevo activo
     * @param pPersonModel Objeto pFixedAssetsModel
     * @return true si la operacion se completo con exito, false si faltan datos para el insert
     * @throws IOException 
     */
    public boolean insertFixedAssets(FixedAssetsModel pFixedAssetsModel) throws IOException {
        if(pFixedAssetsModel.getInventoryNumber() > 0 && pFixedAssetsModel.getSerial() != null
                && pFixedAssetsModel.getName() != null && pFixedAssetsModel.getName().trim().length() > 0
                && pFixedAssetsModel.getDescription() != null && pFixedAssetsModel.getDescription().trim().length() > 0
                && pFixedAssetsModel.getWeight() != null && pFixedAssetsModel.getHigh() != null && pFixedAssetsModel.getWidth() != null
                && pFixedAssetsModel.getLength() != null && pFixedAssetsModel.getValue() != null && pFixedAssetsModel.getDateBuy() != null
                && pFixedAssetsModel.getState() > 0 && pFixedAssetsModel.getActiveType() > 0 && pFixedAssetsModel.getColor() > 0){
            return fixedAssetsDao.insertFixedAssets(pFixedAssetsModel);
        }else
            return false;
    }
    
    /**
     * Actualiza activo por serial
     * @param pPersonModel Objeto pFixedAssetsModel
     * @return true si la operacion se completo con exito, false si faltan datos para el insert
     * @throws IOException 
     */
    public boolean updateFixedAssets(FixedAssetsModel pFixedAssetsModel) throws IOException {
        if(pFixedAssetsModel.getInventoryNumber() > 0 && pFixedAssetsModel.getSerial() != null && pFixedAssetsModel.getDischargeDate() != null){
            List<FixedAssetsModel> list = fixedAssetsDao.listFixedAssets();
            FixedAssetsModel assetsModelTemp = null;
            if(list != null && list.size() > 0){
                for (FixedAssetsModel fixedAssetsModel : list) {
                    if(fixedAssetsModel.getSerial() != null && fixedAssetsModel.getSerial().trim().equalsIgnoreCase(pFixedAssetsModel.getSerial().trim())){
                        assetsModelTemp = fixedAssetsModel;
                        break;
                    }
                }
                // La fecha de compra no debe ser mayo a la fecha de baja
                if(assetsModelTemp != null && assetsModelTemp.getDateBuy().compareTo(pFixedAssetsModel.getDischargeDate()) > 0){
                    return false;
                }
            }
            return fixedAssetsDao.updateFixedAssets(pFixedAssetsModel);
        }else
            return false;
    }
}
