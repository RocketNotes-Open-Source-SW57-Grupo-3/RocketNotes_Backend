package com.fivestars.rocketnotes.Maintenance.domain.model.agreggates;


import com.fivestars.rocketnotes.Maintenance.domain.model.valueobjects.EquipmentStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String name;
    @Column(nullable = true)
    private int quantity;
    @Column(nullable = true)
    private int budget;
    @Column(nullable = true)
    private String creation;
    @Column(nullable = true)
    private String period;
    @Column(nullable = true)
    private EquipmentStatus status;

    public Equipment(){
        this.status = EquipmentStatus.PROGRESS;
    }

    public Equipment(String name, int quantity, int budget, String creation, String period) {
        this();
        this.name = name;
        this.quantity = quantity;
        this.budget = budget;
        this.creation = creation;
        this.period = period;


    }

    public String getStatus(){
        if(status.name().equalsIgnoreCase("progress")){
            return "IN PROGRESS";
        }
        else{
            return "FINALIZED";
        }
    }


}
