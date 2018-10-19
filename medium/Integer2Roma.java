import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Integer2Roma
 */
public class Integer2Roma {

    private static Map<String, Integer> map = new LinkedHashMap<>();
    static {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }

    public static String inttoRoman(int num) {
        int remain = num;
        StringBuilder out = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(remain == 0) break;
            int div = remain / entry.getValue();
            if (div == 0 ) {
                continue;
            } else {
                //System.out.println(entry.getKey());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < div; i++) {
                    sb.append(entry.getKey());
                }
                remain = remain % entry.getValue();
                out.append(sb);
            }

        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(inttoRoman(Integer.valueOf(args[0])));
    }

}