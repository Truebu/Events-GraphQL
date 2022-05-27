package dev.juandavid.birthdaypartybe.model.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePartyDto {

    private String event;
    private Date date;
    private String description;
}
