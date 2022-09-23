package com.mis.kill.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Li HuiKun
 * @Date 2022/9/23 10:23
 **/
@RestController
@RequestMapping("/ws")
public class WebSocketController {

    @GetMapping("/push/{message}")
    public ResponseEntity<String> push(@PathVariable(name = "message") String message) {
        WebSocketServe.batchSendInfo(message);
        return ResponseEntity.ok("WebSocket 推送消息给所有人");
    }

}