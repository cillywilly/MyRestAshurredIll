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

    @Override
    public String toString() {
        return "User{" +
                "department='" + department + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
