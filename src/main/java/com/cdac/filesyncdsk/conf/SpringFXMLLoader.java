package com.cdac.filesyncdsk.conf;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mahima
 */
@Component
public class SpringFXMLLoader {

    private final ResourceBundle resourceBundle;
    private final ApplicationContext context;

    @Autowired
    public SpringFXMLLoader(ResourceBundle resourceBundle, ApplicationContext context) {
        this.resourceBundle = resourceBundle;
        this.context = context;
    }

    /**
     * 
     * loads the fxml view i.e. FileSync or UploadFile
     * @param fxmlPath path of fxml file
     * @return Parent for fxml view
     * @throws IOException 
     */
    public Parent load(String fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        fxmlLoader.setControllerFactory(context::getBean);
        fxmlLoader.setResources(resourceBundle);
        return (Parent) fxmlLoader.load();
    }

}
