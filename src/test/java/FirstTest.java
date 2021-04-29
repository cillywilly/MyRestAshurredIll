import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void Post() {
        System.out.println(Endpoints.GET_ALL.getEndpoint());
    }
}
