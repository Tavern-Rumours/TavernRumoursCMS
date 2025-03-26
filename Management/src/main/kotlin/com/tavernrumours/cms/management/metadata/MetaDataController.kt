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

    @PatchMapping("/{contentId}", params = ["isDraft"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateIsDraft(@PathVariable contentId: UUID, @RequestParam isDraft: Boolean) = service.patchDraft(contentId, isDraft)

    @PatchMapping("/{contentId}", params = ["isPublished"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateIsPublished(@PathVariable contentId: UUID, @RequestParam isPublished: Boolean) = service.patchPublished(contentId, isPublished)

    @PatchMapping("/{contentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateContent(@PathVariable contentId: UUID) = service.patchContent(contentId)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteMetaData(@PathVariable id: UUID): Unit = service.deleteMetaData(id)
}