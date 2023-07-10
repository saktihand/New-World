import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.*;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegistrationUiController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private FontAwesomeIcon go_back_button;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfTitle1;

    
}

