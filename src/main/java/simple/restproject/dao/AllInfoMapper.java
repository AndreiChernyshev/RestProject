package simple.restproject.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import simple.restproject.model.PhoneType;

@Data
@NoArgsConstructor
public class AllInfoMapper {
    private int developerId;
    private String developerName;
    private int developerAge;
    private String developerEducation;
    private int projectId;
    private String projectTitle;
    private int phoneID;
    private PhoneType phoneType;
    private String phoneNumber;



}
