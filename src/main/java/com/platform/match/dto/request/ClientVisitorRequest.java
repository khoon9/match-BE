package com.platform.match.dto.request;

import com.platform.match.domain.ClientVisitor;
import com.platform.match.dto.ClientVisitorDto;

import java.util.UUID;

public record ClientVisitorRequest(UUID uuid, int visitCount) {
    public static ClientVisitorRequest of(UUID uuid){
        return new ClientVisitorRequest(uuid, 0);
    }
    public static ClientVisitorRequest of(UUID uuid, int visitCount){
        return new ClientVisitorRequest(uuid, visitCount);
    }
    public ClientVisitorDto toDto(){
        return ClientVisitorDto.of(uuid,visitCount);
    }
}
