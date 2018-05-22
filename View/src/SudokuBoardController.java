import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.collections4.Get;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SudokuBoardController implements EventHandler<ActionEvent> {

    @FXML
    private Button field0;

    @FXML
    private Button field9;

    @FXML
    private Button field18;

    @FXML
    private Button field1;

    @FXML
    private Button field10;

    @FXML
    private Button field19;

    @FXML
    private Button field2;

    @FXML
    private Button field11;

    @FXML
    private Button field20;

    @FXML
    private Button field3;

    @FXML
    private Button field12;

    @FXML
    private Button field21;

    @FXML
    private Button field4;

    @FXML
    private Button field13;

    @FXML
    private Button field22;

    @FXML
    private Button field5;

    @FXML
    private Button field14;

    @FXML
    private Button field23;

    @FXML
    private Button field6;

    @FXML
    private Button field15;

    @FXML
    private Button field24;

    @FXML
    private Button field7;

    @FXML
    private Button field16;

    @FXML
    private Button field25;

    @FXML
    private Button field8;

    @FXML
    private Button field17;

    @FXML
    private Button field26;

    @FXML
    private Button field27;

    @FXML
    private Button field36;

    @FXML
    private Button field45;

    @FXML
    private Button field28;

    @FXML
    private Button field37;

    @FXML
    private Button field46;

    @FXML
    private Button field29;

    @FXML
    private Button field38;

    @FXML
    private Button field47;

    @FXML
    private Button field30;

    @FXML
    private Button field39;

    @FXML
    private Button field48;

    @FXML
    private Button field31;

    @FXML
    private Button field40;

    @FXML
    private Button field49;

    @FXML
    private Button field32;

    @FXML
    private Button field41;

    @FXML
    private Button field50;

    @FXML
    private Button field33;

    @FXML
    private Button field42;

    @FXML
    private Button field51;

    @FXML
    private Button field34;

    @FXML
    private Button field43;

    @FXML
    private Button field52;

    @FXML
    private Button field35;

    @FXML
    private Button field44;

    @FXML
    private Button field53;

    @FXML
    private Button field54;

    @FXML
    private Button field63;

    @FXML
    private Button field72;

    @FXML
    private Button field55;

    @FXML
    private Button field64;

    @FXML
    private Button field73;

    @FXML
    private Button field56;

    @FXML
    private Button field65;

    @FXML
    private Button field74;

    @FXML
    private Button field57;

    @FXML
    private Button field66;

    @FXML
    private Button field75;

    @FXML
    private Button field58;

    @FXML
    private Button field67;

    @FXML
    private Button field76;

    @FXML
    private Button field59;

    @FXML
    private Button field68;

    @FXML
    private Button field77;

    @FXML
    private Button field60;

    @FXML
    private Button field69;

    @FXML
    private Button field78;

    @FXML
    private Button field61;

    @FXML
    private Button field70;

    @FXML
    private Button field79;

    @FXML
    private Button field62;

    @FXML
    private Button field71;

    @FXML
    private Button field80;

    @FXML
    private Button startingGame;

    @FXML
    private Button endGame;

    @FXML
    private Button saveGame;

    @FXML
    void saveGame(ActionEvent event){
        Main.fsbd = SudokuBoardDaoFactory.getFileDao("/Users/Maciej/Documents/Uczelnia/IVsemestr/SudokuGameProject/Model/src/main/resources/fields.txt");
        try {
            Main.fsbd.write(Main.board);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button checkGameButton;

    @FXML
    void checkGame(ActionEvent event) {
        if(Main.board.checkBoard()) {
            System.out.printf("Congratulations!");
            Main.window.close();
        }
        else
        {
            System.out.printf("Something has gone wrong");
        }
    }

    public static List<Button> fields = new ArrayList<Button>();

    void addButtons() {
        fields.add(field0);
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        fields.add(field4);
        fields.add(field5);
        fields.add(field6);
        fields.add(field7);
        fields.add(field8);
        fields.add(field9);
        fields.add(field10);
        fields.add(field11);
        fields.add(field12);
        fields.add(field13);
        fields.add(field14);
        fields.add(field15);
        fields.add(field16);
        fields.add(field17);
        fields.add(field18);
        fields.add(field19);
        fields.add(field20);
        fields.add(field21);
        fields.add(field22);
        fields.add(field23);
        fields.add(field24);
        fields.add(field25);
        fields.add(field26);
        fields.add(field27);
        fields.add(field28);
        fields.add(field29);
        fields.add(field30);
        fields.add(field31);
        fields.add(field32);
        fields.add(field33);
        fields.add(field34);
        fields.add(field35);
        fields.add(field36);
        fields.add(field37);
        fields.add(field38);
        fields.add(field39);
        fields.add(field40);
        fields.add(field41);
        fields.add(field42);
        fields.add(field43);
        fields.add(field44);
        fields.add(field45);
        fields.add(field46);
        fields.add(field47);
        fields.add(field48);
        fields.add(field49);
        fields.add(field50);
        fields.add(field51);
        fields.add(field52);
        fields.add(field53);
        fields.add(field54);
        fields.add(field55);
        fields.add(field56);
        fields.add(field57);
        fields.add(field58);
        fields.add(field59);
        fields.add(field60);
        fields.add(field61);
        fields.add(field62);
        fields.add(field63);
        fields.add(field64);
        fields.add(field65);
        fields.add(field66);
        fields.add(field67);
        fields.add(field68);
        fields.add(field69);
        fields.add(field70);
        fields.add(field71);
        fields.add(field72);
        fields.add(field73);
        fields.add(field74);
        fields.add(field75);
        fields.add(field76);
        fields.add(field77);
        fields.add(field78);
        fields.add(field79);
        fields.add(field80);


    }

    public void setUpButtons() {
        addButtons();
        for (int i = 0; i < fields.size(); i++) {
            fields.get(i).setText(String.valueOf(Main.board.getBoard().get(i).getFieldValue()));
        }
        for (int i = 0; i < fields.size(); i++) {
            if (Main.board.getBoard().get(i).getFieldValue() != 0)
                fields.get(i).setDisable(true);
        }
        startingGame.setDisable(true);
        for (Button but : fields) {
            but.setOnAction(this);
        }
        endGame.setOnAction(e -> System.exit(0));

    }

    // obsługa wypełniania formularza
    @Override
    public void handle(ActionEvent event) {
        int index = 0;
        for (Button but : fields) {
            if (event.getSource() == but) {
                GetUserInputBox.insertValue("ValueBox", "Try to pass valid value", Main.board.getBoard().get(index), index);
                fields.get(index).setText(String.valueOf(Main.board.getBoard().get(index).getFieldValue()));
            } else
                index++;
        }
    }
}
