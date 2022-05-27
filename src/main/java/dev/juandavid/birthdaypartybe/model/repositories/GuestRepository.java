package dev.juandavid.birthdaypartybe.model.repositories;

import dev.juandavid.birthdaypartybe.model.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
