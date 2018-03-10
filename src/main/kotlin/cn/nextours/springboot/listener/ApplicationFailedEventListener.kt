package cn.nextours.springboot.listener

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
import org.springframework.boot.context.event.ApplicationFailedEvent
import org.springframework.context.ApplicationListener

class ApplicationFailedEventListener : ApplicationListener<ApplicationFailedEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationFailedEventListener::class.java)

    override fun onApplicationEvent(event: ApplicationFailedEvent) {
        logger.warn("..........ApplicationFailedEventListener..........")
    }
}