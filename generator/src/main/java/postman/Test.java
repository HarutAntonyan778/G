package postman;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Test {
    JSONObject test = new JSONObject();
    private JSONObject request;
    private JSONArray header;
    private JSONObject body;
    private JSONObject url;

    public Test setName(String name) {
        test.put("name",name);
        return this;
    }

    public Test setPostMethod(String postMethod) {
        createRequestIfNeeded();
        request.put("method",postMethod.toUpperCase());
        return this;
    }

    public Test setDescription(String description) {
        createRequestIfNeeded();
        request.put("description",description);
        return this;
    }

    public Test setHeader(String key, String value) {
        createHeaderIfNeeded();
        header.add(new Header(key, value).getHeader());
        return this;
    }

    public Test addRowBody(String json) {
        if (null == body) body = new JSONObject();
        body.put("mode","raw");
        body.put("raw",json);
        return this;
    }

    public Test addUrl(String url) {
        if (null == this.url) this.url = new JSONObject();
        this.url.put("raw",url);
        this.url.put("protocol",url.split("://")[0]);
        String[] q = url.split("\\?");
        if (q.length == 2 && !q[1].isEmpty()) {
            this.url.put("query",createQueries(q[1]));
        }
        this.url.put("host",createHost((url.split("://")[1]).split("/")[0]));
        String[] p = url.split("\\w+:\\/\\/[A-z\\.\\{\\}]*\\/");
        if (p.length > 1 && !p[1].isEmpty()) {
            this.url.put("path",createPath(p[1].split("\\?")[0]));
        }
        return this;
    }

    private JSONArray createPath(String path) {
        JSONArray p = new JSONArray();
        String paths[] = path.split("/");
        for (String s : paths) {
            p.add(s);
        }
        return p;
    }

    private JSONArray createHost(String host) {
        JSONArray h = new JSONArray();
        String[] hosts = host.split("\\.");
        for (String s : hosts) {
            System.out.println(s);
            h.add(s);
        }
        return h;
    }

    private JSONArray createQueries(String queries) {
        JSONArray query = new JSONArray();
        String[] qr = queries.split("&");
        for (String q : qr) {
            JSONObject jq = new JSONObject();
            jq.put("key",q.split("=")[0]);
            jq.put("value",q.split("=")[1]);
            query.add(jq);
        }
        return query;
    }

    private void createRequestIfNeeded() {
        if (null == request) request = new JSONObject();
    }

    private void createHeaderIfNeeded() {
        createRequestIfNeeded();
        if (null == header) header = new JSONArray();
    }

    public String generate() {
        if (null != header) request.put("header",header);
        if (null != url) request.put("url",url);
        if (null != body) request.put("body",body);
        test.put("request",request);
        test.put("response", new JSONObject());
        return test.toJSONString();
    }

}
