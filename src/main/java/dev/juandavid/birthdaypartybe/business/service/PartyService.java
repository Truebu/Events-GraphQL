package dev.juandavid.birthdaypartybe.business.service;

import dev.juandavid.birthdaypartybe.model.dto.MessageDto;
import dev.juandavid.birthdaypartybe.model.dto.PartyDto;
import dev.juandavid.birthdaypartybe.model.entities.Party;

import java.util.List;

public interface PartyService {

    MessageDto newParty(Party party);

    List<PartyDto> findAll();

    PartyDto findByIdDto(Long id);

    Party findById(Long id);

    MessageDto editParty(Party party);

    MessageDto deleteById(Long id);

    void calculateAcumulated(Party party);
}
