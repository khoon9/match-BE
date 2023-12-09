package com.platform.match.controller;

import com.platform.match.service.ClientVisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/visitor")
@RestController
public class ClientVisitorController {

    private final ClientVisitorService clientVisitorService;

    @GetMapping("")
    public ResponseEntity<UUID> getUuid(){
        return ResponseEntity.ok(UUID.randomUUID());
    }

    @PostMapping("")
    public ResponseEntity<String> saveVisitor(){
        return ResponseEntity.ok("생성");
    }

    @PutMapping("/visit")
    public ResponseEntity<String> updateVisitCount(){
        return ResponseEntity.ok("접속 확인");
    }


}
