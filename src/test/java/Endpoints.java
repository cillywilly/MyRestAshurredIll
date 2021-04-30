public enum Endpoints {
    GET_ALL("/api/employees");

    public final String Endpoint;

    Endpoints(String s) {
        this.Endpoint =
                new StupidProperties("src/test/resources/app655.properties", "circuit")
                        .getValue() + s+"/";
    }

    public String getEndpoint() {
        return Endpoint;
    }
}
