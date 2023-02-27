import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pachong {
    public static void main(String[] args) throws IOException {
        System.out.println("hello,java");
        URL u = new URL("http://www.taohaoma.com/mobile/number");
        URLConnection urlConnection = u.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //-----------------------------------------
        Pattern compile = Pattern.compile("1[356789]\\d{9}");
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            Matcher matcher = compile.matcher(line);
            if (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}

