package dev.juandavid.birthdaypartybe.business.service.graphQL.datafetcher;

import dev.juandavid.birthdaypartybe.business.service.GuestService;
import dev.juandavid.birthdaypartybe.model.entities.Guest;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GuestDataFetcher implements DataFetcher<Guest> {

    private final GuestService service;

    @Override
    public Guest get(DataFetchingEnvironment dataFetchingEnvironment) {

        return service.getGuestById(Long.parseLong(dataFetchingEnvironment.getArgument("id")));
    }
}
