package cn.nextours.springboot.listener

import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class HostApplicationRunner : ApplicationRunner {

    private val logger = LoggerFactory.getLogger(HostApplicationRunner::class.java)

    override fun run(args: ApplicationArguments?) {
        logger.warn("..........HostApplicationRunner..........")
    }

}