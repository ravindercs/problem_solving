import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class NumberToString {
    public static void main(String[] args) {
        convertToString("121");
    }

    //121
    //ADA BDB CDC AEA BEB CEC
    private static void convertToString(String num) {
        List<String> map = new ArrayList<String>();
        map.add("");//empty zero index
        map.add("ABC");
        map.add("DEF");
        map.add("GHI");
        map.add("JKL");
        map.add("MNO");
        map.add("PQR");
        map.add("STU");
        map.add("VWX");
        map.add("YZ");

        int len = num.length();
        for (int i = 0 ; i < len; i++) {
            int digit = Integer.parseInt(num.charAt(i)+"");
            String m = map.get(digit);

        }

    }

}