package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class RestAssuredTests {

  @BeforeClass // это для авторизации RestAssured
  public void init(){

    RestAssured.authentication= RestAssured.basic("28accbe43ea112d9feb328d2c00b3eed", "");
  }

  @Test
  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues= getIssues();
    Issue newIssue= new Issue().withSubject("lyu tets Subj").withDescription("lyusdfghjg");
    Integer IssueId=createIssue(newIssue);
    /* в лекциях такая вот проверка , но поскольку возвращается за раз только 20 issue, а сейчас их там 800
    то такой варинт не подходит
    Set<Issue> newIssues= getIssues();
    oldIssues.add(newIssue.withId(IssueId));
    assertEquals(oldIssues,newIssues);
    */

  }

  private Set<Issue> getIssues() throws IOException {
   /* String json=getExecutor()
            .execute(Request.Get("http://demo.bugify.com/api/issues.json"))
            .returnContent()
            .asString();*/
    String json= RestAssured.get("http://demo.bugify.com/api/issues.json").toString(); // эта строка вместо той , что выше
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");

    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }

  /* //  таже операция теперь выполняется в init
  private Executor getExecutor() {
    return Executor.newInstance()
            .auth("28accbe43ea112d9feb328d2c00b3eed", "");// ключ отсюда копируется https://bugify.com/api из соотв. процедуры

  }*/

  private Integer createIssue(Issue newIssue) throws IOException {
    /*String json=getExecutor()
            .execute(Request.Post("http://demo.bugify.com/api/issues.json")
                    .bodyForm( new BasicNameValuePair("description",newIssue.getDescription()),
                              new BasicNameValuePair("subject",newIssue.getSubject())))
            .returnContent()
            .asString();
    */

    String json=RestAssured.given().
            parameter("subject",newIssue.getSubject()).
            parameter("description",newIssue.getDescription()).
            post("http://demo.bugify.com/api/issues.json")
            .asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt() ;
  }

}
