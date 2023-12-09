package com.platform.match.controller;


import com.platform.match.domain.constant.ClickType;
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

    @PostMapping("/access/{click_type}")
    public ResponseEntity<String> saveClickEvent(@PathVariable ClickType click_type, @RequestBody UUID uuid){
        return ResponseEntity.ok("클릭 이벤트 생성");
    }
}
