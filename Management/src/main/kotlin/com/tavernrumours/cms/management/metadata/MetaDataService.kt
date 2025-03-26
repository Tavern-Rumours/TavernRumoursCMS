package com.tavernrumours.cms.management.metadata

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class MetaDataService(
    private val repository: MetaDataRepository
) {
    fun patch(id: UUID?, data: MetaData): MetaData {
        id?.let {
            return if (repository.existsById(it)) save(data.copy(updateDate = Instant.now()))
            else throw MetaDataNotFoundException("No data found to patch")
        }
        ?: throw MetaDataNotFoundException("No id found to patch")
    }

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

    fun save(data: MetaData): MetaData = repository.save(data)

    fun findMetaDataByAuthor(author: UUID): List<MetaData> {
        val data = repository.findMetaDataByAuthor(author)
        if (data.isNotEmpty()) return data
        else throw MetaDataNotFoundException("No data found for author")

    }

    fun deleteMetaData(id: UUID) {
        return if (repository.existsById(id)) repository.deleteById(id)
        else throw MetaDataNotFoundException("No data found to delete")
    }

    private fun getData(id: UUID): MetaData {
        return if (repository.existsById(id)) repository.findById(id).get()
        else throw MetaDataNotFoundException("No data found for ID")
    }
}