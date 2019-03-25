/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Mar 24, 2019
* Time: 11:50:43 PM
*
* Project: csci205
* Package: lab13
* File: RectTreeNode
* Description:
*
* ****************************************
 */
package lab13;

import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author mag051
 */
public class RectTreeNode extends Rectangle {

    private static final double INIT_WIDTH = 100;
    private static final double INIT_HEIGHT = 75;

    public RectTreeNode(Paint fillColor) {
        super(INIT_WIDTH, INIT_HEIGHT, fillColor);
        setupEffects();
    }

    private void updateLinePosition(Line line, RectTreeNode r1, RectTreeNode r2) {
        line.setStartX(r1.getX() + r1.getWidth() / 2);
        line.setStartY(r1.getY() + r1.getHeight() / 2);
        line.setEndX(r2.getX() + r2.getWidth() / 2);
        line.setEndY(r2.getX() + r2.getWidth() / 2);
    }

    private void setupEffects() {
        DropShadow ds = new DropShadow();
        ds.setOffsetX(4.0);
        ds.setOffsetY(4.0);
        ds.setColor(Color.BLACK);
        this.setEffect(ds);
    }

    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("SimpleTree!");
        primaryStage.setScene(scene);
        primaryStage.show();

        RectTreeNode r1 = new RectTreeNode(Color.BLUE);
        r1.setX(200);
        r1.setY(100);

        RectTreeNode r2 = new RectTreeNode(Color.LIGHTBLUE);
        r2.setX(75);
        r2.setY(250);

        RectTreeNode r3 = new RectTreeNode(Color.LIGHTBLUE);
        r3.setX(75);
        r3.setY(250);

        Line line1to2 = new Line();
        line1to2.setStrokeWidth(3);
        updateLinePosition(line1to2, r1, r2);
        Line line1to3 = new Line();
        line1to3.setStrokeWidth(3);
        updateLinePosition(line1to3, r1, r3);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("SimpleTree!");
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
