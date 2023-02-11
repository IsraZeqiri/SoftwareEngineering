package com.example.softwareengineering;


import com.example.softwareengineering.pojo.Event;
import com.example.softwareengineering.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class EventTest {
    @Test
    public void testEvent() {
        User user = new User(1L, "user", "user@example.com", "password", null);
        Event event = new Event(1L, "Event 1", "Category", "Location",
                LocalDateTime.now(), 12.34, 56.78, 100.0, user);

        Assert.assertEquals(1L, event.getId().longValue());
        Assert.assertEquals("Event 1", event.getName());
        Assert.assertEquals("Category", event.getCategory());
        Assert.assertEquals("Location", event.getLocation());
        Assert.assertNotNull(event.getDateTime());
        Assert.assertEquals(12.34, event.getLatitude(), 0.0);
        Assert.assertEquals(56.78, event.getLongitude(), 0.0);
        Assert.assertEquals(100.0, event.getPrice(), 0.0);
        Assert.assertEquals(user, event.getUser());
    }
}