package dev.juandavid.birthdaypartybe.business.service;

import dev.juandavid.birthdaypartybe.model.entities.Guest;
import dev.juandavid.birthdaypartybe.model.repositories.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestRepository repository;

    @Override
    public Guest newGuest(Guest guest) {

        return repository.save(guest);
    }

    @Override
    public Guest getGuestById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Guest editGuest(Guest guest) {
        Guest newGuest = repository.findById(guest.getId()).get();
        newGuest.setName(guest.getName());
        newGuest.setGift(guest.getGift());
        newGuest.setParticipationStatus(guest.getParticipationStatus());
        return repository.save(newGuest);
    }

    @Override
    public void deleteGuestById(Long id) {

        repository.deleteById(id);
    }
}
