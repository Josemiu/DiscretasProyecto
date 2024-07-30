/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import com.pooespol.huffmannode.FileCompressor;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author José Miguel
 */
public class HuffmanController {

    @FXML
    private TextArea filePathArea;

    @FXML
    private TextArea outputArea;
    private File selectedFile;
    private final FileCompressor fileCompressor = new FileCompressor();

    @FXML
    private void handleSelectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File to Compress/Decompress");
        selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            filePathArea.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void handleCompressFile() {
        if (selectedFile != null) {
            try {
                String compressedFilePath = selectedFile.getAbsolutePath() + ".huff";
                fileCompressor.compressFile(selectedFile.getAbsolutePath(), compressedFilePath);
                outputArea.setText("File compressed successfully:\n" + compressedFilePath);
            } catch (IOException e) {
                outputArea.setText("Error during compression:\n" + e.getMessage());
            }
        } else {
            outputArea.setText("Please select a file first.");
        }
    }

    @FXML
    private void handleDecompressFile() {
        if (selectedFile != null) {
            try {
                String decompressedFilePath = selectedFile.getAbsolutePath().replace(".huff", "_decompressed.txt");
                fileCompressor.decompressFile(selectedFile.getAbsolutePath(), decompressedFilePath);
                outputArea.setText("File decompressed successfully:\n" + decompressedFilePath);
            } catch (IOException | ClassNotFoundException e) {
                outputArea.setText("Error during decompression:\n" + e.getMessage());
            }
        } else {
            outputArea.setText("Please select a file first.");
        }
    }
}

