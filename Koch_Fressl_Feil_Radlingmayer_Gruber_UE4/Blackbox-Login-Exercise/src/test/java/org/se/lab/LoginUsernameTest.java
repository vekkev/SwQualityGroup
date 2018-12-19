package org.se.lab;

import org.junit.*;

public class LoginUsernameTest extends AbstractLoginTest
{
    @Test(expected = IllegalArgumentException.class)
    public void testWrongUsername()
    {
        loginService.login("a", Helper.buildString('0',10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWrongUsername2()
    {
        loginService.login("aaa", Helper.buildString('0',10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWrongUsername3()
    {
        loginService.login("zzz", Helper.buildString('0',10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWrongUsername4()
    {
        loginService.login("````", Helper.buildString('0',10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWrongUsername5()
    {
        loginService.login("{{{{", Helper.buildString('0',10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWrongUsername6()
    {
        loginService.login("aaaaaaaaa", Helper.buildString('0',10));
    }
    @Test
    public void testValidUsername()
    {
        Assert.assertFalse(loginService.login("aaaa", Helper.buildString('0', 10)));
    }
    @Test
    public void testValidUsername2()
    {
        Assert.assertFalse(loginService.login("zzzz", Helper.buildString('0', 10)));
    }
    @Test
    public void testValidUsername3()
    {
        Assert.assertFalse(loginService.login("aaaaaaaa", Helper.buildString('0', 10)));
    }
    @Test
    public void testValidUsername4()
    {
        Assert.assertFalse(loginService.login("zzzzzzzz", Helper.buildString('0', 10)));
    }

}
