package com.example.softwareengineering;


import com.example.softwareengineering.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testUser() {
        User user = new User(1L, "user", "user@example.com", "password", null);

        Assert.assertEquals(1L, user.getUserid().longValue());
        Assert.assertEquals("user", user.getUsername());
        Assert.assertEquals("user@example.com", user.getEmail());
        Assert.assertEquals("password", user.getPassword());
        Assert.assertNull(user.getEvents());
    }
}