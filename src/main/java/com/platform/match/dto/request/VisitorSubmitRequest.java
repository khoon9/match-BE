package com.platform.match.dto.request;

import com.platform.match.domain.constant.Gender;
import com.platform.match.dto.VisitorSubmitFormDto;

public record VisitorSubmitRequest(Gender gender, String age, String email, String firstContent, String secondContent) {
    public VisitorSubmitFormDto toDto() {return VisitorSubmitFormDto.of(gender,age,email,firstContent,secondContent);}
}
