package app.raiko.model.businessOwner.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class BusinessOwner {
    private Integer id;
    private String firstName;
    private String lastName;;
    private String nationalCode;
    private String phoneNumber;
    private Integer creator;
}
