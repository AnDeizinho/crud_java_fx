package com.example.agenda.components

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.control.TextField


class MyTextField : TextField {
    constructor(text:String, m:(Node,Insets)->Boolean): super(text){
        m(this, Insets(0.0,30.0,10.0,30.0))
    }
}