package com.example.agenda.controllers;

import com.example.agenda.components.MyLabel;
import com.example.agenda.components.MyTextField;
import com.example.agenda.model.Contato;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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

    private boolean updateMargin(Node n, Insets i)
    {
        setMargin(n,i);
        return true;
    }
    public void init(Contato contato)
    {
        this.setStyle("-fx-background-color:#191970;");
        this.contato = contato;
        txtnome = new MyTextField(contato.getName(), this::updateMargin);
        txtsobrenome = new MyTextField(contato.getSobrenome(), this::updateMargin);
        txtFone = new MyTextField(contato.getFone(), this::updateMargin);
        txtEmail = new MyTextField(contato.getEmail(), this::updateMargin);
        btnsalvar = new Button("Salvar");
        btnsalvar.setMinWidth(150);
        setMargin(btnsalvar, new Insets(30));
        this.getChildren().add(new MyLabel("Nome:", 18));
        this.getChildren().add(txtnome);
        this.getChildren().add(new MyLabel("Sobrenome: ", 18));
        this.getChildren().add(txtsobrenome);
        this.getChildren().add(new MyLabel("Fone : ",18));
        this.getChildren().add(txtFone);
        this.getChildren().add(new MyLabel("Email: ",18));
        this.getChildren().add(txtEmail);
        this.getChildren().add(btnsalvar);
    }
}
