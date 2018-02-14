package ru.stqa.pft.addressbook.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;

import java.util.Set;

public class RestApiHelper {

  public RestApiHelper() {

    RestAssured.authentication= RestAssured.basic("28accbe43ea112d9feb328d2c00b3eed", "");

  }

  public int getIssueStatusFromBugify(int issueId){

    String json=RestAssured//.given()
            //parameter("issue_id",issueId).
            .get(String.format("http://demo.bugify.com/api/issues/%s.json",issueId))
            .asString();
    JsonElement parsed = new JsonParser().parse(json);

    return parsed.getAsJsonObject().get("issues")
            .getAsJsonArray().get(0)
            .getAsJsonObject().get("state").getAsInt();


  }
}
