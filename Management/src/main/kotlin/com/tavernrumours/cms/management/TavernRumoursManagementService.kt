package com.tavernrumours.cms.management

import com.tavernrumours.cms.management.config.Config
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
import org.springframework.context.ApplicationListener
import org.springframework.core.env.PropertiesPropertySource
import java.util.*

@SpringBootApplication
class TavernRumoursManagementService {
	companion object EnvironmentPreparation : ApplicationListener<ApplicationEnvironmentPreparedEvent> {
		override fun onApplicationEvent(event: ApplicationEnvironmentPreparedEvent) {
			val config = Config()
			require(config.username.isNotEmpty() || config.password.isNotEmpty())
			val properties = Properties()
			properties.setProperty("spring.datasource.username", config.username)
			properties.setProperty("spring.data.mongodb.username", config.username)
			properties.setProperty("spring.datasource.password", config.password)
			properties.setProperty("spring.data.mongodb.password", config.password)

			event.environment.propertySources.addFirst(PropertiesPropertySource("db_properties", properties))
		}
	}
}

fun main(args: Array<String>) {
	SpringApplicationBuilder(TavernRumoursManagementService::class.java)
		.listeners(TavernRumoursManagementService.EnvironmentPreparation)
		.sources(TavernRumoursManagementService::class.java)
		.run(*args)
}
