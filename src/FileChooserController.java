import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserController {
    
//     @FXML
//     private Button button;

//     @FXML
//     private ImageView imgView;

//     @FXML
//     private Label label;

//     @FXML
//     void button(ActionEvent event) {
//         FileChooser fileChooser = new FileChooser();
//         fileChooser.setTitle("Open a file");
//         fileChooser.setInitialDirectory(new File("C:\\"));
//         fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File", "*,txt"));
//         Stage stage = (Stage) button.getScene().getWindow();
//         File selectedFile = fileChooser.showOpenDialog(stage);
//         if (selectedFile != null) {
//             label.setText(selectedFile.getName());
//             try{
//                 BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFile));
//                 StringBuilder stringBuilder = new StringBuilder();
//                 String line;
//                 while(line = bufferedReader.readLine()) != null{
//                     stringBuilder.append(line).append("\n");
//             }
//             System.out.println(stringBuilder.toString);
//         } catch (FileNotFoundException ee) {
//             throw new RuntimeException(ee);
//         } catch (IOException eeee){
//             throw new RuntimeException(eeee);
//         }
            
//     }else{
//         System.out.println("No file has been selected");
//     }
//     }
// }
@FXML
private ImageView square;

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
}