package dev.juandavid.birthdaypartybe.business.controller;

import dev.juandavid.birthdaypartybe.business.service.graphQL.GraphQLService;
import graphql.ExecutionResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/graph/v1/")
public class GustController {

    private final GraphQLService service;

    @PostMapping
    public ResponseEntity<Object> getParty (@RequestBody String query){

        ExecutionResult result = service.getGraphQL().execute(query);

        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }
}
