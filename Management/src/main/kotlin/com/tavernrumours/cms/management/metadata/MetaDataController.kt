package com.tavernrumours.cms.management.metadata

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/metadata")
class MetaDataController(private val service: MetaDataService) {

    @GetMapping("/{author}")
    fun getAllMetaDataByAuthor(@PathVariable author: UUID): ResponseEntity<List<MetaData>> {
        val data = service.findMetaDataByAuthor(author)
        return if (data.isNotEmpty()) ResponseEntity(data, HttpStatus.OK)
        else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping("")
    fun createMetaData(@RequestBody metaData: MetaData): ResponseEntity<MetaData> {
        val created = service.save(metaData)
        return ResponseEntity(created, HttpStatus.CREATED)
    }
}