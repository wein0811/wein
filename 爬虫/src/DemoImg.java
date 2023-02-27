import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//爬网站的图片
public class DemoImg {//朱方方是个大傻逼

    public static void main(String[] args) throws IOException {
        URL u = new URL("http://www.hbpu.edu.cn/");
        URLConnection urlConnection = u.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Pattern compile = Pattern.compile("<img[\\s]+src[\\s]*=[\\s]*((['\"](?<src>[^'\"]*)[\\'\"]))");
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println( line);
            Matcher matcher = compile.matcher(line);
            if (matcher.find()) {
                String imgpath = matcher.group();
                imgpath = matcher.group().substring(10, imgpath.length() - 1);
                //System.out.println( "http://www.hbpu.edu.cn/" + imgpath);
                //----------------------------------------------------------------
                URL url = new URL("http://www.hbpu.edu.cn/" + imgpath);
                URLConnection urlConnection1 = url.openConnection();
                InputStream in = urlConnection1.getInputStream();
                byte[] buff = new byte[1024];
                int len = 0;
                File file;
                FileOutputStream out = new FileOutputStream("d:/" + Math.random() + ".jpg");
                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                //--------------------------------------------------------------------------
            }
        }
    }
}

