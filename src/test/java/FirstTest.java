import com.alibaba.fastjson.JSON;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void GET_All() {
        System.out.println(Endpoints.GET_ALL.getEndpoint());
        ValidatableResponse s =RestAssured.when().get(Endpoints.GET_ALL.getEndpoint())
                .then().assertThat().statusCode(200)
        .and().log().body();
        System.out.println(s);
    }

    @Test
    public void postEmploe() {
        User user = new User("BP",  "Alesha", "1148", "Pitrov");

        RequestSpecification request= RestAssured.given();
        request.header("Content-type", "application/json");
        request.body(JSON.toJSONString(user))
                .post(Endpoints.POST_NEW_EMPLOEER.Endpoint)
                .then()
                .statusCode(200)
                .and().log();
    }

    @Test
    public void putEmploe() {
        User user = new User("BPaRR", "26", "Alesha", "1148", "Pitrov");

        RequestSpecification request= RestAssured.given();
        request.header("Content-type", "application/json");
        request.body(JSON.toJSONString(user));
        Response response = request.put(Endpoints.POST_NEW_EMPLOEER.Endpoint);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void getCurrentEmploe() {
        System.out.println(Endpoints.GET_ALL.getEndpoint());
        ValidatableResponse s =RestAssured.when().get(Endpoints.GET_ALL.getEndpoint()+"26")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void deleteCurrentEmploe() {
        System.out.println(Endpoints.GET_ALL.getEndpoint());
            ValidatableResponse s =RestAssured.when().delete(Endpoints.GET_ALL.getEndpoint()+"26")
                    .then().assertThat().statusCode(200)
                    .and().log().body();
            System.out.println(s);
    }
}
