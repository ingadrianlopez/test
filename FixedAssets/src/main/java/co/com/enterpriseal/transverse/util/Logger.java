/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.enterpriseal.transverse.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

/**
 * Clase para gestionar las trazas de la app
 * @author aye
 */
public class Logger {
    
    /**
     * Escribe un error ocurrido por una excepción de la app
     * @param message Mensaje generado por el error
     * @param lineNumber Lugar error
     * @param className Clase donde ocurre el error
     * @param methodName Metodo donde ocurre el error
     */
    public static void writeError(String message, int lineNumber, String className, String methodName) {
        try {
            // Establecemos la ruta del archivo log
//            InputStream resp = Logger.class.getClassLoader().getResourceAsStream("co/com/enterpriseal/transverse/resource/parameters.properties");
//            Properties properties = new Properties();
//            properties.load(resp);
            String filePath = "C:/Notacion/myError.log"; //properties.getProperty("patherror");
            
            // Cargamos el archivo de erroes
            FileHandler handler = new FileHandler(filePath, true);
            java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Logging Activos Fijos");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            logger.log(Level.WARNING, "Error en {0}  Metodo: {1} Linea: {2} Mensaje error: {3}", new Object[]{className, methodName, lineNumber, message + "\n"});
            handler.close();
            //resp.close();
        } catch (IOException | SecurityException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
