import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * 
 */
public class FXMLDocumentController implements Initializable {
    ObservableList data = observableArrayList();
        // new MOTEKAR("aep","27 juni 2004", "yogyakarta" , "aset 2")
        // );

// deklarasi untuk objek di fxml
   

    @FXML
    private TextField textFieldNamaRekening;

    @FXML
    private TextField textFieldNoRekening;

    @FXML
    private TableColumn tbltanggal;

    @FXML
    private TextField textFieldNamaBank;

    @FXML
    private TextField textFieldNominal;

     @FXML
    private TextField textFieldKeterangan;

    @FXML
    private DatePicker textDatePicker;

    @FXML
    private TextField textFieldNomor;

     @FXML
    private Button buttonsubmit;

    @FXML
    private  Button buttonremove;

    @FXML
    private TableView table;

    @FXML
    private TableColumn tblNamaRekening;

    @FXML
    private TableColumn tblNoRekening;

    @FXML
    private TableColumn taInformation;

    @FXML
    private TableColumn tblNamaBank;
    
    @FXML
    private TableColumn tblNominal;
    
    @FXML
    private TableColumn tblKeterangan;
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String NamaRekening = textFieldNamaRekening.getText();
        String NoRekening = textFieldNoRekening.getText();
        String NamaBank = textFieldNamaBank.getText();
        String Nominal = textFieldNominal.getText();
        String Keterangan = textFieldKeterangan.getText();
        data.add(new MOTEKAR(NamaRekening, NoRekening, NamaBank, Nominal, Keterangan));
        textFieldNamaRekening.setText("");
        textFieldNoRekening.setText("");
        textFieldNamaBank.setText("");
        textFieldNominal.setText("");
        textFieldKeterangan.setText("");

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
    private void getHapus(ActionEvent event) {
        int nomor = Integer.parseInt(textFieldNomor.getText());
        int x = nomor-1;
        data.remove(x);
        textFieldNomor.setText("");
    }

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tblNamaRekening.setCellValueFactory(new PropertyValueFactory<MOTEKAR,String>("NamaRekening"));
        tblNoRekening.setCellValueFactory(new PropertyValueFactory<MOTEKAR,String>("NoRekening"));
        tblNamaBank.setCellValueFactory(new PropertyValueFactory<MOTEKAR,String>("NamaBank"));
        tblNominal.setCellValueFactory(new PropertyValueFactory<MOTEKAR,String>("Nominal"));
        tblKeterangan.setCellValueFactory(new PropertyValueFactory<MOTEKAR,String>("Keterangan"));

        table.setItems(data);
    }    
    
}
