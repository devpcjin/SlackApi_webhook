package com.example.slackapi.controller

import com.example.slackapi.service.SlackWebhookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class SlackWebhookController(private val webhookCallService: SlackWebhookService) {
    @PostMapping("/msg")
    fun messageSendToSlack(@RequestParam(required = true) text: String): ResponseEntity<String>{
        webhookCallService.sendContent("${text}")
        return ResponseEntity("success", HttpStatus.OK)
    }
}