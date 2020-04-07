package com.cdac.filesyncdsk.conf;

import com.cdac.filesyncdsk.view.FxmlView;
import java.util.Objects;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Mahima
 */
public class StageManager {
    
    private final Stage primaryStage;
    private final SpringFXMLLoader springFXMLLoader;

    public StageManager(Stage primaryStage, SpringFXMLLoader springFXMLLoader) {
        this.primaryStage = primaryStage;
        this.springFXMLLoader = springFXMLLoader;
    }
    
    /**
     * to be used when user wants to switch among scenes
     * @param view the FXML view
     */
    public void switchScene(final FxmlView view){
        Parent viewRootNodeHierarchy=loadViewNodeHierarchy(view.getFxmlFile());
        show(viewRootNodeHierarchy, view.getTitle());
    }
    
    /**
     * setting up the scene for given view
     * @param rootNode parent node of fxml view
     * @param title title of the view
     */
    private void show(final Parent rootNode, String title){
        Scene scene=prepareScene(rootNode);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        
        try{
            primaryStage.show();
        }catch(Exception e){
            logAndExit("unable to show scene for titlte " +title, e);
        }
    
    }
    
    /**
     * getting the scene from stage or creating a new scene
     * @param rootNode parent of the view
     * @return object of scene
     */
    private Scene prepareScene(Parent rootNode){
        System.out.println("primaryStage --> "+primaryStage.getTitle());
        Scene scene=primaryStage.getScene();
        System.out.println("scene ---> "+scene);
        if(scene==null){
            System.out.println("rootNode --> "+rootNode);
            scene=new Scene(rootNode);
        }
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        scene.setRoot(rootNode);
        return scene;
    }
    
    /**
     * loading the fxml view
     * @param fxmlFilePath path of fxmlcfile
     * @return object of Parent
     */
    private Parent loadViewNodeHierarchy(String fxmlFilePath){
        Parent rootNode=null;
        try{
            System.out.println("file path "+fxmlFilePath);
        rootNode=springFXMLLoader.load(fxmlFilePath);
            System.out.println("CHECH HERERER --> "+rootNode);
        Objects.requireNonNull(rootNode,"A root fxml node must not be null");
        }catch(Exception e){
            logAndExit("unable to load fxml view"+fxmlFilePath, e);
        }
        return rootNode;
    }
    
    /**
     * log errors
     * @param errorMsg user specified message
     * @param exception exception occured
     */
    private void logAndExit(String errorMsg, Exception exception){
        Platform.exit();
    }

    /**
     * gets PrimaryStage
     * @return PrimaryStage 
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * gets SpringFXMLLoader
     * @return SpringFXMLLoader
     */
    public SpringFXMLLoader getSpringFXMLLoader() {
        return springFXMLLoader;
    }
    
    
    
}
