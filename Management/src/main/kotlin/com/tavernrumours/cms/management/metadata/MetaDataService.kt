package com.tavernrumours.cms.management.metadata

import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class MetaDataService(
    private val repository: MetaDataRepository
) {
    fun patchDraft(id: UUID, isDraft: Boolean) = repository.save(
        getData(id).copy(
            isDraft = isDraft,
            updateDate = Instant.now()
        )
    )

    fun patchPublished(id: UUID, isPublished: Boolean) = repository.save(
        getData(id).copy(
            isPublished = isPublished,
            updateDate = Instant.now()
        )
    )

    fun patchContent(id: UUID) = repository.save(
            getData(id).copy(
                updateDate = Instant.now()
            )
        )

    fun patchTitle(id: UUID, title: String) = repository.save(
        getData(id).copy(
            title = title,
            updateDate = Instant.now()
        )
    )

    fun save(data: MetaData): MetaData = repository.save(data)

    fun findMetaDataByAuthor(author: UUID): List<MetaData>  = repository.findMetaDataByAuthor(author)

    fun findMetaDataByProjectId(projectId: UUID): List<MetaData> = repository.findMetaDataByProjectId(projectId)

    fun findMetaDataByCategoryId(categoryId: UUID): List<MetaData> = repository.findMetaDataByCategoryId(categoryId)

    fun deleteMetaData(id: UUID) {
        return if (repository.existsById(id)) repository.deleteById(id)
        else throw MetaDataNotFoundException("No data found to delete")
    }

    private fun getData(id: UUID): MetaData {
        return if (repository.existsById(id)) repository.findById(id).get()
        else throw MetaDataNotFoundException("No data found for ID")
    }
}