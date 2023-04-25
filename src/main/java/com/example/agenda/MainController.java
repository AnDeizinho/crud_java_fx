package com.example.agenda;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public BorderPane AP;

    @FXML
    private Button btnListar;

    @FXML
    private Button btnAdd;

    private void loaderPage(String page){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        AP.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        btnListar.setOnMouseClicked(mouseEvent -> {
            loaderPage("my-vbox");
        });
        btnAdd.setOnMouseClicked(mouseEvent -> {
            AP.setCenter(new AddContato());
        });
    }
}