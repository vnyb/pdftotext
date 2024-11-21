package io.github.vnyb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import io.github.jonathanlink.PDFLayoutTextStripper;

public class PDFToText {

    public static void main(String[] args) {
        // Check if an argument is provided
        if (args.length < 1) {
            System.out.println("Usage: java PdfToText <path-to-pdf>");
            return;
        }

        // Get the file path from the command-line arguments
        String pdfPath = args[0];
        String string = null;

        try {
            File file = new File(pdfPath);

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("Error: File not found at " + pdfPath);
                return;
            }

            // Parse the PDF file
            PDFParser pdfParser = new PDFParser(new RandomAccessFile(file, "r"));
            pdfParser.parse();

            // Process the parsed document
            try (PDDocument pdDocument = new PDDocument(pdfParser.getDocument())) {
                PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
                string = pdfTextStripper.getText(pdDocument);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred.");
            e.printStackTrace();
        }

        // Print the extracted text
        if (string != null) {
            System.out.println(string);
        } else {
            System.out.println("No text could be extracted from the PDF.");
        }
    }
}
