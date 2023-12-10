package com.platform.match.dto.request;

import com.platform.match.domain.ClientVisitor;
import com.platform.match.dto.ClientVisitorDto;

import java.util.UUID;

public record ClientVisitorRequest(String uuid, int visitCount) {
    public static ClientVisitorRequest of(String uuid){
        return new ClientVisitorRequest(uuid, 0);
    }
    public static ClientVisitorRequest of(String uuid, int visitCount){
        return new ClientVisitorRequest(uuid, visitCount);
    }
    public ClientVisitorDto toDto(){
        return ClientVisitorDto.of(uuid,visitCount);
    }
}
