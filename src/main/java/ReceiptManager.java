import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReceiptManager {
    public void saveReceipt(Order order) {
        try {
            String filename = generateFileName();
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(order.getOrderSummary());
            bufferedWriter.close();

            System.out.println("\nReceipt saved: " + filename + "\n");
        } catch (IOException e) {
            System.err.println("Error saving receipt");
        }
    }

    private String generateFileName() {
        //Using DTF to get today's date by the requested format and making that the file name
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return "src/receipts/" + LocalDateTime.now().format(formatter) + ".txt";
    }

}
