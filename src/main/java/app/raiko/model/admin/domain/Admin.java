package app.raiko.model.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Admin {
  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private String phoneNumber;
  private Admin creator;
  private Boolean superAdmin;
}
