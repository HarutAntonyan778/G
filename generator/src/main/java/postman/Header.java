package postman;

import org.json.simple.JSONObject;

class Header {
    private String key,value;

    Header(String key, String value) {
        this.key = key;
        this.value = value;
    }

    JSONObject getHeader() {
        JSONObject header = new JSONObject();
        header.put("key",key);
        header.put("value",value);
        return header;
    }
}
