import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sudokuGridController implements Initializable {

    private TextField[][] textFields = new TextField[9][9];

    @FXML
    private GridPane puzzle;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                final int currentRow = row;
                final int currentColumn = column;

                TextField textField = new TextField();
                textField.setPrefSize(300, 300);
                puzzle.add(textField, column, row);
                textFields[row][column] = textField;
                textField.setFocusTraversable(true);

                textField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.UP && currentRow > 0) {
                        textFields[currentRow - 1][currentColumn].requestFocus();
                    } else if (event.getCode() == KeyCode.DOWN && currentRow < 8) {
                        textFields[currentRow + 1][currentColumn].requestFocus();
                    } else if (event.getCode() == KeyCode.LEFT && currentColumn > 0) {
                        textFields[currentRow][currentColumn - 1].requestFocus();
                    } else if (event.getCode() == KeyCode.RIGHT && currentColumn < 8) {
                        textFields[currentRow][currentColumn + 1].requestFocus();
                    }
                });
            }
        }
    }

    @FXML
    void keyPressed(KeyEvent event) {
        
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
