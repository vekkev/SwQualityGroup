package org.se.lab;

public class Helper {

    private Helper() {}

    public static String buildString(char c, int count)
    {
        StringBuilder build = new StringBuilder(count);

        for ( int i=0; i<count; i++)
        {
            build.append(c);
        }

        return build.toString();
    }
}
