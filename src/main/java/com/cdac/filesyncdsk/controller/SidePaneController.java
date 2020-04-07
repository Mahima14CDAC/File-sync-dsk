/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

/**
 *
 * @author Mahima
 */
public class SidePaneController {

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton selFolder;

    @FXML
    private JFXButton sync;

    @FXML
    void browseHandler(ActionEvent event) {
        System.out.println("browse folder check -----------");
        selFolder.getStyleClass().add("selected-button");
    }

    @FXML
    void loginHandler(ActionEvent event) {
        login.setBackground(new Background(new BackgroundFill(Paint.valueOf("#4CAF50"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @FXML
    void syncHandler(ActionEvent event) {
        sync.setBackground(new Background(new BackgroundFill(Paint.valueOf("#4CAF50"), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
