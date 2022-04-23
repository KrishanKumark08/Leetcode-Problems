import java.util.UUID;

public class Codec {
    HashMap<String, String> map = new HashMap();
    
    public String encode(String longUrl) {
        String uniqueId = getUniqueId();
        map.put(uniqueId, longUrl);
        return "http://tinyurl.com/" + uniqueId;
    }
    
    public String decode(String shortUrl) {
        int index = shortUrl.indexOf(".com/");
		
        String uniqueId = shortUrl.substring(index + 5);
        return map.get(uniqueId);
    }
    
    private String getUniqueId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(6);
    }
}