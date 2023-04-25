package com.example.agenda.controllers;

import com.example.agenda.model.Contato;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class AddContato extends VBox {
    public Contato contato;
    private TextField txtnome;
    private TextField txtsobrenome;
    private TextField txtFone;
    private TextField txtEmail;
    private Button btnsalvar;
    public AddContato()
    {
        this.init(new Contato(0,"","","",""));
    }
    public AddContato(Contato contato)
    {
        init(contato);
    }
    public void init(Contato contato)
    {
        this.setStyle("-fx-background-color:WHITE;");
        this.setPadding(new Insets(50));
        setStyle("-fx-background-color:WHITE;");
        this.contato = contato;
        txtnome = new TextField(contato.getName());
        setMargin(txtnome, new Insets(10,30,20,30));
        txtsobrenome = new TextField(contato.getSobrenome());
        txtFone = new TextField(contato.getFone());
        txtEmail = new TextField(contato.getEmail());
        btnsalvar = new Button("Salvar");
        this.getChildren().add(new Label("Nome: "));
        this.getChildren().add(txtnome);
        this.getChildren().add(new Label("Sobrenome: "));
        this.getChildren().add(txtsobrenome);
        this.getChildren().add(new Label("Fone : "));
        this.getChildren().add(txtFone);
        this.getChildren().add(new Label("Email: "));
        this.getChildren().add(txtEmail);
        this.getChildren().add(btnsalvar);
    }
}
