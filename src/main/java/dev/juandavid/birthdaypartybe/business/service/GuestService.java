package dev.juandavid.birthdaypartybe.business.service;

import dev.juandavid.birthdaypartybe.model.entities.Guest;

public interface GuestService {

    Guest newGuest(Guest guest);
    Guest getGuestById (Long id);
    Guest editGuest(Guest guest);
    void deleteGuestById(Long id);
}
