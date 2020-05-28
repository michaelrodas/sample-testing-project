package com.nl.icwdirectory.gateway.http.model;

import com.nl.icwdirectory.gateway.mongodb.entity.AddressDocument;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BusinessCreation {

    @NotNull
    private String name;
    @NotNull
    private String ownerFirstName;
    private String ownerLastName;
    private AddressDocument address;
    @NotNull
    private String email;
    private String website;
    @NotNull
    private String phone;
    private String logo;
    private List<String> images;
    private String description;
    private List<String> tags;

}
