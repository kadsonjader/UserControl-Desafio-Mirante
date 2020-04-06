package com.mirante.api.service.mapper;

import com.mirante.api.model.Email;
import com.mirante.api.service.dto.EmailDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper extends EntityMapper<EmailDTO, Email> {

    Email toEntity(EmailDTO dto);

    EmailDTO toDto(Email entity);

    default Email fromId(Long id) {
        if (id == null) {
            return null;
        }
        Email email = new Email();
        email.setId(id);
        return email;
    }
}
