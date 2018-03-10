package cn.nextours.springboot.listener

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener

class ApplicationReadyEventListener : ApplicationListener<ApplicationReadyEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationPreparedEventListener::class.java)

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        logger.info("..........ApplicationReadyEventListener..........")
    }
}