import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void GET_All() {
        System.out.println(Endpoints.GET_ALL.getEndpoint());
        RestAssured.when().get(Endpoints.GET_ALL.getEndpoint())
                .then().assertThat().statusCode(200)
        .and().log();
    }
}
