package er.sujal.sharma.URL_Shortener.utility;


import org.springframework.stereotype.Component;
@Component
public class Base62 {

	private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE = 62;

    // Encode numeric ID to base62
    public String encodeBase62(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(BASE62.charAt((int) (num % BASE)));
            num /= BASE;
        }
        return sb.reverse().toString();
    }

    // Decode base62 string to numeric ID (not required here but good to have)
    public long decodeBase62(String str) {
        long num = 0;
        for (int i = 0; i < str.length(); i++) {
            num = num * BASE + BASE62.indexOf(str.charAt(i));
        }
        return num;
    }
}