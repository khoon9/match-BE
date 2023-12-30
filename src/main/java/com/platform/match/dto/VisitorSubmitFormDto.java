package com.platform.match.dto;

import com.platform.match.domain.VisitorSubmitForm;
import com.platform.match.domain.constant.Gender;

import java.io.Serializable;

/**
 * DTO for {@link com.platform.match.domain.VisitorSubmitForm}
 */
public record VisitorSubmitFormDto(
        Long id,
        Gender gender,
        String age,
        String email,
        String firstContent,
        String secondContent
) {
    public static VisitorSubmitFormDto from(VisitorSubmitForm entity){
        return new VisitorSubmitFormDto(entity.getId(), entity.getGender(), entity.getAge(), entity.getEmail(), entity.getFirstContent(), entity.getSecondContent());
    }
    public VisitorSubmitForm toEntity(){ return VisitorSubmitForm.of(gender,age,email,firstContent,secondContent);}

    public static VisitorSubmitFormDto of(Long id, Gender gender, String age, String email, String firstContent, String secondContent){
        return new VisitorSubmitFormDto(id,gender,age,email,firstContent,secondContent);
    }

    public static VisitorSubmitFormDto of(Gender gender, String age,String email, String firstContent, String secondContent){
        return new VisitorSubmitFormDto(null,gender, age, email,firstContent,secondContent);
    }


}