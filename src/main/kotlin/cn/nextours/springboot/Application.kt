package cn.nextours.springboot

import cn.nextours.springboot.annotation.OpenForSpringAnnotation
import cn.nextours.springboot.wopi.domain.WopiConfiguration
import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@OpenForSpringAnnotation
@SpringBootApplication //same as @Configuration @EnableAutoConfiguration @ComponentScan
@Import(WebConfiguration::class)
class Application

class WebConfiguration : WebMvcConfigurerAdapter() {
    @Bean
    @ConfigurationProperties(prefix = "wopi")
    fun wopiConfiguration(): WopiConfiguration {
        return WopiConfiguration()
    }
}

fun main(args: Array<String>) {
    val app = SpringApplication(Application::class.java)
    with(app) {
        setBannerMode(Banner.Mode.OFF)
        isWebEnvironment = true
        run()
    }
}