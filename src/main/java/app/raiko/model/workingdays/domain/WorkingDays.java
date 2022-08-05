package app.raiko.model.workingdays.domain;

import app.raiko.model.shop.domain.Shop;
import app.raiko.model.workinghours.domain.WorkingHours;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "working_days")
public class WorkingDays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "persian_title")
    private String persianTitle;
    @Column(name = "english_title")
    private String englishTitle;
    @Column(name = "holiday")
    private Boolean isHoliday;
    @Column(name = "full_time")
    private Boolean isFullTime;
    @OneToMany(mappedBy = "workingDays")
    private List<WorkingHours> workingHours;
    @ManyToOne
    @JoinColumn(name = "shop")
    private Shop shop;
}
