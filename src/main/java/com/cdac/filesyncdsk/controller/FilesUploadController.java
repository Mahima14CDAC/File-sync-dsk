/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.cdac.filesyncdsk.Constants;
import com.cdac.filesyncdsk.conf.StageManager;
import com.cdac.filesyncdsk.domain.FileMetaJsonResponse;
import com.cdac.filesyncdsk.domain.FormatsJsonResponse;
import com.cdac.filesyncdsk.domain.UserJsonResponse;
import com.cdac.filesyncdsk.util.Alerts;
import com.cdac.filesyncdsk.util.FixityGeneration;
import com.cdac.filesyncdsk.view.FxmlView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import static java.sql.Timestamp.valueOf;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.UUID;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.tika.io.IOUtils;
//import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mahima
 */
@Component
public class FilesUploadController implements Initializable{
    
    @FXML
    private JFXButton bBrowse;
    
    @FXML
    private TextField folderLocation;
    
    @FXML
    private VBox folderList;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        folderList.setBackground(new Background(new BackgroundFill(Paint.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    /**
     * event handler for browse button
     *
     * @param event
     */
    @FXML
    void handleBrowseAction(ActionEvent event) {
        List<String> format = new ArrayList<>();
        format.add("*.pdf");
        format.add("*.txt");
        format.add("*.fxml");
        System.out.println("in browse");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Upload files");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedDirectory = directoryChooser.showDialog(new Stage());
        folderLocation.setText(selectedDirectory.getAbsolutePath());
        String folderPath = folderLocation.getText();
        if(folderPath != ""){
            File dir = new File(folderPath);
            String[] contentInFolder = dir.list();
            for(String content:contentInFolder){
                File isDir = new File(folderPath+File.separator+content);
                if(isDir.isDirectory()){
                    CheckBox c = new CheckBox(isDir.getName()); 
                    folderList.getChildren().add(c);//setContent(c);
                }
            }
        }
    }

}
