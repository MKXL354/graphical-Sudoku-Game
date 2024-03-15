import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class difSelectController {

    @FXML
    private Button backButton;

    @FXML
    private Button easyButton;

    @FXML
    private Button hardButton;

    @FXML
    private Button mediumButton;

    private void changeScene(String newScene) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(newScene));
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage)backButton.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void backButtonPressed(ActionEvent event) {
        changeScene("FXML/mainMenu.fxml");
    }

    @FXML
    void easyButtonPressed(ActionEvent event) {
        changeScene("FXML/sudokuGrid.fxml");
    }

    @FXML
    void hardButtonPressed(ActionEvent event) {

    }

    @FXML
    void mediumButtonPressed(ActionEvent event) {

    }

}
