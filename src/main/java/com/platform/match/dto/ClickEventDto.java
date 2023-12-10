package com.platform.match.dto;

import com.platform.match.domain.ClickEvent;
import com.platform.match.domain.ClientVisitor;
import com.platform.match.domain.constant.ClickType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link ClickEvent}
 */
public record ClickEventDto(
        Long id,
        Long clientVisitorId,
        ClickType clickType,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {
    public static ClickEventDto of(Long id, Long clientVisitorId, ClickType clickType, LocalDateTime createdAt, LocalDateTime modifiedAt){
        return new ClickEventDto(id, clientVisitorId, clickType, createdAt, modifiedAt);
    }
    public static ClickEventDto of(Long clientVisitorId, ClickType clickType){
        return new ClickEventDto(null,clientVisitorId, clickType, null, null);
    }
    public static ClickEventDto from(ClickEvent entity){
        return new ClickEventDto(
                entity.getId(),
                entity.getClientVisitor().getId(),
                entity.getClickType(),
                entity.getCreatedAt(),
                entity.getModifiedAt()
        );
    }

    public ClickEvent toEntity(ClientVisitor entity){
        return ClickEvent.of(
                entity,
                clickType
        );
    }
}