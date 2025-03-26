package com.tavernrumours.cms.management.metadata

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/metadata")
class MetaDataController(private val service: MetaDataService) {

    @GetMapping("/{author}")
    @ResponseStatus(HttpStatus.OK)
    fun getAllMetaDataByAuthor(@PathVariable author: UUID): List<MetaData> = service.findMetaDataByAuthor(author)

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun createMetaData(@RequestBody metaData: MetaData): MetaData = service.save(metaData)

    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun updateMetaData(@RequestBody metaData: MetaData): MetaData = service.patch(metaData.id, metaData)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteMetaData(@PathVariable id: UUID): Unit = service.deleteMetaData(id)
}