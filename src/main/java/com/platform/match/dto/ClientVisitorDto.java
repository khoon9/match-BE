package com.platform.match.dto;

import com.platform.match.domain.ClientVisitor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link ClientVisitor}
 */
public record ClientVisitorDto(
        Long id,
        UUID uuid,
        int visitCount,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {
    public static ClientVisitorDto of(Long id, UUID uuid, int visitCount, LocalDateTime createdAt, LocalDateTime modifiedAt){
        return new ClientVisitorDto(id, uuid, visitCount, createdAt, modifiedAt);
    }
    public static ClientVisitorDto of(UUID uuid){
        return new ClientVisitorDto(null, uuid, 0, null, null);
    }

    public static ClientVisitorDto of(UUID uuid, int visitCount){
        return new ClientVisitorDto(null, uuid, visitCount, null, null);
    }

    public static ClientVisitorDto from(ClientVisitor entity){
        return new ClientVisitorDto(entity.getId(),entity.getUuid(), entity.getVisitCount(), entity.getCreatedAt(), entity.getModifiedAt());
    }
    // 작업중
    public ClientVisitor toEntity(){
        return ClientVisitor.of(uuid, visitCount);
    }
}