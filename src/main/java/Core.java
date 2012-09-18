import com.ronx.coupon.service.CouponService;
import com.ronx.coupon.utility.PageScannerUtilities;

import javax.xml.ws.Endpoint;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

public class Core {

    public static void main(String... args) throws Exception {


//        String regexpString = "class=\"bcl-title-text\">\\p{L}+</[Aa]>";

//        String tokens[] = null;
//
//        tokens = pattern.split(page);

        Pattern pokuponPattern = Pattern.compile("class=\"bcl-title-text\">.*?</[Aa]>");
        List<String> pokuponList = PageScannerUtilities.readPage(new URL("http://www.pokupon.by"), pokuponPattern);


        return;
    }

}
