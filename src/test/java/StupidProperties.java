import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StupidProperties {
    private final String value;
    public StupidProperties(String configFile, String propsKey) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(configFile)) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Нет файла : "+ configFile);
            e.printStackTrace();
        }
        value = properties.getProperty(propsKey);
    }

    public String getValue() {
        return value;
    }
}
