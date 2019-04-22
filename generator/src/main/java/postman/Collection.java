package postman;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Collection {
    public JSONObject collection = new JSONObject();
    public JSONObject info = new JSONObject();
    public JSONArray items = new JSONArray();

    public Collection(String name, String description) {
        info.put("name",name);
        info.put("description",description);
        info.put("_postman_id","");
        info.put("schema","https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
    }

    public Collection addTest(Test test) {
        test.generate();
        items.add(test.test);
        return this;
    }

    public String generate() {
        collection.put("info",info);
        collection.put("items",items);
        return collection.toJSONString();
    }

}
