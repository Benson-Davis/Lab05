/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;

/**
 *
 * @author bdavi
 */
public class AccountService//should be a static class?
{
    //no constructor provided means default no-arg constructor is implicitly provided
    public User login(String username, String password)
    {
        if((username.equals("abe") || username.equals("barb")) && password.equals("password"))
            return new User(username, null);
            
        return null;
    }            
}
