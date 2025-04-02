package com.tavernrumours.cms.management.content

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/content")
class ContentController(
    private val service: ContentService
) {

    @GetMapping("/{contentId}")
    @ResponseStatus(HttpStatus.OK)
    fun getContentById(@PathVariable contentId: UUID): Content = service.findById(contentId)

    @PostMapping("/{contentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun postContent(@PathVariable contentId: UUID, @RequestBody content: String) = service.save(contentId, content)

    @DeleteMapping("/{contentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteContent(@PathVariable contentId: UUID) = service.delete(contentId)
}