package org.se.lab;

import org.junit.*;

public abstract class AbstractLoginTest {

    LoginService loginService;

    @Before
    public void setup()
    {
        loginService = new LoginService();
    }
}
