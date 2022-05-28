package dev.juandavid.birthdaypartybe.model.entities;

import dev.juandavid.birthdaypartybe.model.dto.NewGuestDto;
import dev.juandavid.birthdaypartybe.model.enums.ParticipationStatus;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "guest")
@Entity(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;

    @Column(name = "gift",nullable = false)
    private int gift;

    @Enumerated(EnumType.STRING)
    private ParticipationStatus participationStatus;

    @ManyToOne
    @JoinColumn(name = "id_party")
    private Party party;


    public Guest(NewGuestDto newGuestDto) {
        this.name = newGuestDto.getName();
        this.gift = newGuestDto.getGift();
        this.participationStatus = newGuestDto.getParticipationStatus();
    }
}
