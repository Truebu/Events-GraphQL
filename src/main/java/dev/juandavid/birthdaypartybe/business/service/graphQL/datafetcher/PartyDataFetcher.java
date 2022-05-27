package dev.juandavid.birthdaypartybe.business.service.graphQL.datafetcher;

import dev.juandavid.birthdaypartybe.business.service.PartyService;
import dev.juandavid.birthdaypartybe.model.entities.Party;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class PartyDataFetcher implements DataFetcher<List<Party>> {

    private final PartyService service;

    @Override
    public List<Party> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return service.findAll();
    }
}
