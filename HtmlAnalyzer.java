import java.util.ArrayList;
import java.util.List;

public class HtmlAnalyzer {
    public static void main(String[] args) throws Exception {
        String url = args[0];
        String htmlExtract = TextExtractor.extract(url);
        boolean isHtmlWellFormed = isWellFormed.verifyUrl(url);

        if (isHtmlWellFormed) {
            String formattedText = htmlExtract.replaceAll("div|p|li|span", "");
            String[] textExtracted;
            String[] multiTextExtracted;
            boolean isTitle =  HTMLTextExtractor.getIsTitle();

            textExtracted = formattedText.split(">");
            multiTextExtracted = textExtracted[0].split(" ");

            if(multiTextExtracted.length > 1 && !isTitle){
                System.out.println(multiTextExtracted[0]);
            } else {
                System.out.println(textExtracted[0]);
            }
        } else {
            System.out.println("\nmalformed HTML");
        }
    }
}
