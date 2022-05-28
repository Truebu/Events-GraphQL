package dev.juandavid.birthdaypartybe.model.dto;

import dev.juandavid.birthdaypartybe.model.entities.Guest;
import dev.juandavid.birthdaypartybe.model.enums.ParticipationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {

    private Long id;
    private String name;
    private int gift;
    private ParticipationStatus participationStatus;

    public GuestDto(Guest guest) {
        this.id = guest.getId();
        this.name = guest.getName();
        this.gift = guest.getGift();
        this.participationStatus = guest.getParticipationStatus();
    }
}
