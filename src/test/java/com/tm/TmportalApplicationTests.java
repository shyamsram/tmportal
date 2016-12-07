package com.tm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tm.service.TeamDetailsService;
import com.tm.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class TmportalApplicationTests {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper objectMapper;

	@Test
	public void testIndex() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("login1"));
	}

    @Test
    public void testValidLogin() throws Exception {
        User user = new User();
        user.setUserId("admin");
        user.setPassword("admin");
        System.out.println("string value is : " + objectMapper.writeValueAsString(user));
        mock.perform(MockMvcRequestBuilders.post("/login")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("userId","admin").param("password","admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testInValidLogin() throws Exception {
        User user = new User();
        user.setUserId("admin");
        user.setPassword("admin1");
        System.out.println("string value is : " + objectMapper.writeValueAsString(user));
        mock.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("userId","admin").param("password","admin1"))
                .andDo(print())
        .andExpect(model().attribute("status","Login Failure"));
    }

    @Autowired
    private TeamDetailsService teamDetailsService;
    @Test
    public void testTeamDetailsService() throws Exception {
        assert teamDetailsService.loginCustomer("admin","admin");
        assert !teamDetailsService.loginCustomer("admin1","admin");
        assert !teamDetailsService.loginCustomer("admin","adm");
    }
}
