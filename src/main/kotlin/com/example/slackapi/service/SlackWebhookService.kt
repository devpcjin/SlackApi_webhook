package com.example.slackapi.service

import org.json.JSONObject
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class SlackWebhookService(private val restTemplate: RestTemplate) {

    fun sendContent(content: String) {
        val jsonObj = JSONObject(
                """
                    {"attachments": [
                        { 
                            "pretext" : "attachments 제목입니다!",
                            "color" : "#2eb886",
                            "text" : ${content}
                        }
                      ]
                    }
                """.trimIndent()
        )

        val header = HttpHeaders()
        header.contentType = MediaType.APPLICATION_JSON
        val httpEntity = HttpEntity(jsonObj.toString(), header)

        var webhookUrl = "Webhook url을 입력하세요!"

        restTemplate.exchange(webhookUrl, HttpMethod.POST, httpEntity, String::class.java)

    }


}