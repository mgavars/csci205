/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Mar 24, 2019
* Time: 9:28:30 PM
*
* Project: csci205
* Package: gui.tempconvertermvc
* File: TempConverterController
* Description:
*
* ****************************************
 */
package gui.tempconvertermvc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author mag051
 */
public class TempConverterController implements EventHandler<ActionEvent> {

    private TempConverterModel theModel;
    private TempConverterView theView;
    private TempConverterController theCtrl;

    public TempConverterController(TempConverterModel theModel,
                                   TempConverterView theView) {
        this.theModel = theModel;
        this.theView = theView;
        this.theView.getBtnConvert().setOnAction(this);
        this.theView.getTxtFieldTempInput().setOnAction(this);
    }

    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                String fTemp = this.theView.getTxtFieldTempInput().getText();
                String result = theModel.FStringToC(fTemp);
                this.theView.getLblResult().setText(result);

            } catch (NumberFormatException numberformatexception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect input!");
                alert.setHeaderText("Incorrect input specified");
                alert.setContentText(String.format(
                        "Can not convert \"%s\"",
                        this.theView.getTxtFieldTempInput().getText()));
                alert.show();

            }
        }
    }

    ;


    @Override
    public void handle(ActionEvent event) {
        try {
            String fTemp = this.theView.getTxtFieldTempInput().getText();
            String result = theModel.FStringToC(fTemp);
            this.theView.getLblResult().setText(result);

        } catch (NumberFormatException numberformatexception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect input!");
            alert.setHeaderText("Incorrect input specified");
            alert.setContentText(String.format(
                    "Can not convert \"%s\"",
                    this.theView.getTxtFieldTempInput().getText()));
            alert.show();

        }
    }
};
