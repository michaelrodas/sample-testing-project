package com.nl.icwdirectory.gateway.mongodb.converter;

import com.nl.icwdirectory.domain.Business;
import com.nl.icwdirectory.gateway.mongodb.entity.AddressDocument;
import com.nl.icwdirectory.gateway.mongodb.entity.BusinessDocument;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class BusinessToBusinessDocumentConverterTest {

    private BusinessToBusinessDocumentConverter businessDocumentToBusinessConverter;

    @Before
    public void setupTest() {
        businessDocumentToBusinessConverter = new BusinessToBusinessDocumentConverter();
    }

    @Test
    public void shouldConvertBusinessToBusinessDocument() {
        Business businessToConvert = Business.builder()
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

        BusinessDocument convertedBusinessDocument = businessDocumentToBusinessConverter.convert(businessToConvert);

        then(convertedBusinessDocument).isEqualToComparingFieldByField(businessToConvert);
    }
}