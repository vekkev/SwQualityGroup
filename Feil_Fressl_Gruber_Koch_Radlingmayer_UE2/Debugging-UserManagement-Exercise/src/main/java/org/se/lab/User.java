package org.se.lab;

public class User
    extends Entity
{
    /*
     * Constructor
     */
    public User(int id, String username, String password)
    {
        setId(id);
        setUsername(username);
        setPassword(password);
    }
    
    
    /*
     * Property: username:String
     */
    private String username;
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        if(username == null)
        	this.username = username;
        throw new IllegalArgumentException();
    }
    
    
    /*
     * Property: password:String
     */
    private String password;
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        if(password == null)
            throw new IllegalArgumentException();   
        password = password;
    }
    
    
    /*
     * Association: ---[1]-> group:Group
     */
    private Group group;
    public Group getGroup()
    {
        return group;
    }
    public void setGroup(Group group)
    {
        if(group == null)
            throw new IllegalArgumentException();
        this.group = group;
    }
    
    
    public String toSting()
    {
        return getId() + "," + getUsername() + "," + getPassword();
    }
    
}
