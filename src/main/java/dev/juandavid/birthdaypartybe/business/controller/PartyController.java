package dev.juandavid.birthdaypartybe.business.controller;

import dev.juandavid.birthdaypartybe.business.service.PartyService;
import dev.juandavid.birthdaypartybe.model.dto.MessageDto;
import dev.juandavid.birthdaypartybe.model.dto.PartyDto;
import dev.juandavid.birthdaypartybe.model.entities.Party;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/graph/v1/party")
public class PartyController {

    private final PartyService partyService;

    @PostMapping("/newParty")
    public ResponseEntity<MessageDto> newParty(@RequestBody Party party){
        return new ResponseEntity<>(partyService.newParty(party), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PartyDto>> getAllParties(){
        return new ResponseEntity<>(partyService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartyDto> getPartyById(@PathVariable("id") Long id){
        return new ResponseEntity<>(partyService.findByIdDto(id),HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<MessageDto> editParty(@RequestBody Party party){
        return new ResponseEntity<>(partyService.editParty(party), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<MessageDto> deletePartyById(@PathVariable("id")  Long id){
        return new ResponseEntity<>(partyService.deleteById(id),HttpStatus.OK);
    }
}
