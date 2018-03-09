package cn.nextours.springboot.index.controller

import cn.nextours.springboot.annotation.OpenForSpringAnnotation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@OpenForSpringAnnotation
@RestController
class IndexController {

    @GetMapping("/")
    fun home(): String {
        return "Hello World"
    }

}