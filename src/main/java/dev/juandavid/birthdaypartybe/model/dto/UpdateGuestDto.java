package dev.juandavid.birthdaypartybe.model.dto;

import dev.juandavid.birthdaypartybe.model.enums.ParticipationStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGuestDto {
    private Long id;
    private String name;
    private int gift;
    private ParticipationStatus participation_status;
}
