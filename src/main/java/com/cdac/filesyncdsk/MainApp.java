package com.cdac.filesyncdsk;

import com.cdac.filesyncdsk.conf.StageManager;
import com.cdac.filesyncdsk.view.FxmlView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
@SpringBootApplication
public class MainApp extends Application {

    protected ConfigurableApplicationContext springContext;
    protected StageManager stageManager;

    /**
     * launching the app
     *
     * @param args
     */
    public static void main(final String[] args) {
        launch(MainApp.class);
        System.out.println("IN Spring Boot");
    }

    /**
     * Initializing springBoot
     *
     * @throws Exception
     */
    @Override
    public void init() {
        springContext = springBootApplicationContext();
    }

    private ConfigurableApplicationContext springBootApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(MainApp.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        return builder.run(args);
    }

    /**
     * adding primaryStage to javaFX
     *
     * @param primaryStage Stage for javafx app
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
//        System.out.println("in start");   
//        stageManager = springContext.getBean(StageManager.class, primaryStage);
//        displayInitialScene();
//        System.out.println("IN Spring Boot start");
        System.out.println("primaryStage --> "+primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FileSync.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Displaying firstScene for the App
     */
    protected void displayInitialScene() {
        stageManager.switchScene(FxmlView.FileSync);
    }

    @Override
    public void stop() throws Exception {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }
}
