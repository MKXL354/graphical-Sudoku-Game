package graphicalSudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/mainMenu.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Sudoku Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
// TODO: add 3x3 blocks
// TODO: add timer
// TODO: add stop and resume
// TODO: beautify
// TODO: maybe add animations
// TODO: add leaderboard
// TODO: maybe weak the way the puzzle is loaded
// TODO: maybe refacor the code