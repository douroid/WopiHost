package cn.nextours.springboot.wopi.controller

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.net.HttpURLConnection

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WopiControllerTest {

    @Autowired
    private var wopiController: WopiController? = null

    private var mvc: MockMvc? = null

    @Before
    fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(wopiController).build()
    }

    @Test
    fun testRouter() {
        val location = "http://192.168.56.105/x/_layouts/xlviewerinternal.aspx?WOPISrc=http://192.168.199.209/wopi/files/1234567890.xlsx&access_token=eyJlZGl0YWJsZSI6ZmFsc2V9"

        mvc?.perform(MockMvcRequestBuilders.get("/wopi/router/1234567890.xlsx").accept(MediaType.TEXT_HTML))
                ?.andExpect(status().`is`(HttpURLConnection.HTTP_MOVED_TEMP))
                ?.andExpect(header().string("Location", location))
    }

//    @Test
    fun testFileCheckInfo() {
        mvc?.perform(MockMvcRequestBuilders.get("/wopi/files/1234567890.xlsx?access_token=eyJlZGl0YWJsZSI6ZmFsc2V9").accept(MediaType.APPLICATION_JSON))
                ?.andExpect(status().isOk)
    }
}