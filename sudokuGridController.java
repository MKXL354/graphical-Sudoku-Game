import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sudokuGridController implements Initializable {

    private TextField[][] textFields = new TextField[9][9];
    private final int rank = 9;

    @FXML
    private GridPane puzzle;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Populate the puzzle grid with textFields
        for (int row = 0; row < rank; row++) {
            for (int column = 0; column < rank; column++) {
                final int currentRow = row;
                final int currentColumn = column;

                TextField textField = new TextField();
                addTextFormatter(textField);
                textField.setPrefSize(300, 300);
                puzzle.add(textField, column, row);
                textFields[row][column] = textField;
                textField.setFocusTraversable(true);

                // Textfield traversal controller
                textField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.UP && currentRow > 0) {
                        textFields[currentRow - 1][currentColumn].requestFocus();
                    } else if (event.getCode() == KeyCode.DOWN && currentRow < rank - 1) {
                        textFields[currentRow + 1][currentColumn].requestFocus();
                    } else if (event.getCode() == KeyCode.LEFT && currentColumn > 0) {
                        textFields[currentRow][currentColumn - 1].requestFocus();
                    } else if (event.getCode() == KeyCode.RIGHT && currentColumn < rank - 1) {
                        textFields[currentRow][currentColumn + 1].requestFocus();
                    }
                });
            }
        }
    }

    private void addTextFormatter(TextField textField) {
        UnaryOperator<Change> textFilter = c -> {
            // To handle single digit 1 to rank
            String regex = String.format("[1-%d]", rank);
            if (c.getText().matches(regex)) {
                c.setRange(0, textField.getText().length());
                return c;
            } else if (c.getText().isEmpty()) {
                // Adds backSpace as removal option
                return c;
            }
            return null;
        };

        TextFormatter<Integer> formatter = new TextFormatter<Integer>(textFilter);
        textField.setTextFormatter(formatter);
    }

    @FXML
    void backButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/difSelect.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
