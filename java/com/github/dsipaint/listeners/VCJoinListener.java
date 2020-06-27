package com.github.dsipaint.listeners;

import com.github.dsipaint.main.Main;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class VCJoinListener extends ListenerAdapter
{
  public void onGuildVoiceJoin(GuildVoiceJoinEvent e)
  {
    for(Member m : Main.unmutelist)
    {
      if(m.getGuild().equals(e.getGuild()) && m.getUser().equals(e.getMember().getUser()))
      {
        if(m.getVoiceState().isGuildMuted())
          m.mute(false).queue();
        
        Main.unmutelist.remove(m);
      } 
    } 

    for(Member m : Main.mutelist)
    {
      if(m.getGuild().equals(e.getGuild()) && m.getUser().equals(e.getMember().getUser()))
      {
        if(!m.getVoiceState().isGuildMuted())
          m.mute(true).queue();
        
        Main.mutelist.remove(m);
      } 
    } 
  }
}
