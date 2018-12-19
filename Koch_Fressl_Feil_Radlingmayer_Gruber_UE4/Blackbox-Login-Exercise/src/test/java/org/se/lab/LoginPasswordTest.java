package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class LoginPasswordTest extends AbstractLoginTest
{
    @Test(expected = IllegalArgumentException.class)
    public void testWrongPassword()
    {
        loginService.login("homer", Helper.buildString('a', 9));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWrongPassword2()
    {
        loginService.login("homer", Helper.buildString('z', 9));
    }
    // one ascii symbol smaller as "0"
    @Test(expected = IllegalArgumentException.class)
    public void testWrongPassword3()
    {
        loginService.login("homer", Helper.buildString('/', 10));
    }
    // one ascii symbol higher as "9"
    @Test(expected = IllegalArgumentException.class)
    public void testWrongPassword4()
    {
        loginService.login("homer", Helper.buildString(':', 10));
    }
    //one ascii symbol smaller as "a"
    @Test(expected = IllegalArgumentException.class)
    public void testWrongPassword5()
    {
        loginService.login("homer", Helper.buildString('`', 10));
    }
    // one ascii symbol higher as "z"
    @Test(expected = IllegalArgumentException.class)
    public void testWrongPassword6()
    {
        loginService.login("homer", Helper.buildString('{', 10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWrongPassword7()
    {
        loginService.login("homer", Helper.buildString('0', 9));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWrongPassword8()
    {
        loginService.login("homer", Helper.buildString('9', 9));
    }
    // testing if big passwords are also accepted
    @Test
    public void testWrongPassword9()
    {
        Assert.assertFalse(loginService.login("homer", Helper.buildString('9', 99)));
    }
    @Test
    public void testWrongPassword10()
    {
        Assert.assertFalse(loginService.login("homer", Helper.buildString('z', 99)));
    }
    @Test
    public void testWrongPassword11()
    {
        Assert.assertFalse(loginService.login("homer", Helper.buildString('a', 99)));
    }
    @Test
    public void testWrongPassword12()
    {
        Assert.assertFalse(loginService.login("homer", Helper.buildString('0', 99)));
    }
}
