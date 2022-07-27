package app.raiko.model.Shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Shop {
    private Integer id;
    private String name;
    private String description;;
    private String postalAddress;
    private String locationAddress;
    private Integer creator;
    private Integer owner;
}
