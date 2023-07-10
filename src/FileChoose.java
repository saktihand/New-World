import java.awt.image.BufferedImage;
import java.io.*;

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



public class FileChoose {

    @FXML
    private Label label;

    @FXML
    ImageView square;

    // @FXML
    // void button(ActionEvent event) {
    //     FileChooser fileChooser = new FileChooser();
    //     fileChooser.setTitle("Open a file");
    //     fileChooser.setInitialDirectory(new File(System.getProperty("user.home")+ "C:\\"));
    //     fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG Image","*.jpg"), new FileChooser.ExtensionFilter("PNG Image", "*.png"), new FileChooser.ExtensionFilter("All image files","*.jpg","*.png"));
    //     //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file","*.txt"));
    //     // this is for saving a file. remove the setInitialFileName if you are opening a file
    //     //fileChooser.setInitialFileName("Untitled");
    //     //File selectedFile = fileChooser.showOpenDialog(stage);
    //     Stage stage = (Stage) button.getScene().getWindow();
    //     File selectedFile = fileChooser.showOpenDialog(stage);
    //     if(selectedFile != null){

    //         // this is for saving a file
    //         try {
    //             FileWriter fileWriter = new FileWriter(selectedFile);
    //             BufferedWriter writer = new BufferedWriter(fileWriter);
    //             writer.write("Learning how to use the JavaFX FileChooser");
    //             writer.close();
    //             System.out.println("The file has been saved in "+ selectedFile.getAbsolutePath());
    //         } catch (IOException e) {
    //             throw new RuntimeException(e);
    //         }

    //             //this is for opening a file
    //             // label.setText(selectedFile.getName());
    //             // Image image = new Image(selectedFile.getPath());
    //             // imgView.setImage(image);


    //             /*This is for reading a text file
    //             try {
    //                 BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFile));
    //                 StringBuilder stringBuilder = new StringBuilder();
    //                 String line;
    //                 while((line = bufferedReader.readLine()) != null){
    //                     stringBuilder.append(line).append("\n");
    //                 }
    //                 System.out.println(stringBuilder.toString());
    //             } catch (FileNotFoundException e) {
    //                 throw new RuntimeException(e);
    //             } catch (IOException e) {
    //                 throw new RuntimeException(e);
    //             }*/
    //     }else{
    //         System.out.println("No file has been selected");
    //     }
    // }

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