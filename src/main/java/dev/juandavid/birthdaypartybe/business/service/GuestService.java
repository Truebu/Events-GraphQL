package dev.juandavid.birthdaypartybe.business.service;

import dev.juandavid.birthdaypartybe.model.dto.GuestDto;
import dev.juandavid.birthdaypartybe.model.dto.MessageDto;
import dev.juandavid.birthdaypartybe.model.dto.NewGuestDto;
import dev.juandavid.birthdaypartybe.model.entities.Guest;

public interface GuestService {

    MessageDto newGuest(NewGuestDto guest);
    GuestDto getGuestById (Long id);
    MessageDto editGuest(Guest guest);
    MessageDto deleteGuestById(Long id);
}
