package com.tavernrumours.cms.management.metadata

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MetaDataRepository: CrudRepository<MetaData, UUID> {
    fun findMetaDataByAuthor(author: UUID): List<MetaData>
}