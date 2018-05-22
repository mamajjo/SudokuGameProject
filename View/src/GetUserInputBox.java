import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GetUserInputBox{
    private static Button continueButton = new Button();
    private static Button cancelButton = new Button();

    public static void insertValue(String title, String message, SudokuField sudokuField, int index) {
        final Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(400);

        Label info = new Label();
        info.setText(message);

        cancelButton.setText("Click to go back");
        cancelButton.setOnAction(e -> window.close());

        TextField textField = new TextField("Pass value to the cell");

        continueButton.setText("Press after passing a value above!");
        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sudokuField.setFieldValue(0);
                SudokuBoardController.fields.get(index).setText("0");
                Cell.setCell(index/ SudokuBoard.dimension,index% SudokuBoard.dimension);
                if (!(Main.board.isNumberValid(Integer.parseInt(textField.getText())))) {
                    textField.setText("You entered wrong value to the cell");
                    Main.board.showFieldsBoard();
                    }
                    else {
                    sudokuField.setFieldValue(Integer.parseInt(textField.getText()));
                    window.close();
                }
            }
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(info, textField,continueButton, cancelButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,200,200);
        window.setScene(scene);
        window.showAndWait();

    }

}
