package com.example.agenda.controllers;

import com.example.agenda.components.MyLabel;
import com.example.agenda.components.MyTextField;
import com.example.agenda.model.Contato;
import com.example.agenda.model.DataContext;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private void clearFields()
    {
        this.contato.setId(0);
        this.contato.setFone("");
        this.contato.setSobrenome("");
        this.contato.setName("");
        this.contato.setEmail("");
        txtsobrenome.clear();
        txtnome.clear();
        txtFone.clear();
        txtEmail.clear();
    }
    public void onSalvarClick(MouseEvent event)
    {
        if(this.contato.getId() == 0)
            DataContext.db.insert(this.contato);
        else
            DataContext.db.update(this.contato);
        clearFields();
    }
    public void onNameChange(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
    {
        contato.setName(txtnome.getText().trim());
    }
    public void onSobreNomeChange(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
    {
        contato.setSobrenome(txtsobrenome.getText().trim());
    }
    public void onFoneChange(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
    {
        contato.setFone(txtFone.getText().trim());
    }
    public void onEmailChange(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
    {
        contato.setEmail(txtEmail.getText().trim());
    }
    public void init(Contato contato)
    {
        this.setStyle("-fx-background-color:#191970;");
        this.contato = contato;
        // ======================= txtnome ==========================//
        txtnome = new MyTextField(contato.getName(), this::updateMargin);
        txtnome.focusedProperty().addListener(this::onNameChange);

        // ======================= btnsalvar ==========================//
        txtsobrenome = new MyTextField(contato.getSobrenome(), this::updateMargin);
        txtsobrenome.focusedProperty().addListener(this::onSobreNomeChange);

        // ======================= btnsalvar ==========================//
        txtFone = new MyTextField(contato.getFone(), this::updateMargin);
        txtFone.focusedProperty().addListener(this::onFoneChange);

        // ======================= btnsalvar ==========================//
        txtEmail = new MyTextField(contato.getEmail(), this::updateMargin);
        txtEmail.focusedProperty().addListener(this::onEmailChange);

        // ======================= btnsalvar ==========================//
        btnsalvar = new Button("Salvar");
        btnsalvar.setOnMouseClicked(this::onSalvarClick);
        btnsalvar.setMinWidth(150);
        setMargin(btnsalvar, new Insets(30));

        //======================== Load controls =======================//
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
