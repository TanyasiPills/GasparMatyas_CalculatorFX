package com.example.calculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;

public class HelloController {

    @FXML
    private TextField first;
    @FXML
    private TextField second;

    @FXML
    private Label bytext;

    @FXML
    private Button sup1, sup2, sup3, sup4, sup5;

    public void initialize() {
        second.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                second.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        first.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                first.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

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
                    if (num2 == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Nem lehet nulla az osztó");
                        alert.showAndWait();
                        return;
                    }
                    bytext.setText(String.format("%.2f", num1 / num2));
                    break;
                case "%":
                    if (num2 == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Nem lehet nulla a moduló");
                        alert.showAndWait();
                        return;
                    }
                    bytext.setText(String.valueOf((num1 % num2)));
                    break;
            }
        }
        catch (NumberFormatException e) {
            bytext.setText("Error");
        }
    }
}