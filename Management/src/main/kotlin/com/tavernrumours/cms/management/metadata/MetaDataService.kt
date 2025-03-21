package com.tavernrumours.cms.management.metadata

import org.springframework.stereotype.Service
import java.util.*

@Service
class MetaDataService(
    private val repository: MetaDataRepository
) {
    fun save(data: MetaData) = repository.save(data)
    fun findMetaDataByAuthor(author: UUID) = repository.findMetaDataByAuthor(author)
}