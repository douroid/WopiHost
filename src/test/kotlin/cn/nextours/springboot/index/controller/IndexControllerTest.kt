package cn.nextours.springboot.index.controller

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private var restTemplate: TestRestTemplate? = null
//    private val mvc: MockMvc = MockMvcBuilders.standaloneSetup(IndexController()).build()

    @Test
    fun testHome() {
//        mvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk)
//                .andExpect(content().string("Hello World"))
        val body = restTemplate?.getForObject("/", String::class.java)
        assert(body == "Hello World")
    }

}