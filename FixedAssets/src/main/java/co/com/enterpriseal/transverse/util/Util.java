/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.enterpriseal.transverse.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Clase de utilitarios transversales en la apl
 *
 * @author AdrianL
 */
public class Util {

    /**
     * Obtiene el data source con la fuente de datos
     *
     * @return
     * @throws IOException
     */
    public static DriverManagerDataSource getDataSource() throws IOException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        InputStream resp = Util.class.getResourceAsStream("co/com/enterpriseal/transverse/res/configuration.properties");
//        Properties properties = new Properties();
//        properties.load(resp);
//        dataSource.setDriverClassName(properties.getProperty("classname"));
//        dataSource.setUrl(properties.getProperty("url"));
//        dataSource.setUsername(properties.getProperty("username"));
//        dataSource.setPassword(properties.getProperty("password"));
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/activosfijos");
        dataSource.setUsername("postgres");
        dataSource.setPassword("adrian06");
        return dataSource;
    }
}
