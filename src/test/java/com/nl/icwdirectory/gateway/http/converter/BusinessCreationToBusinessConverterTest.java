package com.nl.icwdirectory.gateway.http.converter;

import com.nl.icwdirectory.domain.Business;
import com.nl.icwdirectory.gateway.http.model.BusinessCreation;
import com.nl.icwdirectory.gateway.mongodb.entity.AddressDocument;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class BusinessCreationToBusinessConverterTest {

    private BusinessCreationToBusinessConverter businessCreationToBusinessConverter;

    @Before
    public void setupTest() {
        businessCreationToBusinessConverter = new BusinessCreationToBusinessConverter();
    }

    @Test
    public void shouldConvertBusinessCreationToBusiness() {
        BusinessCreation businessToConvert = BusinessCreation.builder()
                .name("Granny's clothing")
                .ownerFirstName("Satan")
                .ownerLastName("Lucifer")
                .address(AddressDocument.builder()
                        .city("Eindhoven").postCode("5618ZW").street("Bouteslaan 123")
                        .build())
                .email("klerengekste@gmail.com")
                .website("www.customclothing.nl")
                .phone("+316666666")
                .logo("aUrl")
                .images(Collections.singletonList("aUrl"))
                .description("The business purpose")
                .tags(List.of("clothing", "kleren"))
                .build();

        Business result = businessCreationToBusinessConverter.convert(businessToConvert);
        EqualsBuilder.reflectionEquals(businessToConvert, result);
    }
}
