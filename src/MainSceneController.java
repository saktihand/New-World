import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javax.imageio.ImageIO;
import javax.swing.text.AbstractDocument.Content;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.web.WebView;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;

public class MainSceneController implements Initializable {

    private Stage stage;
    private Scene scene;

    List lstFile;

    @FXML
    private Button btnLog;

    @FXML
    private Button btnUser;
    
    @FXML
    private TextField textFieldNamaRekening;

    @FXML
    private TextField textFieldNoRekening;

    @FXML
    private TextField textFieldNamaBank;

    @FXML
    private TextField textFieldNominal;

     @FXML
    private TextField textFieldKeterangan;

    @FXML
    private TextField textFieldNomor;

     @FXML
    private Button buttonsubmit;

    @FXML
    private  Button buttonremove;

    @FXML
    private CheckBox checkBox;

    @FXML
    private FontAwesomeIcon go_back_button;

    @FXML
    private Hyperlink hyperclicked;

    @FXML
    private Button labelRegis;

    @FXML
    private Button labelpassword;

    @FXML
    private TextField passwordText;

    @FXML
    private Label labSingleFile;

    @FXML
    private Button homescreen;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNohandphone;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private TextField tfUsername;

    @FXML
    private Button btnDon;

    @FXML
    private ImageView square;

    @FXML
    private Label loginMessagelabel;

    @FXML
    private WebView webView;

    @FXML
    private Button btnMultipleFileChooser;

    @FXML
    private PasswordField passwordHidden;

    @FXML
    private ImageView Logo;
    
    @FXML
    private TextField tfTitle;

    @FXML
    void btnDonate(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {

        }
        ((Node) event.getSource()).getScene().getWindow().hide();

    }

    @FXML
    void btnLoginClicked(ActionEvent event) {
        DataBaseConnection connection = new DataBaseConnection();
        connection.accountLogin("ACTONT.db");
        String username = tfTitle.getText();
        String password = passwordHidden.getText();
        if (connection.loginUser(username,password)){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuApp.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();
            System.out.println("Successfully logged in");

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }else{
    }
    }

    @FXML
    void createAccount(ActionEvent event) {
        DataBaseConnection connection = new DataBaseConnection();
        connection.accountLogin("ACTONT.db");
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        String email = tfEmail.getText();
        String noHandphone = tfNohandphone.getText();
        connection.createAccount(username, password, email, noHandphone);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private Pane content_area;

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void openLink(ActionEvent event) {
        //System.out.println("Link Clicked!");
        //webView.getEngine().load("http://www.google.com");
    }

    @FXML
    void menu(ActionEvent event) throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void btnInfor(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PasswordShow.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void btnUser(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneProfile.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void alamSutera(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("JadwalAlamSutera.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void bantul(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("JadwalBantul.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void menuApp(ActionEvent event) throws IOException{
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

    @FXML
    void mendoloKidul(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("JadwalMendolo.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    @FXML
    void menuInfor(ActionEvent event) throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformasiJadwal.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void btnOrder(ActionEvent event) throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lokasi.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void btnNews(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformasiJadwal.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void tampilRegistrasi(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationNew.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void btnSubmit(ActionEvent event) {
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

    @FXML
    void tampilPassword(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgotPassword.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    // @FXML
    // void multiFileChooser(ActionEvent event) {
    //     FileChooser fc = new FileChooser();
    //     fc.getExtensionFilters().add(new ExtensionFilter("IMG Files", "*lstFile"));
    //     List <File> f = fc.showOpenMultipleDialog(null);
    //     for (File file : f) {
    //         System.out.println(file.getAbsolutePath());
    //     }
    // }

    @FXML
    void btnHelp(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("about.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void hyperlink(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lokasi.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ACTONT");
            stage.show();

        } catch (IOException e) {
            
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }    

    @FXML
    private void hyperclicked(ActionEvent event) {
    webView.getEngine().load("https://www.google.com/maps/");
    }

   @FXML
   void changeVisibility(ActionEvent event) {
    if (checkBox.isSelected()) {
        passwordText.setText(passwordHidden.getText());
        passwordText.setVisible(true);
        passwordHidden.setVisible(false);
        return;
    }
    passwordHidden.setText(passwordText.getText()); 
    passwordHidden.setVisible(true);
    passwordText.setVisible(false);
    }
}

    // @Override
    // public void initialize(URL url, ResourceBundle rb) {
    //     lstFile = new ArrayList<>();
    //     lstFile.add("*.jpg");
    //     lstFile.add("*.png");
    //     lstFile.add("*.jpeg");
    // }
