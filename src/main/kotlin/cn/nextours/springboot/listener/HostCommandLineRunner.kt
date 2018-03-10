package cn.nextours.springboot.listener

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class HostCommandLineRunner : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(HostCommandLineRunner::class.java)

    override fun run(vararg args: String?) {
        logger.info("..........HostCommandLineRunner..........")
    }

}