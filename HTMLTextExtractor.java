public class HTMLTextExtractor{
    private static boolean isTitle = false;

    public static void setIsTitle(boolean value) {
        isTitle = value;
    }
    
    public static boolean getIsTitle(){
        return isTitle;
    }

    public static String extractText(String html) {
        String text = "";
        String title = "";
        String wellFormed = "malformed HTML";
        setIsTitle(false);
        
        int titleStartIndex = html.indexOf("<title>");
        int titleEndIndex = html.indexOf("</title>");
        if (titleStartIndex != -1 && titleEndIndex != -1) {
            title += html.substring(titleStartIndex + 7, titleEndIndex).trim() + " ";
            setIsTitle(true);
        }

        String[] tags = { "<p>", "<h1>", "<h2>", "<h3>", "<span>", "<a>", "<div>", "<ul>", "<li>"};
        for (String tag : tags) {
            int startIndex = html.indexOf(tag);
            if (startIndex != -1) {
                int tagEndIndex = html.indexOf("</" + tag.substring(1), startIndex);
                int endIndex = html.indexOf("</" + tag.substring(1));
                text += html.substring(startIndex + tag.length(), endIndex).replaceAll("\\<.*?>","").trim() + " "; 
                
                int ulStartIndex = html.indexOf("<ul>", startIndex);
                if (tagEndIndex != -1 && ulStartIndex != -1 && ulStartIndex < tagEndIndex) {
                    endIndex = html.indexOf("</" + tag.substring(1), ulStartIndex);
                    if (endIndex != -1) {
                        text += html.substring(startIndex + tag.length(), endIndex).replaceAll("\\<.*?"," ").trim() + " ";
                        setIsTitle(false);
                    }
                } else {
                    int divStartIndex = html.indexOf("<div> | <h1> | <h2> | <h3> | <p> | <span>", startIndex);
                    endIndex = html.indexOf("</" + tag.substring(1), divStartIndex);
                    if (endIndex != -1) {
                        text += html.substring(startIndex + tag.length(), endIndex).replaceAll("\\<.*?"," ").trim() + " ";
                        setIsTitle(false);
                    }
                }
            }
        }
        
        if(getIsTitle() == true){
            return title.trim();
        } else{
            String tratedText = text.replaceAll("</?div>|</?p>|</?li>|</?ul>|</?span>", "");
            return tratedText.trim();
        }
    }

}