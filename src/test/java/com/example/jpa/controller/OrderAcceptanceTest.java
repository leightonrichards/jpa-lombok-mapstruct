package com.example.jpa.controller;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderAcceptanceTest {
    @Value(value="${local.server.port}")
    private int port;

    static final String EXPECTED_JSON = """
{
  "id" : 1,
  "orderNumber" : 1,
  "description" : "SalesTransaction1",
  "orderValue" : 100,
  "orderItems" : [ {
    "id" : 3,
    "itemNumber" : 3,
    "description" : "Item 3",
    "itemValue" : 50
  }, {
    "id" : 2,
    "itemNumber" : 2,
    "description" : "Item 2",
    "itemValue" : 30
  }, {
    "id" : 1,
    "itemNumber" : 1,
    "description" : "Item 1",
    "itemValue" : 20
  } ]
}""";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findOrder() throws Exception {
        String jsonResponse = restTemplate.getForObject("http://localhost:"+ port + "/v1/order/SalesTransaction1", String.class);
        JSONAssert.assertEquals(EXPECTED_JSON, jsonResponse, new CustomComparator(JSONCompareMode.LENIENT));
    }
}
