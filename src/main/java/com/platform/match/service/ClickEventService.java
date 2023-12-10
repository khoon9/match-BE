package com.platform.match.service;

import com.platform.match.domain.ClickEvent;
import com.platform.match.domain.ClientVisitor;
import com.platform.match.domain.constant.ClickType;
import com.platform.match.dto.ClickEventDto;
import com.platform.match.repository.ClickEventRepository;
import com.platform.match.repository.ClientVisitorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ClickEventService {
    private final ClickEventRepository clickEventRepository;
    private final ClientVisitorRepository clientVisitorRepository;

    public String saveClickEvent(ClickType clickType, UUID uuid) {
        try{
            clickEventRepository.save(ClickEvent.of(clientVisitorRepository.getReferenceByUuid(uuid), clickType));
            return "잡속 기록 성공";
        }catch (EntityNotFoundException e){
            log.warn("방문자를 찾을 수 없습니다 - uuid: {}", uuid);
            return "잡속 기록 실패";
        }
    }
}
