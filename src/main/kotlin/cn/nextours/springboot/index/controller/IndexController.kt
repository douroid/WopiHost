package cn.nextours.springboot.index.controller

import cn.nextours.springboot.annotation.OpenForSpringAnnotation
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping

@OpenForSpringAnnotation
@Controller
class IndexController {

    @RequestMapping("/")
    fun home(model: ModelMap): String {
        with(model) {
            addAttribute("name", "Jack")
            addAttribute("title", "Kotlin")
        }
        return "index"
    }

}