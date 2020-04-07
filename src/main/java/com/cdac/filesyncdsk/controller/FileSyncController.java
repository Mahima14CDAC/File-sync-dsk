package com.cdac.filesyncdsk.controller;

import com.cdac.filesyncdsk.Constants;
import com.cdac.filesyncdsk.conf.StageManager;
import com.cdac.filesyncdsk.domain.FormatsJsonResponse;
import com.cdac.filesyncdsk.domain.UserJsonResponse;
import com.cdac.filesyncdsk.util.Alerts;
import com.cdac.filesyncdsk.view.FxmlView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.scene.input.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class FileSyncController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXDrawer drawerPane;

    @FXML
    private WebView webView;

    private Alerts alert = new Alerts();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        drawer.open();
        try {
            VBox sidePane = FXMLLoader.load(getClass().getResource("/fxml/SidePane.fxml"));
            drawer.setSidePane(sidePane);

            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                        try {
                            switch (node.getAccessibleText()) {
                                case "Login":
                                    System.out.println("CHECK HERE!!! " + drawer);
                                    AnchorPane rLogin = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
                                    System.out.println("side pane " + rLogin.getId());
                                    drawerPane.getChildren().setAll(rLogin);
                                    rLogin.setBackground(new Background(new BackgroundFill(Paint.valueOf("#4CAF50"), CornerRadii.EMPTY, Insets.EMPTY)));
                                    break;
                                case "Select Folder":
                                    System.out.println("CHECK HERE 2!!! " + drawer);
                                    AnchorPane rBrowse = FXMLLoader.load(getClass().getResource("/fxml/SelFolder.fxml"));
                                    System.out.println("side pane 2 " + rBrowse.getId());
                                    drawerPane.getChildren().setAll(rBrowse);
                                    rBrowse.setBackground(new Background(new BackgroundFill(Paint.valueOf("#0288D1"), CornerRadii.EMPTY, Insets.EMPTY)));
                                    break;
                                case "Sync":
                                    System.out.println("CHECK HERE 3!!! " + drawer);
                                    AnchorPane rSync = FXMLLoader.load(getClass().getResource("/fxml/Sync.fxml"));
                                    System.out.println("side pane 3 " + rSync.getId());
                                    drawerPane.getChildren().setAll(rSync);
                                    rSync.setBackground(new Background(new BackgroundFill(Paint.valueOf("#C21858"), CornerRadii.EMPTY, Insets.EMPTY)));
                                    break;
                                case "Exit":
                                    System.exit(0);
                                    break;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(FileSyncController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }

//            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
//            transition.setRate(-1);
//            hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
//                transition.setRate(transition.getRate() * -1);
//                transition.play();
//                if (drawer.isShown()) {
//                    System.out.println("Open");
//                    drawer.close();
//                } else {
//                    System.out.println("Close");
//                    drawer.open();
//                }
//            });
        } catch (IOException ex) {
            Logger.getLogger(FileSyncController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
