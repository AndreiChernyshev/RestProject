package simple.restproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Developer {
    private int id;
    private String name;
    private int age;
    private String education;
    private List<Project> projects;
    private List<PhoneNumber> phones;
    public Developer(int id, String name, int age, String education) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.education = education;
    }


}
