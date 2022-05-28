package dev.juandavid.birthdaypartybe.model.dto;

import dev.juandavid.birthdaypartybe.model.entities.Guest;
import dev.juandavid.birthdaypartybe.model.entities.Party;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyDto {

    private Long id;
    private String event;
    private String desciption;
    private Date date;
    private int accumulated;
    private List<GuestDto> guestDtos = new ArrayList<>();

    public PartyDto(Party party) {
        this.id = party.getId();
        this.event = party.getEvent();
        this.desciption = party.getDesciption();
        this.date = party.getDate();
        this.accumulated = party.getAccumulated();
        List<GuestDto> guestDtos1 = new ArrayList<>();
        for (Guest guest:party.getGuests()) {
            guestDtos1.add(new GuestDto(guest));
        }
        this.guestDtos = guestDtos1;
    }
}
