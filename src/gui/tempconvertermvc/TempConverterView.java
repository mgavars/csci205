/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Mar 24, 2019
* Time: 9:28:20 PM
*
* Project: csci205
* Package: gui.tempconvertermvc
* File: TempConverterView
* Description:
*
* ****************************************
 */
package gui.tempconvertermvc;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author mag051
 */
public class TempConverterView {

    private TempConverterModel theModel;
    private VBox root;
    private Button btnConvert;
    private Label lblResult;
    private TextField txtFieldTempInput;

    public TempConverterView(TempConverterModel theModel) {
        this.theModel = theModel;

        root = new VBox(5);
        root.setPrefWidth(250);
        root.setPadding(new Insets(10, 5, 10, 5));
        root.setAlignment(Pos.CENTER);

        FlowPane topCell = new FlowPane(Orientation.HORIZONTAL);
        topCell.setAlignment(Pos.CENTER);
        topCell.setHgap(10);

        topCell.getChildren().add(new Label("Temperature (F):"));

        txtFieldTempInput = new TextField();
        txtFieldTempInput.setAlignment(Pos.CENTER);
        txtFieldTempInput.setPrefColumnCount(5);
        topCell.getChildren().add(txtFieldTempInput);

        lblResult = new Label("");
        lblResult.setPrefWidth(75);
        lblResult.setPrefHeight(25);
        lblResult.setAlignment(Pos.CENTER);

        lblResult.setBorder(new Border(new BorderStroke(Color.BLACK,
                                                        BorderStrokeStyle.SOLID,
                                                        new CornerRadii(4.0),
                                                        BorderWidths.DEFAULT)));

        btnConvert = new Button();
        btnConvert.setText("Convert!");

        root.getChildren().add(topCell);
        root.getChildren().add(lblResult);
        root.getChildren().add(btnConvert);
    }

    public VBox getRootNode() {
        return root;
    }

    public Button getBtnConvert() {
        return btnConvert;
    }

    public TextField getTxtFieldTempInput() {
        return txtFieldTempInput;
    }

    public Label getLblResult() {
        return lblResult;
    }

}
