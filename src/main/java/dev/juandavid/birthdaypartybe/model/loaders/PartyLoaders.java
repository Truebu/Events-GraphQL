package dev.juandavid.birthdaypartybe.model.loaders;

import dev.juandavid.birthdaypartybe.business.service.PartyService;
import dev.juandavid.birthdaypartybe.model.entities.Party;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class PartyLoaders implements CommandLineRunner {

    private final PartyService service;

    @Override
    public void run(String... args) throws Exception {

        Party party = new Party("Cumpleaños del admin",
                new Date(2023, 6, 20, 0, 0), 0);
        service.newParty(party);
    }
}
