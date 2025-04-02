package com.tavernrumours.cms.management.content

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ContentNotFoundException(override val message: String): Exception()