package cn.nextours.springboot.index.controller

import cn.nextours.springboot.annotation.OpenForSpringAnnotation
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping

@OpenForSpringAnnotation
@Controller
class IndexController {

    @GetMapping("/")
    fun home(model: ModelMap): String {
        return "redirect:swagger-ui.html"
    }

}