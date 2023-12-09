package com.platform.match.service;

import com.platform.match.repository.ClientVisitorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ClientVisitorService {
    private final ClientVisitorRepository clientVisitorRepository;
}
