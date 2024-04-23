package simple.restproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Project {
    private int id;
    private String title;
    private List<String> developerList;
}
