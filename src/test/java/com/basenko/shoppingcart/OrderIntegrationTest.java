package com.basenko.shoppingcart;


import com.basenko.shoppingcart.security.SecurityUtil;
import com.basenko.shoppingcart.util.RequestBuilder;
import com.basenko.shoppingcart.util.TestRequestTemplates;
import com.basenko.shoppingcart.util.TestUtils;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class OrderIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser (authorities = "CLIENT" , value = "test")
    public void createOrder() throws Exception {
        this.mockMvc.perform(post("/api/v1/orders").
                        content(TestUtils.convertRequestDtoToJson(
                                RequestBuilder.createOrderDto()
                        ))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
