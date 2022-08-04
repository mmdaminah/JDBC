package app.raiko.model.Shop.domain;

import app.raiko.model.admin.domain.Admin;
import app.raiko.model.businessOwner.domain.BusinessOwner;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;;
    @Column
    private String postalAddress;
    @Column
    private String locationAddress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator")
    private Admin creator;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private BusinessOwner owner;
}
