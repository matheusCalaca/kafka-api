package br.com.matheusCalaca.kafka.controller


import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class KafkaProducerController(val kafkaTemplate: KafkaTemplate<String, Objects>) {


    @PostMapping("/kafka/producer/{topic}")
    fun sendMessage(@PathVariable("topic") topic: String, @RequestBody producer: Objects): ResponseEntity<String> {

        kafkaTemplate.send(topic, producer)
        return ResponseEntity.ok("{\"result\":\"topic created\"}")

    }

}
