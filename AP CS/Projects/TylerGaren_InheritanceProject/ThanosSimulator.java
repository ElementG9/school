

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class ThanosSimulator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ThanosSimulator extends Application
{
    // We keep track of the count, and label displaying the count:
    private long people = 7700000000L;
    private int snaps = 0;
    private Label peopleLabel = new Label(Long.toString(people) + " people");
    private Label snapsLabel = new Label(Integer.toString(snaps) + " snaps");
    

    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        // Create a Button or any control item
        Button thanos = new Button("I am inevitable");
        Button ironman = new Button("I am Iron Man");
        
        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        thanos.setOnAction(this::snap);
        ironman.setOnAction(this::restore);

        // Add the button and label into the pane
        pane.add(thanos, 0, 0);
        pane.add(ironman, 0, 1);
        pane.add(peopleLabel, 1, 0);
        pane.add(snapsLabel, 1, 1);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 300,100);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void snap(ActionEvent event)
    {
        // Counts number of button clicks and shows the result on a label
        people = people / 2;
        snaps++;
        peopleLabel.setText(Long.toString(people) + " people");
        snapsLabel.setText(Integer.toString(snaps) + " snaps");
    }
    private void restore(ActionEvent event)
    {
        if (people < 1)
            return;
        // Counts number of button clicks and shows the result on a label
        people = 7700000000L;
        snaps++;
        peopleLabel.setText(Long.toString(people) + " people");
        snapsLabel.setText(Integer.toString(snaps) + " snaps");
    }
}
