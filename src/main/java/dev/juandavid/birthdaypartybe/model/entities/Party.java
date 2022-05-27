package dev.juandavid.birthdaypartybe.model.entities;

import dev.juandavid.birthdaypartybe.model.dto.CreatePartyDto;
import dev.juandavid.birthdaypartybe.model.dto.UpdatePartyDto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "party")
@Entity(name = "party")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "event",nullable = false,columnDefinition = "TEXT")
    private String event;

    @Column(name = "desciption", nullable = false, columnDefinition = "TEXT")
    private String desciption;

    @Column(name = "date",nullable = false,columnDefinition = "DATE")
    private Date date;

    @Column(name = "accumulated", nullable = true, columnDefinition = "INT")
    private int accumulated;

    @OneToMany(mappedBy = "party")
    private Set<Guest> guests = new HashSet<>();

    public Party(String event, Date date, int accumulated) {
        this.event = event;
        this.date = date;
        this.accumulated = accumulated;
    }

    public Party(CreatePartyDto dto) {
        this.event = dto.getEvent();
        this.desciption = dto.getDescription();
        this.date = dto.getDate();
    }

    public Party(UpdatePartyDto dto) {
        this.id = dto.getId();
        this.event = dto.getEvent();
        this.desciption = dto.getDescription();
        this.date = dto.getDate();
    }
}
