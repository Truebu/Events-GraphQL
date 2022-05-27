package dev.juandavid.birthdaypartybe.model.entities;

import dev.juandavid.birthdaypartybe.model.dto.CreateGuestDto;
import dev.juandavid.birthdaypartybe.model.dto.UpdateGuestDto;
import dev.juandavid.birthdaypartybe.model.enums.ParticipationStatus;
import lombok.*;
import org.jetbrains.annotations.NotNull;

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

    @NotNull
    @Enumerated(EnumType.STRING)
    private ParticipationStatus participationStatus;

    @ManyToOne
    @JoinColumn(name = "id_party")
    private Party party;

    public Guest(CreateGuestDto dto) {
        this.name = dto.getName();
        this.gift = dto.getGift();
        this.participationStatus = dto.getParticipation_status();
        Party party1 = new Party();
        party1.setId(dto.getPartyId());
        this.party = party1;
    }

    public Guest(UpdateGuestDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.gift = dto.getGift();
        this.participationStatus = dto.getParticipation_status();
    }

}
