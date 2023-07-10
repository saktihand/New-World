import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControlLokasi {

    @FXML
    private Hyperlink hyperclicked;

    @FXML
    private Label label;

    @FXML
    private ImageView square;

    @FXML
    private TextField tfKet;

    @FXML
    private TextField tfKet1;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfNama1;

    @FXML
    private TextField tfNama2;

    @FXML
    private TextField tfNominal;

    @FXML
    private WebView webView;

    @FXML
    void gantiFoto(ActionEvent event) throws IOException {
        FileChooser Chooser = new FileChooser();

        FileChooser.ExtensionFilter exxFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter exxFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");

        Chooser.getExtensionFilters().addAll(exxFilterJPG,exxFilterPNG);

        File file = Chooser.showOpenDialog(null);
        BufferedImage bufferedimg = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedimg, null);
        square.setImage(image);
    }

    @FXML
    void hyperclicked(ActionEvent event) {
        webView.getEngine().load("https://www.google.com/maps/@-7.7463552,110.3750522,14z?hl=id&entry=ttu");
    }

    @FXML
    void menuApp(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuApp.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
