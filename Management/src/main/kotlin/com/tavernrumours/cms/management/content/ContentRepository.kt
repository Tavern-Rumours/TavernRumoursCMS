package com.tavernrumours.cms.management.content

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ContentRepository: CrudRepository<Content, UUID> {
}