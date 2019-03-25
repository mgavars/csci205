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
package gui.tempconvertermvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mag051
 */
public class TempConverterMain extends Application {

    private TempConverterModel theModel;
    private TempConverterView theView;
    private TempConverterController theCtrl;

    @Override
    public void init() throws Exception {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        this.theModel = new TempConverterModel();
        this.theView = new TempConverterView(theModel);
        this.theCtrl = new TempConverterController(theModel, theView);

    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(this.theView.getRootNode());

        primaryStage.setTitle("F to C Converter");
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
