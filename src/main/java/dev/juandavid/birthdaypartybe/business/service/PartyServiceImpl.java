package dev.juandavid.birthdaypartybe.business.service;

import dev.juandavid.birthdaypartybe.model.dto.MessageDto;
import dev.juandavid.birthdaypartybe.model.dto.PartyDto;
import dev.juandavid.birthdaypartybe.model.entities.Guest;
import dev.juandavid.birthdaypartybe.model.entities.Party;
import dev.juandavid.birthdaypartybe.model.repositories.PartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;

    @Override
    public void calculateAcumulated(Party party) {
        int newAcumulate = 0 ;
        for (Guest guest: party.getGuests()) {
            newAcumulate =+ guest.getGift();
        }
        party.setAccumulated(newAcumulate);
        partyRepository.save(party);
    }

    @Override
    public List<PartyDto> findAll() {
        List<Party> parties = partyRepository.findAll();
        List<PartyDto> partyDtos = new ArrayList<>();
        for (Party party:parties) {
            partyDtos.add(new PartyDto(party));
        }
        return partyDtos;
    }

    @Override
    public PartyDto findByIdDto(Long id) {
        return new PartyDto(partyRepository.findById(id).get());
    }

    public Party findById(Long id) {
        return partyRepository.findById(id).get();
    }

    @Override
    public MessageDto editParty(Party party) {
        Party naewParty = findById(party.getId());
        naewParty.setDate(party.getDate());
        naewParty.setDesciption(party.getDesciption());
        naewParty.setEvent(party.getEvent());
        partyRepository.save(naewParty);
        return new MessageDto("Fiesta editada");
    }

    @Override
    public MessageDto deleteById(Long id) {
        partyRepository.deleteById(id);
        return new MessageDto("Fiesta eliminada");
    }

    @Override
    public MessageDto newParty(Party party) {
        partyRepository.save(party);
        return new MessageDto("Fiesta creada");
    }
}
