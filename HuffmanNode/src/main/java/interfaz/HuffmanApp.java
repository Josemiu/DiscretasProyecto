/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *
 * @author José Miguel
 */

public class HuffmanApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println(getClass().getResource(""));
        Parent root = FXMLLoader.load(getClass().getResource("/resources/HuffmanApp.fxml"));
        primaryStage.setTitle("Huffman Compression Tool");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

