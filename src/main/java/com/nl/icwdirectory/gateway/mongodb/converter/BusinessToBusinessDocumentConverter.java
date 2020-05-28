package com.nl.icwdirectory.gateway.mongodb.converter;

import com.nl.icwdirectory.gateway.mongodb.entity.BusinessDocument;
import com.nl.icwdirectory.domain.Business;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BusinessToBusinessDocumentConverter implements Converter<Business, BusinessDocument> {

    @Override
    public BusinessDocument convert(final Business source) {
        return BusinessDocument.builder()
                .id(source.getId())
                .name(source.getName())
                .ownerFirstName(source.getOwnerFirstName())
                .ownerLastName(source.getOwnerLastName())
                .address(source.getAddress())
                .email(source.getEmail())
                .website(source.getWebsite())
                .phone(source.getPhone())
                .logo(source.getLogo())
                .images(source.getImages())
                .description(source.getDescription())
                .tags(source.getTags())
                .build();
    }
}