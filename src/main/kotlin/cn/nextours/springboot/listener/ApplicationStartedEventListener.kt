package cn.nextours.springboot.listener

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.ApplicationListener

class ApplicationStartedEventListener : ApplicationListener<ApplicationStartedEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationPreparedEventListener::class.java)

    override fun onApplicationEvent(event: ApplicationStartedEvent) {
        logger.info("..........ApplicationStartedEventListener..........")
    }
}