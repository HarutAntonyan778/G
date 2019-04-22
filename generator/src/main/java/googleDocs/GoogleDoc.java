package googleDocs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import requests.Response;
import requests.controller.RestClient;

import java.util.*;
import java.util.stream.Collectors;

public class GoogleDoc {
    private final String BASE_URL = "https://sheets.googleapis.com";
    private final String API_STAGE = "v4";
    private final String SPREAD_SHEET = "spreadsheets";
    private final String API_KEY = "AIzaSyBRqsh-O_yjyop-QS0PrFTWPx69Jb0vyio";
    private final String SPREAD_SHEET_ID;

    public GoogleDoc(final String SPREAD_SHEET_ID) {
        this.SPREAD_SHEET_ID = SPREAD_SHEET_ID;
    }


    public List<String> getSheets() {
        final RestClient sheet = new RestClient(BASE_URL);
        sheet.addPathParameters(API_STAGE, SPREAD_SHEET, SPREAD_SHEET_ID);
        sheet.addQueryParameter("key", API_KEY);
        final Response sheetResponse = sheet.get();
        return Arrays.asList(sheetResponse.get("$.sheets[*].properties.title").split(", ")).parallelStream().map(String::trim).collect(Collectors.toList());
    }


    public List<Map<String, String>> getValuesFromSheet(final String sheetTitle, SheetType sheetType) throws ParseException {
        final RestClient sheet = new RestClient(BASE_URL);
        sheet.addPathParameters(API_STAGE, SPREAD_SHEET, SPREAD_SHEET_ID, "values", sheetTitle);
        sheet.addQueryParameter("key", API_KEY);
        final Response sheetResponse = sheet.get();
        final List<Map<String, String>> values = new ArrayList<>();
        JSONArray valuesArray = (JSONArray) new JSONParser().parse(JsonPath.read(sheetResponse.body(),"$.values").toString());
        if (sheetType == SheetType.VERTICAL) {
            JSONArray header = (JSONArray) new JSONParser().parse(JsonPath.read(sheetResponse.body(),"$.values[0]").toString());
            for (int i = 1; i < valuesArray.size(); i++) {
                JSONArray value = (JSONArray) valuesArray.get(i);

                Map<String,String> keys = new HashMap<>();
                for (int j = 0; j < header.size(); j++) {
                    if (header.get(j) != null && !header.get(j).toString().isEmpty() && j < value.size() && !keys.containsKey(header.get(j).toString())) {
                        keys.put(header.get(j).toString(),value.get(j).toString());
                    }
                }
                values.add(keys);
            }

        }
        return values;
    }

}
