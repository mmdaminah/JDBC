package app.raiko.model.workinghours.domain;

import app.raiko.model.workingdays.domain.WorkingDays;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "working_hours")
public class WorkingHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_time",length = 5)
    private String startTime;
    @Column(name = "end_time",length = 5)
    private String endTime;
    @ManyToOne
    @JoinColumn(name = "working_day")
    private WorkingDays workingDays;
}
