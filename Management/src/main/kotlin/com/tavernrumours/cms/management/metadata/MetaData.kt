package com.tavernrumours.cms.management.metadata

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "tr_content")
data class MetaData(
    @Id
    @GeneratedValue
    val id: UUID?,
    val projectId: UUID?,
    val categoryId: UUID?,
    val title: String,
    val author: UUID,
    val isPublished: Boolean? = false,
    val isDraft: Boolean? = true,
    @CreationTimestamp
    val creationDate: Instant? = Instant.now(),
    val updateDate: Instant? = Instant.now(),
    val type: Int,
)