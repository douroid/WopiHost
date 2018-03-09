package cn.nextours.springboot.api.controller

import cn.nextours.springboot.annotation.OpenForSpringAnnotation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@OpenForSpringAnnotation
@Controller
class ApiController {

    @GetMapping("/api")
    fun api() = "redirect:swagger-ui.html"

}