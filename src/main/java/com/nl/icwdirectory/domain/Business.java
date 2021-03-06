package com.nl.icwdirectory.domain;

import com.nl.icwdirectory.gateway.mongodb.entity.AddressDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Business {

    private String id;
    private String name;
    private String ownerFirstName;
    private String ownerLastName;
    private AddressDocument address;
    private String email;
    private String website;
    private String phone;
    private String logo;
    private List<String> images;
    private String description;
    private List<String> tags;

}
