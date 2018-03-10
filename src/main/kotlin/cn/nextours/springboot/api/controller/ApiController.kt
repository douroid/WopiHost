package cn.nextours.springboot.api.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ApiController {

    @GetMapping("/api")
    fun api() = "redirect:swagger-ui.html"

}