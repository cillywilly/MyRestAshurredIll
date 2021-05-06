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
        User user = new User("BP", "3", "Alesha", "1148", "Pitrov");

//переписывает типа а должен возвращать ошибку наврено тип такой уже существует
        //и по идее должен возвращать 201 (среатед)

        RequestSpecification request= RestAssured.given();
        request.header("Content-type", "application/json");
        request.body(JSON.toJSONString(user));
        Response response = request.post(Endpoints.POST_NEW_EMPLOEER.Endpoint);
        System.out.println(response);
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void putEmploe() {
        User user = new User("BP", "4", "Alesha", "1148", "Pitrov");

        RequestSpecification request= RestAssured.given();
        request.header("Content-type", "application/json");
        request.body(JSON.toJSONString(user));
        Response response = request.post(Endpoints.POST_NEW_EMPLOEER.Endpoint);
        response.body().prettyPrint();
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void getCurrentEmploe() {
        System.out.println(Endpoints.GET_ALL.getEndpoint());
        ValidatableResponse s =RestAssured.when().get(Endpoints.GET_ALL.getEndpoint()+"1")
                .then().assertThat().statusCode(200)
                .and().log().body();
        System.out.println(s);
    }

    @Test
    public void deleteCurrentEmploe() {
        System.out.println(Endpoints.GET_ALL.getEndpoint());
        ValidatableResponse s =RestAssured.when().delete(Endpoints.GET_ALL.getEndpoint()+"3")
                .then().assertThat().statusCode(200)
                .and().log().body();
        System.out.println(s);
    }
}
