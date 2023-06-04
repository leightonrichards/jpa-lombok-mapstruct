package com.example.jpa.controller;

import com.example.jpa.dto.OrderDto;
import com.example.jpa.dto.OrderItemDto;
import com.example.jpa.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class OrderMvcTest {

    static final String EXPECTED_JSON = """
{
   "id" : null,
   "orderNumber" : 4,
   "description" : "SalesTransaction4",
   "orderValue" : 50,
   "orderItems" : [ {
     "id" : null,
     "itemNumber" : 1,
     "description" : "Item 41",
     "itemValue" : 50
   } ]
 }""";
    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findOrder() throws Exception {
        OrderDto order = new OrderDto(4, "SalesTransaction4");
        order.addItem(new OrderItemDto(1, "Item 41", 50));

        when(orderService.fetchByDescription("SalesTransaction4")).thenReturn(order);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/order/SalesTransaction4"))
                .andExpect(status().isOk())
                .andExpect(content().json(EXPECTED_JSON));
    }
}
