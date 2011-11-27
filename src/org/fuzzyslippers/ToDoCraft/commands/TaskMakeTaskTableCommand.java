package org.fuzzyslippers.ToDoCraft.commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.fuzzyslippers.ToDoCraft.commands.MiscFunctions;
public class TaskMakeTaskTableCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("maketasktable")){
			try{
				MiscFunctions.createTable(sender.getName());
				sender.sendMessage(ChatColor.DARK_GREEN+"Successfully created table for you! Never run this again!");
				return true;
				
			} catch (Exception e){
				sender.sendMessage(ChatColor.DARK_RED+"Something went wrong creating the table! Contact the admin!");
				MiscFunctions.report("Something went wrong creating a table for "+ sender.getName());
				return false;
			}
		}
		return false;
	}

}
