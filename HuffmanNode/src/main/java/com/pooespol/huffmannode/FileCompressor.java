/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.huffmannode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 *
 * @author José Miguel
 */
public class FileCompressor {

    public void compressFile(String inputFilePath, String outputFilePath) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(inputFilePath)));
        HuffmanEncoder encoder = new HuffmanEncoder(text);
        String encodedText = encoder.encode(text);
        Map<Character, String> huffmanCodes = encoder.getCodigosHuffman();

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFilePath))) {
            outputStream.writeObject(huffmanCodes);
            outputStream.writeObject(encodedText);
        }
    }

    public void decompressFile(String compressedFilePath, String outputFilePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(compressedFilePath))) {
            Map<Character, String> huffmanCodes = (Map<Character, String>) inputStream.readObject();
            String encodedText = (String) inputStream.readObject();

            HuffmanTree huffmanTree = new HuffmanTree("");
            huffmanTree.getRaiz(); 

            HuffmanDecoder decoder = new HuffmanDecoder(huffmanTree);
            String decodedText = decoder.decode(encodedText);

            Files.write(Paths.get(outputFilePath), decodedText.getBytes());
        }
    }
}
