package com.ecommerce.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiProductTest {
    @Test
    public void testGetProducts() {
        // Example endpoint, replace with actual if available
        String endpoint = "https://fakestoreapi.com/products";
        Response response = RestAssured.get(endpoint);
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertTrue(response.getBody().asString().contains("title"), "Response should contain product titles");
    }
} 