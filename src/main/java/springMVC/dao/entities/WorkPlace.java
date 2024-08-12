package springMVC.dao.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="work_place")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkPlace {
	
	@Id
    private Integer id;

    @Column(name = "allowed_consecutive_days")
    private Integer allowedConsecutiveDays;

    @Column(name = "presence_percentage")
    private Double presencePercentage;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "type")
    private String type;

    @Column(name = "user_username", nullable = false)
    private String userUsername;

    @Column(name = "attendance_delay_tolerance")
    private Integer attendanceDelayTolerance;
}
