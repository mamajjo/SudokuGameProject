import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Welcome{

    private void setScene() throws IOException {
        Parent panel = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Main.window.setScene(new Scene(panel, 800,700));
    }

    @FXML
    private AnchorPane root;

    @FXML
    private SplitPane splitPane;

    @FXML
    private AnchorPane topPane;

    @FXML
    private AnchorPane botPane;

    @FXML
    private Button startButton;

    @FXML
    private MenuButton hardnessButton;

    @FXML
    private MenuItem easyButton;

    @FXML
    private MenuItem mediumButton;

    @FXML
    private MenuItem hardButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadGameButton;

    @FXML
    void loadGame(ActionEvent event) throws IOException  {
        Main.board = Main.fsbd.read();
        setScene();
    }

    public void setExitButton(){
        System.exit(0);
    }

    public void setEasyButton() throws IOException {
        GameHardness.EASY.setHardness(Main.board);
        setScene();
    }
    public void setMediumButton() throws IOException {
        GameHardness.MEDIUM.setHardness(Main.board);
        setScene();
    }
    public void setHardButton() throws IOException {
        GameHardness.HARD.setHardness(Main.board);
        setScene();
    }

}
