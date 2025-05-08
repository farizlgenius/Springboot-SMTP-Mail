package com.krungsri.ipassportmailserver.controller;

import com.krungsri.ipassportmailserver.schema.Health;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ipassport/api/email")
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Health> getHealth() {
        Health health = new Health();
        health.setStatus("UP");
        health.setTimeStamp(java.time.LocalDateTime.now());
        return ResponseEntity.status(200).body(health);
    }
}
