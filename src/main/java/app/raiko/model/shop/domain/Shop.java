package app.raiko.model.shop.domain;

import app.raiko.model.admin.domain.Admin;
import app.raiko.model.businessOwner.domain.BusinessOwner;
import app.raiko.model.category.domain.Category;
import app.raiko.model.workingdays.domain.WorkingDays;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "category_shop",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    @OneToMany(mappedBy = "shop")
    private List<WorkingDays> workingDays;
}
