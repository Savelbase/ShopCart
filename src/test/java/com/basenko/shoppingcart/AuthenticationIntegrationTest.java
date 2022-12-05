package com.basenko.shoppingcart;


import com.basenko.shoppingcart.util.TestRequestTemplates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class AuthenticationIntegrationTest {

    @Autowired
    private MockMvc mockMvc ;


    @Test
    public void successLoginTest () throws  Exception {
        this.mockMvc.perform(post("/api/v1/auth/login").
                        content(TestRequestTemplates.loginAndPasswordDto)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void failedLoginTest () throws  Exception {
        this.mockMvc.perform(post("/api/v1/auth/login").
                        content(TestRequestTemplates.failedLoginAndPasswordDto)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden())
                .andDo(print());
    }

    @Test
    public void badRequestLoginTest () throws  Exception {
        this.mockMvc.perform(post("/api/v1/auth/login"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

}
