package com.ronx.coupon.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PageScannerUtilities {

    public static List<String> readPage(URL url, Pattern pattern) {
//        StringBuilder pageStringBuilder = new StringBuilder(1);
        List<String> list = null;
        try (
                InputStreamReader isr = new InputStreamReader(url.openStream());
                BufferedReader in = new BufferedReader(isr);
        )   {
//            int lineNumber = 0;
            String inputLine = null;
            Matcher matcher = null;
            list = new LinkedList<String>();
            while ((inputLine = in.readLine()) != null) {
//                lineNumber++;
                matcher = pattern.matcher(inputLine);
                while (matcher.find()) {
//                    System.out.println(matcher.groupCount() + " " + matcher.start() + " " + lineNumber);
                    list.add(matcher.group());
                }
//                pageStringBuilder.append(inputLine);
            }
        }
        catch (IOException e) {}
        return list;
    }
}
