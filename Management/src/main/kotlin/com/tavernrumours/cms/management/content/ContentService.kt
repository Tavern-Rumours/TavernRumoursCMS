package com.tavernrumours.cms.management.content

import org.springframework.stereotype.Service
import java.util.*

@Service
class ContentService(
    private val repository: ContentRepository
) {
    fun save(id: UUID, content: String) = repository.save(Content(id, content))

    fun findById(id: UUID): Content {
        return if (repository.existsById(id)) repository.findById(id).get()
        else throw ContentNotFoundException("No content found for ID")
    }

    fun delete(id: UUID) {
        return if (repository.existsById(id)) repository.deleteById(id)
        else throw ContentNotFoundException("No content found for ID")
    }
}