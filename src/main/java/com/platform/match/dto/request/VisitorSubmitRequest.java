package com.platform.match.dto.request;

import com.platform.match.domain.constant.Gender;
import com.platform.match.dto.VisitorSubmitFormDto;

public record VisitorSubmitRequest(Gender gender, String email, String firstContent, String secondContent) {
    public VisitorSubmitFormDto toDto() {return VisitorSubmitFormDto.of(gender,email,firstContent,secondContent);}
}
