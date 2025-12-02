import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSelector extends Application {
   @Override
   public void start(Stage primaryStage) {
      Text text = new Text("Programming is fun!");
      text.setStyle("-fx-font-size: 36px;");

      // Create scroll bars for RGBA
      ScrollBar redBar = new ScrollBar();
      ScrollBar greenBar = new ScrollBar();
      ScrollBar blueBar = new ScrollBar();
      ScrollBar opacityBar = new ScrollBar();

      // Set ranges
      redBar.setMin(0); redBar.setMax(255);
      greenBar.setMin(0); greenBar.setMax(255);
      blueBar.setMin(0); blueBar.setMax(255);
      opacityBar.setMin(0); opacityBar.setMax(1); // opacity between 0 and 1

      // Update text color whenever a bar changes
      redBar.valueProperty().addListener((obs, oldVal, newVal) -> updateColor(text, redBar, greenBar, blueBar, opacityBar));
      greenBar.valueProperty().addListener((obs, oldVal, newVal) -> updateColor(text, redBar, greenBar, blueBar, opacityBar));
      blueBar.valueProperty().addListener((obs, oldVal, newVal) -> updateColor(text, redBar, greenBar, blueBar, opacityBar));
      opacityBar.valueProperty().addListener((obs, oldVal, newVal) -> updateColor(text, redBar, greenBar, blueBar, opacityBar));

      VBox pane = new VBox(10, text, redBar, greenBar, blueBar, opacityBar);
      Scene scene = new Scene(pane, 400, 250);

      primaryStage.setTitle("Exercise 16.17 - Color Selector");
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   private void updateColor(Text text, ScrollBar r, ScrollBar g, ScrollBar b, ScrollBar o) {
      text.setFill(Color.color(
         r.getValue() / 255.0,
         g.getValue() / 255.0,
         b.getValue() / 255.0,
         o.getValue()
      ));
   }

   public static void main(String[] args) {
      launch(args);
   }
}
