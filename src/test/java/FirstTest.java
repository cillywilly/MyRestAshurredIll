import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class FirstTest {

    private ValidatableResponse allUsers = null;

    ResponseSpecification respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .build();

    RequestSpecification requSpec = new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    public void GET_All() {
        /*RestAssured.responseSpecification = respSpec;
        allUsers  =*/RestAssured.when().get(Endpoints.GET_ALL.Endpoint).then().spec(respSpec).log().all();
    }

    @Test
    public void postEmploe() {
        User user = new User("BP",  "Alesha", "228", "Pitrov");

        RestAssured.given().spec(requSpec).when()
                .body(user)
                .post(Endpoints.GET_ALL.Endpoint)
                .then()
                .statusCode(200);
    }

    @Test
    public void badPostEmploe() {
        RestAssured.given().when()
                .body("[" +
                        "{" +
                        "department='1'" +
                        ", id='1'" +
                        ", name='1'" +
                        ", salary='1'" +
                        ", surName='1'" +
                        ", surName='1'" +
                        '}' + '\'' +
                        "]")
                .post(Endpoints.GET_ALL.Endpoint)
                .then()
                .statusCode(400);
    }

    @Test
    public void putEmploe() {
        User user = new User("BPaRR", "28", "Gosha", "6522", "Ivanov");

         RestAssured.given().spec(requSpec).when()
                 .body(user)
                 .put(Endpoints.GET_ALL.Endpoint)
                 .then()
                 .statusCode(200);
    }

    @Test
    public void badPutEmploe() {
        User user = new User("BPaRR", "10", "Gosha", "6522", "Ivanov");

         RestAssured.given().spec(requSpec).when()
                 .body(user)
                 .put(Endpoints.GET_ALL.Endpoint)
                 .then()
                 .statusCode(400);
    }

    @Test
    public void getCurrentEmploe() {
        User s = RestAssured.when().get(Endpoints.POST_NEW_EMPLOEER.Endpoint+"34")
                .then()
                .spec(respSpec)
                .log().all()
                .extract()
                .body().as(User.class);
        System.out.println(s);
    }

    @Test
    public void deleteCurrentEmploe() {
        RestAssured.when().delete(Endpoints.GET_ALL.Endpoint+"27").then().spec(respSpec).log().all();

//            ValidatableResponse s =RestAssured.when().delete(Endpoints.GET_ALL.Endpoint+"26")
//                    .then().assertThat().statusCode(200)
//                    .and().log().body();
//            System.out.println(s);
    }
}
