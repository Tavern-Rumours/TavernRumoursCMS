package com.tavernrumours.cms.management.metadata

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MetaDataRepository: CrudRepository<MetaData, UUID> {
    fun findMetaDataByAuthor(author: UUID): List<MetaData>
    fun findMetaDataByProjectId(projectId: UUID): List<MetaData>
    fun findMetaDataByCategoryId(categoryId: UUID): List<MetaData>
    fun findMetaDataByProjectIdAndCategoryIdIsNull(projectId: UUID): List<MetaData>
}