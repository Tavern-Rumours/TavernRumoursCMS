package com.tavernrumours.cms.management.metadata

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class MetaDataNotFoundException(override val message: String): Exception()