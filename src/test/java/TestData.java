import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestData {

    @DataProvider(name = "csvCheckoutData")
    public static Object[][] getCsvCheckoutData() {
        List<Object[]> records = new ArrayList<>();
        // Direct file path from your Downloads folder
        String filePath = "C:\\Users\\CCST\\Downloads\\testdata.csv";

        try (InputStream is = new FileInputStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            // Skip the first line (header)
            String headerLine = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] fields = line.split(",");
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].trim();
                }
                records.add(fields);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading CSV file: " + e.getMessage(), e);
        }

        return records.toArray(new Object[0][]);
    }
}