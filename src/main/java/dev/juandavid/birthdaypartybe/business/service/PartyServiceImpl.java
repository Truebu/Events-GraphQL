package dev.juandavid.birthdaypartybe.business.service;

import dev.juandavid.birthdaypartybe.model.entities.Party;
import dev.juandavid.birthdaypartybe.model.repositories.PartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;

    @Override
    public List<Party> findAll() {
        return partyRepository.findAll();
    }

    @Override
    public Party findById(Long id) {
        return partyRepository.findById(id).get();
    }

    @Override
    public Party editParty(Party party) {
        Party naewParty = findById(party.getId());
        naewParty.setDate(party.getDate());
        naewParty.setDesciption(party.getDesciption());
        naewParty.setEvent(party.getEvent());
        return partyRepository.save(naewParty);
    }

    @Override
    public void deleteById(Long id) {
        partyRepository.deleteById(id);
    }

    @Override
    public Party newParty(Party party) {
        return partyRepository.save(party);
    }
}
