package com.platform.match.controller;


import com.platform.match.domain.constant.ClickType;
import com.platform.match.dto.request.ClientVisitorRequest;
import com.platform.match.service.ClickEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("")
@RestController
public class ClickEventController {

    private final ClickEventService clickEventService;

    @PostMapping("/visit/access")
    public ResponseEntity<String> postNewClickEvent(@RequestParam ClickType clickType, @RequestBody ClientVisitorRequest clientVisitorRequest){
        return ResponseEntity.ok(clickEventService.saveClickEvent(clickType, clientVisitorRequest.uuid()));
    }

}
