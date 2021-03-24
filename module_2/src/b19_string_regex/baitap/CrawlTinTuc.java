package b19_string_regex.baitap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class CharArrayListToCharacter {
    public String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
}
public class CrawlTinTuc {
    public static void main(String[] args) {
        try {
            CharArrayListToCharacter charArrayListToCharacter = new CharArrayListToCharacter();
            URL url = new URL("https://vnexpress.net/the-gioi");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("title-news\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                ArrayList<Character> charArray = new ArrayList<>();
                boolean check = false;
                for (Character ch : m.group(1).toCharArray()) {
                    if (check) charArray.add(ch);
                    if (ch == '>') {
                        check = true;
                    }
                }

                System.out.println(charArrayListToCharacter.getStringRepresentation(charArray));
            }
            scanner.close();
            } catch(UnsupportedEncodingException | MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
        }
