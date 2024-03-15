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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sudokuGridController implements Initializable {

    @FXML
    private GridPane puzzle;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                TextField textField = new TextField();
                textField.setPrefSize(300, 300);
                puzzle.add(textField, row, column);
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
