package cn.nextours.springboot.listener

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationPreparedEvent
import org.springframework.boot.context.event.ApplicationStartingEvent
import org.springframework.context.ApplicationListener

class ApplicationStartingEventListener : ApplicationListener<ApplicationStartingEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationStartingEventListener::class.java)

    override fun onApplicationEvent(event: ApplicationStartingEvent) {
        logger.warn("..........ApplicationStartingEventListener..........")
    }
}