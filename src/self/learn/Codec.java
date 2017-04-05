package self.learn;

import java.util.HashMap;
import java.util.Random;

/**
 * Encode and Decode TinyURL
 * @See also https://leetcode.com/problems/design-tinyurl/
 */
public class Codec {
    private String                  alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private HashMap<String, String> map      = new HashMap<>();
    private Random                  rand     = new Random();
    private String                  key      = getRand();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

    private String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/encode-and-decode-tinyurl";
        Codec codec = new Codec();
        System.out.println(codec.encode(url));
        codec.decode(codec.encode(url));
        System.out.println(codec.decode(codec.encode(url)));
    }
}
