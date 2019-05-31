package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    private String currentOp = "";
    private boolean isNum = false;
    private double result = 0;

    String[] digits = {"0","1","2","3","4","5","6","7","8","9","."};
    String[] op = {"＋", "－", "×", "÷"};

    private static boolean containsEl(String inpt, String[] items){
        for (String d : items) {
            if (inpt.equals(d)) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private TextField display;

    @FXML
    public void btnClicked(ActionEvent actionEvent) {

        Button btn = (Button)actionEvent.getSource();
        String inText = btn.getText();

        if (inText.equals("CE") || inText.equals("C")) {
           if (inText.equals("CE")) {
               result = 0;
           }

           display.setText("0");
           currentOp = "";
           isNum = false;
           return;
        }

        if (containsEl(inText, digits)) {
            if (!isNum) {
                isNum = true;
                display.clear();
            }

            display.appendText(inText);
            return;
        }

        if (containsEl(inText, op)) {
            result = Double.parseDouble(display.getText());
            currentOp = inText;
            isNum = false;
            return;
        }

        if (inText.equals("=")) {
            double currentNum;
            if (isNum) {
                currentNum = Double.parseDouble(display.getText());
            } else {
                currentNum = result;
            }

            result = Main.calc(result, currentNum, currentOp.trim());

            display.setText(String.valueOf(result));
            isNum = false;
            return;
        }
    }
}
