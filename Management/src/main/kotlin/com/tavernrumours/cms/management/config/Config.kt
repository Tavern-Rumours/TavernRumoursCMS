package com.tavernrumours.cms.management.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import java.io.File
import java.io.IOException
import java.util.Properties

@Component
@ConfigurationProperties(prefix = "config")
@Validated
class Config {
    final var username: String = ""
    final var password: String = ""

    private val propertiesLocation: String = System.getProperty("user.home") + "/TavernRumours/application.properties"
    private val properties = Properties()

    init {
        try {
            properties.load(File(propertiesLocation).inputStream())
            username = properties.getProperty("username")
            password = properties.getProperty("password")
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}