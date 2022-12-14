package com.basenko.shoppingcart;

import com.basenko.shoppingcart.util.TestRequestTemplates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class GoodsIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getItemsTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/goods"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(authorities = "MANAGER")
    public void addNewItemWithAuthTest() throws Exception {
        this.mockMvc.perform(post("/api/v1/goods")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestRequestTemplates.newItem))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addNewItemWithoutAuthTest() throws Exception {
        this.mockMvc.perform(post("/api/v1/goods")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestRequestTemplates.newItem))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

}
