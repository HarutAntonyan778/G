import curl.Parser;
import googleDocs.GoogleDoc;
import googleDocs.SheetType;
import net.minidev.json.parser.ParseException;
import postman.Collection;
import postman.Test;
import util.FileHelpers;
import util.types.FileTypes;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
       List<File> files = FileHelpers.getAllFilesInDirectory(
               "/home/harut/workspace/beachbody/APIs/qe-bod-api/tests/Nutrition/v2/nutritionTracker/User_Water_Goal/Android",FileTypes.FEATURE);


//        FileHelpers.replaceInFileIfContains(files,"validate response JSON structure (i.e. there are no missing fields)","validate response JSON structure (i.e. there are no missing fields)\n" +
//                "\n" +
//                "\n" +
//                "  @generate_token\n" +
//                "  Scenario: Set valid parameters\n" +
//                "    Given I create HTTP \"POST\" request to \"UserAPI\" API with \"oauth/authorize\" endpoint\n" +
//                "    And I set multipart data fields\n" +
//                "      | response_type | code |\n" +
//                "    And I set client_id and client_secret multipart data fields for BBC\n" +
//                "    When I send the request\n" +
//                "    And I store \"$.access_token\" value in data with \"access_token\" key\n" +
//                "\n" +
//                "  Scenario Outline: Check response body for generate_token_001\n" +
//                "    Then \"<object>\" exists\n" +
//                "    And \"<object>\" is not null or empty\n" +
//                "\n" +
//                "    Examples:\n" +
//                "      | object          |\n" +
//                "      | $.access_token  |\n" +
//                "      | $.expires_in    |\n" +
//                "      | $.token_type    |\n" +
//                "      | $.refresh_token |\n" +
//                "\n" +
//                "  Scenario: Check response body for generate_token_01\n" +
//                "    Then \"$.scope\" exists\n" +
//                "    And \"$.scope\" is null\n" +
//                "\n" +
//                "  Scenario: Check response body for generate_token_02\n" +
//                "    Then \"$.refresh_token\" is equal to \"access_token\" retrieved from stored data\n" +
//                "\n" +
//                "  Scenario: Check response body for generate_token_03\n" +
//                "    Then \"$.expires_in\" is equal to 3600\n" +
//                "\n" +
//                "  Scenario: Check response body for generate_token_04\n" +
//                "    Then \"$.token_type\" is equal to \"Bearer\"\n" +
//                "\n" +
//                "  Scenario: Check response code for generate_token\n" +
//                "    Then the response code should be equal to 200\n" +
//                "\n" +
//                "  @external_user_registration\n" +
//                "  Scenario: Set valid parameters\n" +
//                "    Given I create HTTP \"POST\" request to \"ExternalUserAPI\" API with \"api/externaluser/receipt\" endpoint\n" +
//                "    And I set default value of \"x-api-key\" header for \"External\"\n" +
//                "    And I set \"Bearer\" Authorization header as \"$.access_token\" retrieved from stored data\n" +
//                "    And I set multipart data fields\n" +
//                "      | password                | Beach1234$%#^&* |\n" +
//                "      | firstName               | Instigate          |\n" +
//                "      | lastName                | Mobile             |\n" +
//                "      | sourceSystem            | apple              |\n" +
//                "      | deviceLocale            | en_US              |\n" +
//                "      | purchaseRegion          | US                 |\n" +
//                "      | termsAndConditionsAgree | true               |\n" +
//                "    And I set randomly generated email to \"emailAddress\" multipart data parameter and I store the value\n" +
//                "    And I create random number for \"transactionID\" multipart data parameter and I store the value\n" +
//                "    And I set multipart data files from environment file:\n" +
//                "      | non-renewed.receipt |\n" +
//                "    When I send the request\n" +
//                "    And I store \"$.guid\" value in data with \"guid\" key\n" +
//                "    And wait for 6 seconds\n" +
//                "\n" +
//                "  Scenario: Check response parameter for external_user_registration\n" +
//                "    Then \"$.guid\" exists\n" +
//                "\n" +
//                "  Scenario: Check response code for external_user_registration\n" +
//                "    Then the response code should be equal to 201\n" +
//                "\n" +
//                "\n" +
//                " ","And I set \"Authorization\" header as default value for \"guid\"");
//
//        FileHelpers.replaceInFiles(files,"And I set default value of \"x-api-key\" header for \"NutritionTrackerAPIkey\"","And I set default value of \"x-api-key\" header for \"NutritionTrackerIosAPIkey\"");
//        FileHelpers.replaceInFiles(files,"with default \"guid\"","with stored \"guid\"");
//        FileHelpers.replaceInFiles(files,"And I set \"Authorization\" header as default value for \"guid\"","And I set \"Authorization\" header as \"guid\" retrieved from stored data");
        FileHelpers.appendInFirstLine(files,"@android");
    }
}
