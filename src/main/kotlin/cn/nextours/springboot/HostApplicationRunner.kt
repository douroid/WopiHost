package cn.nextours.springboot

import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class HostApplicationRunner : ApplicationRunner {

    private val logger = LoggerFactory.getLogger(HostApplicationRunner::class.java)

    override fun run(args: ApplicationArguments?) {
        logger.info("##################")
        args?.optionNames?.forEach {
            logger.info("name: $it, value: ${args.getOptionValues(it)}")
        }
    }

}