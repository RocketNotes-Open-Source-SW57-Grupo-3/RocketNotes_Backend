package com.fivestars.rocketnotes.Maintenance.domain.model.agreggates;

import com.fivestars.rocketnotes.Maintenance.domain.model.valueobjects.FacilitieStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Facilitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;
    @Column()
    private int budget;
    @Column()
    private String creation;
    @Column()
    private String Period;
    @Column()
    private FacilitieStatus status;

    public Facilitie() {
        this.status = FacilitieStatus.PROGRESS;
    }
    public Facilitie(String name, int budget, String creation, String period) {
        this();
        this.name = name;
        this.budget = budget;
        this.creation = creation;
        this.Period = period;
    }

    public String getStatus(){
        return status.name().toLowerCase();
    }
    public void finished(){this.status = FacilitieStatus.FINALIZED;}
}
