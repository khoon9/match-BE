package com.platform.match.controller;

import com.platform.match.dto.request.VisitorSubmitRequest;
import com.platform.match.service.VisitorSubmitFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("")
@RestController
public class VisitorSubmitFormController {
    private final VisitorSubmitFormService visitorSubmitFormService;

    @PostMapping("/visitor/submit")
    public ResponseEntity<Boolean> postVisitorSubmit(@RequestBody VisitorSubmitRequest visitorSubmitRequest){
        return ResponseEntity.ok(visitorSubmitFormService.saveVisitorSubmitForm(visitorSubmitRequest.toDto()));
    }
}
