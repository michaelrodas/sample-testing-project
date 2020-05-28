package com.nl.icwdirectory.gateway.mongodb.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "businesses")
@SuppressFBWarnings
public class BusinessDocument {

    @Id
    private String id;
    @Field(name = "business_name")
    private String name;
    @Field(name = "owner_first_name")
    private String ownerFirstName;
    @Field(name = "owner_last_name")
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
