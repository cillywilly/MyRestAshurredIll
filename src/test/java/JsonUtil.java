public class JsonUtil {
    private String user;
    public JsonUtil(String department, String id,String name,String salary,String surName) {

        this.user = "{\n" +
                "  \"department\": "+department+",\n" +
                "  \"id\": "+id+",\n" +
                "  \"name\": "+name+",\n" +
                "  \"salary\": "+salary+",\n" +
                "  \"surName\": "+surName+"\n" +
                "}";
//                 user.put("department",department);
//                 user.put("id",id);
//                 user.put("name",name);
//                 user.put("salary",salary);
//                 user.put("surName",surName);
    }

    public String getUer() {
        return this.user;
    }

}
