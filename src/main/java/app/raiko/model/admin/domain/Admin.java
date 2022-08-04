package app.raiko.model.admin.domain;

import app.raiko.model.Shop.domain.Shop;
import app.raiko.model.businessOwner.domain.BusinessOwner;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "admin")
public class Admin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column
  private String username;
  @Column
  private String password;
  @Column
  private String phoneNumber;
  @Column
  private Boolean superAdmin;
  @OneToMany(mappedBy = "admin",fetch = FetchType.LAZY)
  private List<Admin> creator;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "creator")
  private Admin admin;
  @OneToMany(mappedBy = "creator",fetch = FetchType.LAZY)
  private List<BusinessOwner> businessOwners;
  @OneToMany(mappedBy = "creator",fetch = FetchType.LAZY)
  private List<Shop> shops;
}
