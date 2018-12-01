package com.jastrzab.SDA_CardValidator_App.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisResponse {
    String issuer;
    boolean isValidationPassed;
}
