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
package lab13.tempconvertmvc;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
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
    private BorderPane root;
    private Button btnConvert;
    private Label lblResult;
    private TextField txtFieldTempInput;
    private Label lblUnits;
    private RadioButton rbFtoC;
    private RadioButton rbCtoF;

    public TempConverterView(TempConverterModel theModel) {
        this.theModel = theModel;

        root = new BorderPane();
        root.setPrefWidth(300);
        root.setPrefHeight(150);
        root.setPadding(new Insets(15, 15, 15, 15));

        //root.setAlignment(Pos.CENTER);
        FlowPane topCell = new FlowPane(Orientation.HORIZONTAL);
        topCell.setAlignment(Pos.CENTER);
        topCell.setHgap(10);

        topCell.getChildren().add(new Label("Temperature"));

        txtFieldTempInput = new TextField();
        txtFieldTempInput.setAlignment(Pos.CENTER);
        txtFieldTempInput.setPrefColumnCount(5);
        topCell.getChildren().add(txtFieldTempInput);

        lblResult = new Label("");
        lblResult.setPrefWidth(75);
        lblResult.setPrefHeight(25);
        lblResult.setAlignment(Pos.CENTER);

        lblUnits = new Label("(F)");
        topCell.getChildren().add(lblUnits);

        lblResult.setBorder(new Border(new BorderStroke(Color.BLACK,
                                                        BorderStrokeStyle.SOLID,
                                                        new CornerRadii(4.0),
                                                        BorderWidths.DEFAULT)));

        btnConvert = new Button();
        btnConvert.setText("Convert!");

        root.setTop(topCell);
        root.setCenter(lblResult);
        root.setBottom(btnConvert);

        final ToggleGroup group = new ToggleGroup();

        rbFtoC = new RadioButton("F to C");
        rbFtoC.setToggleGroup(group);
        rbFtoC.setSelected(true);

        rbCtoF = new RadioButton("C to F");
        rbCtoF.setToggleGroup(group);

        VBox leftCell = new VBox(10);

        leftCell.getChildren().add(rbFtoC);
        leftCell.getChildren().add(rbCtoF);

        root.setLeft(leftCell);

        BorderPane.setAlignment(btnConvert, Pos.CENTER);
    }

    public BorderPane getRootNode() {
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

    public RadioButton getRbFtoC() {
        return rbFtoC;
    }

    public RadioButton getRbCtoF() {
        return rbCtoF;
    }

    public Label getLblUnits() {
        return lblUnits;
    }

}
