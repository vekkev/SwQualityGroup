package org.se.lab;

import java.util.List;

public class Group
    extends Entity
{
    /*
     * Constructor
     */
    public Group(int id, String name)
    {
        setId(id);
        setName(name);
    }
    
    
    /*
     * Property: name:String
     */
    private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        if(name == null)
            throw new IllegalArgumentException();
        this.name = name;
    }
    
    
    /*
     * Association: ---[*]-> users:User
     */
    private List<User> users;
    public void addUser(User user)
    {
        if(user == null)
            throw new IllegalArgumentException();
        users.add(user);
    }
    public List<User> getUsers()
    {
        return users;
    }
    
    
    public int getId()
    {
        return 0;
    }
}
