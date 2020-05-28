package com.nl.icwdirectory.gateway.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddressDocument {

    private String street;
    private String postCode;
    private String city;

}
