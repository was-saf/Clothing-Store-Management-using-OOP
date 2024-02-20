package oopproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptGenerator {
    public void generateReceipts() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Invoice.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("Receipts.txt", true))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
