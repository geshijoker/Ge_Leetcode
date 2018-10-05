import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;

public class Codec {
    
    private static final String HEAD = "http://tinyurl.com/";
    private static final AtomicLong uniqueUrl = new AtomicLong();
    private static final ConcurrentHashMap<String, String> urlMap = new ConcurrentHashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = HEAD+uniqueUrl.getAndIncrement();
        urlMap.put(shortUrl,longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
