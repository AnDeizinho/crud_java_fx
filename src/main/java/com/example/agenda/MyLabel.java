package com.example.agenda;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class MyLabel extends Label {
    public MyLabel(final String text, final double font)
    {
        this.setText(text);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-label-padding: 10;");
        this.setPadding(new Insets(10,10,10,10));
        this.setTextFill(Paint.valueOf("WHITE"));
        this.setFont(Font.font(font));
    }
}
