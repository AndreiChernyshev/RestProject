package simple.restproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class PhoneNumber {
    private int id;
    private int ownerID;
    private  PhoneType phoneType;
    private String phoneNumber;

}
