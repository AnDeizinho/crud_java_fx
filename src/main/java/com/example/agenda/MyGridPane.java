package com.example.agenda;

import com.example.agenda.model.Contato;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.function.Predicate;

public class MyGridPane extends GridPane {
    public Contato contato;
    public MyGridPane(VBox context, Contato contato)
    {
        this.contato = contato;
        MyLabel lblName = new MyLabel(contato.getName()+" "+contato.getSobrenome(), 26.0);
        MyLabel lblEmail = new MyLabel(contato.getEmail(), 13.0);
        MyLabel lblFone = new MyLabel(contato.getFone(), 13.0);
        Button delete = new Button("Deletar");
        Button edit = new Button("Editar");
        this.setAlignment(Pos.CENTER);
        this.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        this.setStyle("-fx-label-padding: 10;-fx-background-color: #303030;");
        this.add(lblName,0,0);
        setColumnSpan(lblName,6);

        this.add(lblEmail,0,1);
        setColumnSpan(lblEmail,2);

        this.add(lblFone,2,1);
        setColumnSpan(lblFone,2);

        this.add(delete,4,1);
        this.add(edit,5,1);

        this.getColumnConstraints().add(new ColumnConstraints(100));
        this.getColumnConstraints().add(new ColumnConstraints(100));
        this.getColumnConstraints().add(new ColumnConstraints(100));
        this.getColumnConstraints().add(new ColumnConstraints(100));
        this.getColumnConstraints().add(new ColumnConstraints(100));
        this.getColumnConstraints().add(new ColumnConstraints(100));
        this.getRowConstraints().add(new RowConstraints());
        this.getRowConstraints().add(new RowConstraints());

        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                context.getChildren().removeIf(new Predicate<Node>() {
                    @Override
                    public boolean test(Node node) {
                        MyGridPane pn = (MyGridPane) node;
                        return pn.contato.getId() == contato.getId();
                    }
                });
            }
        });

        edit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                BorderPane AP = (BorderPane) context.getParent().getParent().getParent().getParent().getParent().getParent();
                AP.setCenter(new AddContato(contato));
            }
        });
    }
}
