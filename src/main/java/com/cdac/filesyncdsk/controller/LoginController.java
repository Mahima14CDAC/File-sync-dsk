/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Mahima
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton bLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bLogin.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setTitle("JavaFX WebView Example");
            WebView webView = new WebView();
            webView.getEngine().load("https://mail.google.com/mail/u/0/");
            VBox vBox = new VBox(webView);
            Scene scene = new Scene(vBox, 960, 600);
            stage.setScene(scene);
            stage.show();
        });
    }

}
