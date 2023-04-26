package com.example.agenda.components;

import com.example.agenda.model.Contato;
import com.example.agenda.model.DataContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MyVbox implements Initializable {

    @FXML
    private VBox vblista;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<MyGridPane> bs = new ArrayList();
        for (Contato c: DataContext.db.selectAll()) {
            bs.add(new MyGridPane(vblista, c));
        }
        vblista.getChildren().addAll(bs);
    }
}
