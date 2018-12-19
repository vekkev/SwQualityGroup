package org.se.lab;

import org.junit.*;

// Class to test the Login Service
// extension of abstract parent class needed

public class LoginTest extends AbstractLoginTest
{

    @Test
    public void testValidUser()
    {
        Assert.assertTrue(loginService.login("homer", "4upbmy83qy"));

    }
}
