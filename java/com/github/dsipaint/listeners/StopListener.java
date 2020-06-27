package com.github.dsipaint.listeners;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class StopListener extends ListenerAdapter {
	
  public void onGuildMessageReceived(GuildMessageReceivedEvent e)
  {
    String msg = e.getMessage().getContentRaw();
    String[] args = msg.split(" ");

    
    if(CommandListener.isStaff(e.getMember()))
    {
      if(args[0].equalsIgnoreCase("^shutdown"))
      {
        e.getJDA().shutdownNow();
        System.exit(0);
      } 

      
      if(args[0].equalsIgnoreCase("^disable") && args[1].equalsIgnoreCase("remembermutes"))
      {
        e.getChannel().sendMessage("*Disabling al's remembermutes code...*").queue();
        e.getJDA().shutdown();
        System.exit(0);
      } 
    } 
  }
}
