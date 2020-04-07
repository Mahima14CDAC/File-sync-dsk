package com.cdac.filesyncdsk.conf;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.stage.Stage;
//import org.hibernate.SessionFactory;
//import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Configuration class to add beans 
 * specified beans should always be in the same as or subpackage of 
 * configuration class
 * @author Mahima
 */
@Configuration
public class AppConfig {

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    /**
     * Adding session factory as a bean
     * @param hemf HibernateEntityManagerFactory
     * @return SessionFactory
     */
//    @Bean
//    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
//        return hemf.getSessionFactory();
//    }
    
    /**
     * Adding Bundle.properties as a bean
     * @return ResourceBundle
     */
    @Bean
    public ResourceBundle resourceBundle() {
        return ResourceBundle.getBundle("Bundle");
    }

    /**
     * Adding StageManager as a bean
     * @param stage
     * @return StageManager
     * @throws IOException 
     */
    @Bean
    @Lazy(value = true) //Stage only created after Spring context bootstrap
    public StageManager stageManager(Stage stage) throws IOException {
        return new StageManager(stage, springFXMLLoader);
    }
}
