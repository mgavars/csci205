/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Mar 24, 2019
* Time: 5:39:06 PM
*
* Project: csci205
* Package: lab13
* File: SimpleTree
* Description:
*
* ****************************************
 */
package lab13;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author mag051
 */
public class SimpleTree extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Scene scene = new Scene(root, 500, 500);

        scene.setFill(Color.DARKGRAY);
        primaryStage.setTitle("Shapes Demo");

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
