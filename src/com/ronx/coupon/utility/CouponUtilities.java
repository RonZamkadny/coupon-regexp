package com.ronx.coupon.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CouponUtilities {

    public static List<String> readPage(URL url, Pattern pattern) {
        List<String> list = null;
        try (
                InputStreamReader isr = new InputStreamReader(url.openStream());
                BufferedReader in = new BufferedReader(isr);
        )   {
            String inputLine;
            Matcher matcher;
            list = new LinkedList<>();
            while ((inputLine = in.readLine()) != null) {
                matcher = pattern.matcher(inputLine);
                while (matcher.find()) {
                    list.add(matcher.group());
                }
            }
        }
        catch (IOException e) {}
        return list;
    }
}
