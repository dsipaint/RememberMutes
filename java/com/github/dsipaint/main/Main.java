package com.github.dsipaint.main;

import java.util.ArrayList;
import javax.security.auth.login.LoginException;
import com.github.dsipaint.listeners.CommandListener;
import com.github.dsipaint.listeners.StopListener;
import com.github.dsipaint.listeners.VCJoinListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Member;

public class Main
{
  static JDA jda;
  static final String PREFIX = "^";
  public static ArrayList<Member> unmutelist, mutelist;
  
  public static void main(String[] args)
  {
    try
    {
      jda = (new JDABuilder(AccountType.BOT)).setToken("").build();
    }
    catch (LoginException e)
    {
      e.printStackTrace();
    } 

    
    try
    {
      jda.awaitReady();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    } 
    
    unmutelist = new ArrayList<Member>();
    mutelist = new ArrayList<Member>();
    
    jda.addEventListener(new CommandListener());
    jda.addEventListener(new VCJoinListener());
    jda.addEventListener(new StopListener());
  }
}
