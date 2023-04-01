import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TextExtractor {
    public static String extract(String url) {
        String error = "URL connection error";
        try {
            URL URLAdress = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(URLAdress.openStream()));

            String line;
            StringBuilder html = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                html.append(line);
            }

            return HTMLTextExtractor.extractText(html.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return error;
        }
    }
}