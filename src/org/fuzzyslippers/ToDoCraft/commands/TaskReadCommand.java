package org.fuzzyslippers.ToDoCraft.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
//import org.fuzzyslippers.ToDoCraft.ToDoCraft;

public class TaskReadCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("readtask")){
			MiscFunctions.readDBTasks(sender);
			return true;
		}
		return true;
	}
}
