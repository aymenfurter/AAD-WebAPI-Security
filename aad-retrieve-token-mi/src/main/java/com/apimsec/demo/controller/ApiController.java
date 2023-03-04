package com.apimsec.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.core.credential.AccessToken;
import com.azure.core.credential.TokenRequestContext;
import com.azure.identity.ManagedIdentityCredential;
import com.azure.identity.ManagedIdentityCredentialBuilder;

import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/pets")
    public ResponseEntity<List<String>> getPets() {
        ManagedIdentityCredential managedIdentityCredential = new ManagedIdentityCredentialBuilder()
        .clientId("c5e2efd1-d9ed-422f-96ec-620f884c8e05")
        .build();

        Mono<AccessToken> token = managedIdentityCredential.getToken(new TokenRequestContext().addScopes("api://5b42ca13-cd2c-42d6-8d03-4a8349fcc07a/.default"));

        String accessToken = token.block().getToken();

        List<String> tokenList = new ArrayList<>();
        tokenList.add(accessToken);

        // TODO: Use the access token to call the downstream API
        
        return ResponseEntity.ok(tokenList);
    }

}