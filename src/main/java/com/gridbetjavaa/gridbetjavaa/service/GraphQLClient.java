package com.gridbetjavaa.gridbetjavaa.service;

import com.netflix.graphql.dgs.client.MonoGraphQLClient;
import com.netflix.graphql.dgs.client.WebClientGraphQLClient;
import org.springframework.web.reactive.function.client.WebClient;

public class GraphQLClient {
    private WebClientGraphQLClient client;

    public GraphQLClient(){
        WebClient webClient = WebClient.create("https://api-op.grid.gg/central-data/graphql");
        WebClientGraphQLClient newclient = MonoGraphQLClient.createWithWebClient(webClient);
        this.client = newclient;
    }

}
