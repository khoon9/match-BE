package com.platform.match.controller;

import com.platform.match.dto.request.ClientVisitorRequest;
import com.platform.match.service.ClientVisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("")
@RestController
public class ClientVisitorController {

    private final ClientVisitorService clientVisitorService;

    @GetMapping("")
    public ResponseEntity<UUID> getUuid(){
        return ResponseEntity.ok(UUID.randomUUID());
    }

    @PostMapping("")
    public ResponseEntity<String> postNewClientVisitor(@RequestBody ClientVisitorRequest clientVisitorRequest){
        return ResponseEntity.ok(clientVisitorService.saveClientVisitor(clientVisitorRequest.toDto()));
    }

    @PutMapping("/visit")
    public ResponseEntity<String> updateVisitCount(@RequestBody ClientVisitorRequest clientVisitorRequest){
        return ResponseEntity.ok(clientVisitorService.updateClientVisitor(clientVisitorRequest.uuid()));
    }

}
