import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class isWellFormed {
    public static boolean verifyHtml(String html) {
        List<String> verifyList = new ArrayList<>();
        String[] tags = {"<p>", "<h1>", "<h2>", "<h3>", "<span>", "<a>", "<div>", "<ul>", "<li>"};

        for (String tag : tags) {
            int startIndex = html.indexOf(tag);
            while (startIndex != -1) {
                verifyList.add(tag);
                startIndex = html.indexOf(tag, startIndex + 1);
            }
            int endIndex = html.indexOf("</" + tag.substring(1));
            while (endIndex != -1) {
                if (verifyList.isEmpty() || !verifyList.remove(verifyList.size() - 1).equals(tag)) {
                    return false;
                }
                endIndex = html.indexOf("</" + tag.substring(1), endIndex + 1);
            }
        }
        
        if (verifyList.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean verifyUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder sb = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
            return verifyHtml(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}