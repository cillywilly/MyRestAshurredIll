import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String department;
    private String id;
    private String name;
    private String salary;
    private String surName;

    User(String department, String name, String salary, String surName) {
        this.department = department;
        this.name = name;
        this.salary = salary;
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "[" +
                "{" +
                "department='" + department + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", surName='" + surName + '\'' +
                '}' + '\'' +
                "]";
    }
}
