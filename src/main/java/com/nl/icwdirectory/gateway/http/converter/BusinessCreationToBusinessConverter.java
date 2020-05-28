package com.nl.icwdirectory.gateway.http.converter;


import com.nl.icwdirectory.domain.Business;
import com.nl.icwdirectory.gateway.http.model.BusinessCreation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BusinessCreationToBusinessConverter implements Converter<BusinessCreation, Business> {

    @Override
    public Business convert(final BusinessCreation source) {
        return Business.builder()
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
