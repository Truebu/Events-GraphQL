package dev.juandavid.birthdaypartybe.business.service.graphQL.datafetcher;

import dev.juandavid.birthdaypartybe.business.service.PartyService;
import dev.juandavid.birthdaypartybe.model.entities.Party;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PartyByIdDataFetcher implements DataFetcher<Party> {

    private final PartyService service;

    @Override
    public Party get(DataFetchingEnvironment dataFetchingEnvironment) {
        return service.findById(Long.parseLong(dataFetchingEnvironment.getArgument("id")));
    }
}
