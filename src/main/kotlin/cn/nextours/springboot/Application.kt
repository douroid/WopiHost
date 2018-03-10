package cn.nextours.springboot

import cn.nextours.springboot.annotation.OpenForSpringAnnotation
import cn.nextours.springboot.wopi.domain.WopiConfiguration
import org.slf4j.LoggerFactory
import org.springframework.boot.Banner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.*
import springfox.documentation.swagger2.annotations.EnableSwagger2

@OpenForSpringAnnotation
@SpringBootApplication //same as @Configuration @EnableAutoConfiguration @ComponentScan
//@Import(WebConfiguration::class)
//@ImportResource()
class Application

@OpenForSpringAnnotation
@Configuration
@EnableSwagger2
class WebConfiguration : WebMvcConfigurer {

    @Bean
    @ConfigurationProperties(prefix = "wopi")
    fun wopiConfiguration(): WopiConfiguration {
        return WopiConfiguration()
    }

    @Bean
    fun indexApi(): Docket = Docket(DocumentationType.SWAGGER_2)
            .groupName("index-api")
            .select()
            .paths { path -> path == "/" }
            .build()
            .useDefaultResponseMessages(false)
            .enableUrlTemplating(true)

    @Bean
    fun wopiApi(): Docket = Docket(DocumentationType.SWAGGER_2)
            .groupName("wopi-api")
            .apiInfo(
                    ApiInfoBuilder()
                            .title("WOPI Api Documentation")
                            .version("1.0")
                            .description("WOPI Api Documentation")
                            .contact(Contact("Douroid", "https://github.com/douroid/WopiHost", "droid2017@126.com"))
                            .license("Apache License Version 2.0")
                            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                            .termsOfServiceUrl("https://github.com/douroid/WopiHost")
                            .build())
            .select()
            .paths { path -> path?.startsWith("/wopi/") ?: false }
            .build()

    @Bean
    fun uiConfig(): UiConfiguration = UiConfigurationBuilder.builder()
            .deepLinking(true)
            .displayOperationId(false)
            .defaultModelsExpandDepth(1)
            .defaultModelExpandDepth(1)
            .defaultModelRendering(ModelRendering.EXAMPLE)
            .displayRequestDuration(false)
            .docExpansion(DocExpansion.LIST)
            .filter(false)
            .maxDisplayedTags(null)
            .operationsSorter(OperationsSorter.ALPHA)
            .showExtensions(false)
            .tagsSorter(TagsSorter.ALPHA)
            .validatorUrl(null)
            .build()

}

class ApplicationListener1 : ApplicationListener<ApplicationEvent> {
    private val logger = LoggerFactory.getLogger(ApplicationListener1::class.java)
    override fun onApplicationEvent(event: ApplicationEvent) {
        logger.info("@@@@@@@@@@@Event: $event@@@@@@@@@@@")
    }

}

fun main(args: Array<String>) {
    SpringApplicationBuilder()
            .sources(Application::class.java)
            .web(WebApplicationType.SERVLET)
            .bannerMode(Banner.Mode.OFF)
            .listeners(ApplicationListener1())
            .run(*args)
}