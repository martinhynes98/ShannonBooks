package com.shannon.online;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
//@Sql({"/sql/data.sql"})
public class ControllerTests {

    @Autowired
	private MockMvc mockMvc;
    
    @Test
	public void whenNewOrderShouldReturnOk() throws Exception {

        this.mockMvc.perform(post("/v1/orders")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"customerId\": 1, \"productId\": 3, \"orderType\": \"prime\"}") 
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
	}

    @Test
    public void getAllOrders() throws Exception {
        this.mockMvc.perform(get("/v1/orders?orderType=prime")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
	public void whenGetOrderWithInvalidOrderIdShouldReturnNotFound() throws Exception {

        this.mockMvc.perform(get("/v1/orders/999999?orderType=prime")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
	}

    @Test
	public void whenGetOrderWithValidOrderIdShouldReturnOk() throws Exception {
        
        this.mockMvc.perform(post("/v1/orders")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"customerId\": 1, \"productId\": 3, \"orderType\": \"prime\"}") 
        .accept(MediaType.APPLICATION_JSON));

        this.mockMvc.perform(get("/v1/orders/1?orderType=prime")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
	}
}