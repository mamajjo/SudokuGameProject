import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static SudokuBoard board;
    static Stage window;
    static FileSudokuBoardDao fsbd = SudokuBoardDaoFactory.getFileDao("/Users/Maciej/Documents/Uczelnia/IVsemestr/SudokuGameProject/Model/src/main/resources/fields.txt");
    static JdbcSudokuBoardDao jsbd = SudokuBoardDaoFactory.getDataBaseDao();


    public void setUpScene(int width, int height, String path) throws IOException {
//        String fxmlWelcome = "welcome.fxml";
        Parent panel = FXMLLoader.load(getClass().getResource(path));
        window.setScene(new Scene(panel,width,height));
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        board = new SudokuBoard();
        SudokuSolver solver = new BackTrackingSudokuSolver();
        solver.solve(board);
        Main.window = primaryStage;
        //welcomescene
        setUpScene(400, 600,"welcome.fxml");
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
