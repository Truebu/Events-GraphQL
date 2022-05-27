package dev.juandavid.birthdaypartybe.business.service.graphQL;

import dev.juandavid.birthdaypartybe.business.service.graphQL.datafetcher.GuestDataFetcher;
import dev.juandavid.birthdaypartybe.business.service.graphQL.datafetcher.PartyByIdDataFetcher;
import dev.juandavid.birthdaypartybe.business.service.graphQL.datafetcher.PartyDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;

@Service
@AllArgsConstructor
public class GraphQLService {

    @Value("classpath:gust.graphqls")
    Resource resource;

    private GraphQL graphQL;

    private PartyDataFetcher partyDataFetcher;
    private PartyByIdDataFetcher partyByIdDataFetcher;
    private GuestDataFetcher guestDataFetcher;

    @PostConstruct
    private void loadSchema() throws Exception{

        File schemaFile = resource.getFile();

        TypeDefinitionRegistry definitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(definitionRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typewiring -> typewiring
                        .dataFetcher("allParty", partyDataFetcher)
                        .dataFetcher("guest", guestDataFetcher)
                        .dataFetcher("party", partyByIdDataFetcher)
                        )
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
