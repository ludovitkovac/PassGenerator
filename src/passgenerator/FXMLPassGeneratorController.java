package passgenerator;
// @author Ľudovít "Luigi" Kováč

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLPassGeneratorController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField password;

    @FXML
    private TextArea inputtext;

    private static String pass;
    private static String textString;


    @FXML
    private void handleButtonAction(ActionEvent event) {

        textString = inputtext.getText();

        char[] textArr = textString.toCharArray();

        pass = Character.toString(textArr[0]);

        for (int i = 1; i < textArr.length; i++) {

            if (textArr[i] == ' ') {

                switch (textArr[i + 1]) {
                    case 'o':
                    case 'O':
                        pass = pass + "0";
                        break;
                    case 'i':
                    case 'I':
                        pass = pass + "1";
                        break;
                    case 's':
                    case 'S':
                        pass = pass + "s";
                        break;
                    case 'b':
                    case 'B':
                        pass = pass + "8";
                        break;
                    default:
                        pass = pass + Character.toString(textArr[i + 1]);
                        break;
                }

            }

        }
        pass = pass + Character.toString(textArr[textArr.length - 1]);

        label.setText("Your generated password:");
        password.setText(pass);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
