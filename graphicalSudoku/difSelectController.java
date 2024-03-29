package graphicalSudoku;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DifSelectController {

    @FXML
    private Button backButton;

    @FXML
    private Button easyButton;

    @FXML
    private Button hardButton;

    @FXML
    private Button mediumButton;

    private Object changeScene(String newScene) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(newScene));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage) backButton.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    void backButtonPressed(ActionEvent event) {
        changeScene("FXML/mainMenu.fxml");
    }

    @FXML
    void easyButtonPressed(ActionEvent event) {
        SudokuGridController controller = (SudokuGridController) changeScene("FXML/sudokuGrid.fxml");
        controller.init(0);
    }

    @FXML
    void mediumButtonPressed(ActionEvent event) {
        SudokuGridController controller = (SudokuGridController) changeScene("FXML/sudokuGrid.fxml");
        controller.init(1);
    }

    @FXML
    void hardButtonPressed(ActionEvent event) {
        SudokuGridController controller = (SudokuGridController) changeScene("FXML/sudokuGrid.fxml");
        controller.init(2);
    }

}
