package dev.juandavid.birthdaypartybe.model.dto;


import dev.juandavid.birthdaypartybe.model.enums.ParticipationStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGuestDto {
    private String name;
    private int gift;
    private ParticipationStatus participation_status;
    private Long partyId;
}
