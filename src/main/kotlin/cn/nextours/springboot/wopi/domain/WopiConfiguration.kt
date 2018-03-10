package cn.nextours.springboot.wopi.domain

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "wopi")
data class WopiConfiguration(var owa: Uri = Uri(),
                             var fileInfo: Uri = Uri(),
                             var docs: Uri = Uri())

data class Uri(var uri: String = "")
