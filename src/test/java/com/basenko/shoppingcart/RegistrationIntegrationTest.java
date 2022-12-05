package com.basenko.shoppingcart;

import com.basenko.shoppingcart.model.User;
import com.basenko.shoppingcart.service.UserService;
import com.basenko.shoppingcart.util.RequestBuilder;
import com.basenko.shoppingcart.util.TestUtils;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class RegistrationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void successLoginTest () throws  Exception {
        this.mockMvc.perform(post("/api/v1/registration").
                        content(TestUtils.convertRequestDtoToJson(RequestBuilder.createUserDto()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }


}
