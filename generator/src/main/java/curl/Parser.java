package curl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static Pattern urlPattern = Pattern.compile("(http[\\w/:\\.\\{\\}\\?=&]*)");
    private static Pattern requestTypePattern = Pattern.compile("(POST|GET|PUT|DELETE|OPTIONS)");
    private static Pattern headPattern = Pattern.compile("-H ['\\\"](.*):[\\s]*(.*)['\\\"]");
    private static Pattern dataPattern = Pattern.compile("(-d|--data-binary|--data) ['\\\"]((.*[\n\\s]?)+)['\\\"]");
    private static Pattern multipartBodyPattern = Pattern.compile("-F ['\\\"]?(.*)=[\\s]*(.*)['\\\"]?");

    public static void parse(String curl) {
        System.out.println(curl);
        boolean success = false;

        Matcher reqType_m = requestTypePattern.matcher(curl);
        if (reqType_m.find()) {
            System.out.println("Request Type ---> " + reqType_m.group(0));
        }

        /**
         * URL
         */
        Matcher url_m = urlPattern.matcher(curl);
        if (url_m.find()) {
//            request.setUrl(url_m.group(1));
            System.out.println("url --> " + url_m.group(1));
            success = true;
        }
        /**
         * -H
         */
        Matcher heads_m = headPattern.matcher(curl);
        while (heads_m.find()) {
            System.out.println("Header - key --->" + heads_m.group(1) + "  value ---> " + heads_m.group(2));
        }
        /**
         * -F
         */

        /**

        /**
         * --data-binary -d --data
         */
        Matcher data_bin_m = dataPattern.matcher(curl);
        if (data_bin_m.find()) {
            System.out.println("Data_bin --->" +data_bin_m.group(2));
        }

        System.out.println("Finish");
        Matcher multipart_m = multipartBodyPattern.matcher(curl);
        System.out.println(false);
        while (multipart_m.find()) {
            System.out.println(true);
            System.out.println("multipart - key --->" + multipart_m.group(1) + "  value ---> " + multipart_m.group(2));
        }
        System.out.println(true);
    }
}
