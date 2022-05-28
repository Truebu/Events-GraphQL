package dev.juandavid.birthdaypartybe.model.dto;

import dev.juandavid.birthdaypartybe.model.enums.ParticipationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewGuestDto {

    private String name;
    private int gift;
    private ParticipationStatus participationStatus;
    private Long partyId;
}
