import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Core {

    public static void main(String... args) throws Exception {


//        String regexpString = "class=\"bcl-title-text\">\\p{L}+</[Aa]>";
        String regexpString = "class=\"bcl-title-text\">.*?</[Aa]>";

        Pattern pattern = Pattern.compile(regexpString);
//        String tokens[] = null;
//
//        tokens = pattern.split(page);


        String page = readPage(new URL("http://www.pokupon.by"), pattern);

        return;


    }

    private static String readPageApache(URL url, Pattern pattern) throws Exception {

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url.toURI());
        HttpResponse response = client.execute(request);

        Reader reader = null;
        try {
            reader = new InputStreamReader(response.getEntity().getContent());

            StringBuffer sb = new StringBuffer();
            {
                int read;
                char[] cbuf = new char[4096];
                while ((read = reader.read(cbuf)) != -1)
                    sb.append(cbuf, 0, read);
            }

            return sb.toString();

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String readPage(URL url, Pattern pattern) {
        URL oracle = null;
        BufferedReader in = null;
        String inputLine = null;
        Matcher matcher = null;

        StringBuilder pageStringBuilder = new StringBuilder();
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));

            int lineNumber = 0;
            List<String> list = new ArrayList<String>();

            while ((inputLine = in.readLine()) != null) {
                lineNumber++;
                matcher = pattern.matcher(inputLine);

                while (matcher.find()) {
//                    System.out.println(matcher.groupCount() + " " + matcher.start() + " " + lineNumber);
                    list.add(matcher.group());
                }

                pageStringBuilder.append(inputLine);


            }
            in.close();
        } catch (IOException e) {
        } finally {
        }
        return pageStringBuilder.toString();
    }

}
