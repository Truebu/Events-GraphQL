package dev.juandavid.birthdaypartybe.business.service;

import dev.juandavid.birthdaypartybe.model.entities.Party;

import java.util.List;

public interface PartyService {

    Party newParty(Party party);

    List<Party> findAll();

    Party findById(Long id);

    Party editParty(Party party);

    void deleteById(Long id);
}
