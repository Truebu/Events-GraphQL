package dev.juandavid.birthdaypartybe.business.service;

import dev.juandavid.birthdaypartybe.model.dto.GuestDto;
import dev.juandavid.birthdaypartybe.model.dto.MessageDto;
import dev.juandavid.birthdaypartybe.model.dto.NewGuestDto;
import dev.juandavid.birthdaypartybe.model.entities.Guest;
import dev.juandavid.birthdaypartybe.model.repositories.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestRepository repository;
    private final PartyService partyService;

    @Override
    public MessageDto newGuest(NewGuestDto newGuestDto) {
        Guest guest = new Guest(newGuestDto);
        guest.setParty(partyService.findById(newGuestDto.getPartyId()));
        repository.save(guest);
        partyService.calculateAcumulated(partyService.findById(newGuestDto.getPartyId()));
        return new MessageDto("Participante creado");
    }

    @Override
    public GuestDto getGuestById(Long id) {
        return new GuestDto(repository.findById(id).get());
    }

    @Override
    public MessageDto editGuest(Guest guest) {
        Guest newGuest = repository.findById(guest.getId()).get();
        newGuest.setName(guest.getName());
        newGuest.setParticipationStatus(guest.getParticipationStatus());
        repository.save(newGuest);
        partyService.calculateAcumulated(partyService.findById(newGuest.getParty().getId()));
        return new MessageDto("Participante editado");
    }

    @Override
    public MessageDto deleteGuestById(Long id) {
        repository.deleteById(id);
        return new MessageDto("Participante eliminado");
    }
}
