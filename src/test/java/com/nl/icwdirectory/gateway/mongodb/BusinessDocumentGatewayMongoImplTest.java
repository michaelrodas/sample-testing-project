package com.nl.icwdirectory.gateway.mongodb;

import com.nl.icwdirectory.domain.Business;
import com.nl.icwdirectory.gateway.mongodb.entity.AddressDocument;
import com.nl.icwdirectory.gateway.mongodb.entity.BusinessDocument;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@DataMongoTest
@ComponentScan(basePackageClasses = BusinessGatewayMongoImpl.class)
public class BusinessDocumentGatewayMongoImplTest {

    @Autowired
    private BusinessGatewayMongoImpl businessGatewayMongoImpl;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void setUp() {
        // Clean all data before each test
        mongoTemplate.findAllAndRemove(new Query(), BusinessDocument.class);
    }

    @Test
    public void shouldCreateANewBusiness() {
        Business sampleTestingBusinessDocument = Business.builder()
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
        Business result = businessGatewayMongoImpl.create(sampleTestingBusinessDocument);

        then(result).isEqualToIgnoringGivenFields(sampleTestingBusinessDocument, "id");
    }
}
