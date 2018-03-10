package cn.nextours.springboot.listener

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
import org.springframework.context.ApplicationListener

class ApplicationEnvironmentPreparedEventListener : ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationEnvironmentPreparedEventListener::class.java)

    override fun onApplicationEvent(event: ApplicationEnvironmentPreparedEvent) {
        logger.warn("..........ApplicationEnvironmentPreparedEventListener..........")
    }
}