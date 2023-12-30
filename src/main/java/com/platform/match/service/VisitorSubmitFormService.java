package com.platform.match.service;

import com.platform.match.dto.VisitorSubmitFormDto;
import com.platform.match.repository.VisitorSubmitFormRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class VisitorSubmitFormService {
    private final VisitorSubmitFormRepository visitorSubmitFormRepository;

    public Boolean saveVisitorSubmitForm(VisitorSubmitFormDto visitorSubmitFormDto){
        if(visitorSubmitFormDto.email() == null) {
            return false;
        } else {
            visitorSubmitFormRepository.save(visitorSubmitFormDto.toEntity());
            return true;
        }
    }
}
