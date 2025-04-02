package com.tavernrumours.cms.management.content

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "content")
data class Content(
    @Id
    @Indexed
    val id: UUID?,
    val content: String,
)