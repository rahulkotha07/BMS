package dev.rahul.BMS.model;

import dev.rahul.BMS.model.constants.ShowStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "`show`")
public class Show extends BaseModel{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    private Auditorium auditorium;
    @ManyToOne
    private Movie movie;
    private String language;
    @Enumerated(EnumType.STRING)
    private ShowStatus showStatus;
    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;
}