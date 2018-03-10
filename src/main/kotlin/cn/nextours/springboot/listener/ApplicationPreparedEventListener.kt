package cn.nextours.springboot.listener

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationPreparedEvent
import org.springframework.context.ApplicationListener

class ApplicationPreparedEventListener : ApplicationListener<ApplicationPreparedEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationPreparedEventListener::class.java)

    override fun onApplicationEvent(event: ApplicationPreparedEvent) {
        logger.warn("..........ApplicationPreparedEventListener..........")
    }
}