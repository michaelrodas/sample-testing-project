package com.nl.icwdirectory.gateway.mongodb;

import com.nl.icwdirectory.gateway.mongodb.entity.BusinessDocument;
import com.nl.icwdirectory.gateway.BusinessGateway;
import com.nl.icwdirectory.domain.Business;
import com.nl.icwdirectory.gateway.mongodb.converter.BusinessDocumentToBusinessConverter;
import com.nl.icwdirectory.gateway.mongodb.converter.BusinessToBusinessDocumentConverter;
import com.nl.icwdirectory.gateway.mongodb.repository.BusinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BusinessGatewayMongoImpl implements BusinessGateway {

    private final BusinessRepository businessRepository;
    private final BusinessToBusinessDocumentConverter businessToBusinessDocumentConverter;
    private final BusinessDocumentToBusinessConverter businessDocumentToBusinessConverter;

    public BusinessGatewayMongoImpl(BusinessRepository businessRepository,
                                    BusinessToBusinessDocumentConverter businessToBusinessDocumentConverter,
                                    BusinessDocumentToBusinessConverter businessDocumentToBusinessConverter) {
        this.businessRepository = businessRepository;
        this.businessToBusinessDocumentConverter = businessToBusinessDocumentConverter;
        this.businessDocumentToBusinessConverter = businessDocumentToBusinessConverter;
    }

    @Override
    public Business create(final Business businessToBeCreated) {
        final BusinessDocument businessForCreation = businessToBusinessDocumentConverter.convert(businessToBeCreated);

        final BusinessDocument createdBusinessDocument = businessRepository.insert(businessForCreation);
        log.info("Business successfully created: {}", createdBusinessDocument);

        return businessDocumentToBusinessConverter.convert(createdBusinessDocument);
    }
}
