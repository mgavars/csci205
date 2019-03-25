/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Mar 22, 2019
* Time: 1:21:18 PM
*
* Project: csci205
* Package: lab13
* File: TempConverter
* Description:
*
* ****************************************
 */
package lab13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author mag051
 */
public class TempConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btnConvert = new Button();
        btnConvert.setText("Convert!");

        VBox root = new VBox(5);
        root.setPrefWidth(250);
        root.setPadding(new Insets(10, 5, 10, 5));
        root.setAlignment(Pos.CENTER);

        FlowPane topCell = new FlowPane(Orientation.HORIZONTAL);
        topCell.setAlignment(Pos.CENTER);
        topCell.setHgap(10);
        topCell.getChildren().add(new Label("Temperature (F):"));

        final TextField txtFieldTempInput = new TextField();
        txtFieldTempInput.setAlignment(Pos.CENTER);
        txtFieldTempInput.setPrefColumnCount(5);
        topCell.getChildren().add(txtFieldTempInput);

        Label textNameOutput = new Label("");
        textNameOutput.setPrefWidth(75);
        textNameOutput.setPrefHeight(25);
        textNameOutput.setAlignment(Pos.CENTER);

        textNameOutput.setBorder(new Border(new BorderStroke(Color.BLACK,
                                                             BorderStrokeStyle.SOLID,
                                                             new CornerRadii(4.0),
                                                             BorderWidths.DEFAULT)));

        root.getChildren().add(topCell);
        root.getChildren().add(textNameOutput);
        root.getChildren().add(btnConvert);

        txtFieldTempInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    try {
                        double farenTemp = Double.parseDouble(
                                txtFieldTempInput.getText());
                        farenTemp = farenTemp * (9.0 / 5) + 32.0;
                        String celsiusTemp = String.format("%s C", farenTemp);
                        textNameOutput.setText(celsiusTemp);
                    } catch (NumberFormatException numberformatexception) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Incorrect input!");
                        alert.setHeaderText("Incorrect input specified");
                        alert.setContentText(String.format(
                                "Can not convert \"%s\"",
                                txtFieldTempInput.getText()));
                        alert.show();

                    }
                }
            }
        });

        btnConvert.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    double farenTemp = Double.parseDouble(
                            txtFieldTempInput.getText());
                    farenTemp = farenTemp * (9.0 / 5) + 32.0;
                    String celsiusTemp = String.format("%s C", farenTemp);
                    textNameOutput.setText(celsiusTemp);
                } catch (NumberFormatException numberformatexception) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Incorrect input!");
                    alert.setHeaderText("Incorrect input specified");
                    alert.setContentText(String.format(
                            "Can not convert \"%s\"",
                            txtFieldTempInput.getText()));
                    alert.show();

                }
            }
        });

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
