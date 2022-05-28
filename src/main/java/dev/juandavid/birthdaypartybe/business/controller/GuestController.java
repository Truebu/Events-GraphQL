package dev.juandavid.birthdaypartybe.business.controller;

import dev.juandavid.birthdaypartybe.business.service.GuestService;
import dev.juandavid.birthdaypartybe.model.dto.GuestDto;
import dev.juandavid.birthdaypartybe.model.dto.MessageDto;
import dev.juandavid.birthdaypartybe.model.dto.NewGuestDto;
import dev.juandavid.birthdaypartybe.model.entities.Guest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/graph/v1/guest")
public class GuestController {

    private final GuestService guestService;

    @PostMapping("/newGuest")
    public ResponseEntity<MessageDto> newGuest (@RequestBody NewGuestDto newGuestDto){
        return new ResponseEntity<>(guestService.newGuest(newGuestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<GuestDto> getGuestById (@PathVariable("id") Long id){
        return new ResponseEntity<>(guestService.getGuestById(id),HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<MessageDto> editGuest(@RequestBody Guest guest){
        return new ResponseEntity<>(guestService.editGuest(guest),HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<MessageDto> deleteGuest(@PathVariable("id") Long id){
        return new ResponseEntity<>( guestService.deleteGuestById(id),HttpStatus.OK);
    }

}
