package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.event.ActionEvent;

public class HelloController {

    @FXML
    private TextField first,second;

    @FXML
    private Label bytext;

    @FXML
    private Button sup1, sup2, sup3, sup4, sup5;

    public void onButtonClick(javafx.event.ActionEvent actionEvent) {
        try {
            double num1 = Double.parseDouble(first.getText());
            double num2 = Double.parseDouble(second.getText());
            switch (((Button) actionEvent.getSource()).getText()) {
                case "+":
                    bytext.setText(String.valueOf((num1 + num2)));
                    break;
                case "-":
                    bytext.setText(String.valueOf((num1 - num2)));
                    break;
                case "*":
                    bytext.setText(String.valueOf((num1 * num2)));
                    break;
                case "/":
                    bytext.setText(String.valueOf((num1 / num2)));
                    break;
                case "%":
                    bytext.setText(String.valueOf((num1 % num2)));
                    break;
            }
        }
        catch (NumberFormatException e) {
            bytext.setText("Error");
        }
    }
}