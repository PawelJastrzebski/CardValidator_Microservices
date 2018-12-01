package com.jastrzab.SDA_CardIssuerFinder.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class WebError {
    private String message;
    private Instant time;

    public WebError(String message) {
        this.message = message;
        this.time = Instant.now();
    }
}
