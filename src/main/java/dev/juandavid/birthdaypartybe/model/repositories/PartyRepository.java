package dev.juandavid.birthdaypartybe.model.repositories;

import dev.juandavid.birthdaypartybe.model.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
