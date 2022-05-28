package dev.juandavid.birthdaypartybe.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

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

    @Column(name = "desciption", nullable = true, columnDefinition = "TEXT")
    private String desciption;

    @Column(name = "date",nullable = false,columnDefinition = "DATE")
    private Date date;

    @Column(name = "accumulated", nullable = true, columnDefinition = "INT")
    private int accumulated;

    @OneToMany(mappedBy = "party")
    private List<Guest> guests = new ArrayList<>();

    public Party(String event, Date date, int accumulated) {
        this.event = event;
        this.date = date;
        this.accumulated = accumulated;
    }

}
