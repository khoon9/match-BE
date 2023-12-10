package com.platform.match.service;

import com.platform.match.domain.ClientVisitor;
import com.platform.match.dto.ClientVisitorDto;
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
public class ClientVisitorService {
    private final ClientVisitorRepository clientVisitorRepository;

    public String saveClientVisitor(ClientVisitorDto clientVisitorDto) {
        clientVisitorRepository.save(clientVisitorDto.toEntity());
        return "저장 성공";
    }

    public String updateClientVisitor(UUID uuid){
        try{
            ClientVisitor clientVisitor = clientVisitorRepository.getReferenceByUuid(uuid);
            clientVisitor.setVisitCount(clientVisitor.getVisitCount() + 1);
            return "업데이트 성공";
        }catch (EntityNotFoundException e){
            log.warn("방문자 업데이트 실패. 해당 방문자를 찾을 수 없습니다 - uuid: {}", uuid);
            return "업데이트 실패";
        }

    }
}
