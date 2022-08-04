package app.raiko.model.businessOwner.domain;

import app.raiko.model.Shop.domain.Shop;
import app.raiko.model.admin.domain.Admin;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "business_owner")
public class BusinessOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;;
    @Column
    private String nationalCode;
    @Column
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "creator")
    private Admin creator;
    @OneToMany(mappedBy = "owner",fetch = FetchType.LAZY)
    private List<Shop> shops;
}
