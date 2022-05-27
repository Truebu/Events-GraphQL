package dev.juandavid.birthdaypartybe.business.service.graphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import dev.juandavid.birthdaypartybe.business.service.GuestService;
import dev.juandavid.birthdaypartybe.business.service.PartyService;
import dev.juandavid.birthdaypartybe.model.dto.CreateGuestDto;
import dev.juandavid.birthdaypartybe.model.dto.CreatePartyDto;
import dev.juandavid.birthdaypartybe.model.dto.UpdateGuestDto;
import dev.juandavid.birthdaypartybe.model.dto.UpdatePartyDto;
import dev.juandavid.birthdaypartybe.model.entities.Guest;
import dev.juandavid.birthdaypartybe.model.entities.Party;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {

    private final GuestService guestService;
    private final PartyService partyService;

    public Party createParty(CreatePartyDto input){
        return partyService.newParty(new Party(input));
    }

    public Party updateParty(UpdatePartyDto input){
        return partyService.editParty(new Party(input));

    }

    public Long deleteParty(Long id){
        partyService.deleteById(id);
        return id;
    }

    public Guest createGuest(CreateGuestDto input){
        return guestService.newGuest(new Guest(input));
    }

    public Guest updateGuest(UpdateGuestDto input){
        return guestService.editGuest(new Guest(input));
    }

    public void deleteGuest(Long id){
        guestService.deleteGuestById(id);
    }

}
