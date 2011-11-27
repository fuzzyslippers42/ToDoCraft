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
			String foldername = "ToDoCraft";
			MiscFunctions.report(foldername);
			String sendername = sender.getName();
			MiscFunctions.report(sendername);
			File currentfile = new File(foldername + "/" + sendername +"todolist.txt");
			MiscFunctions.readTasks(0, currentfile, sender);
			return true;
		}
		return true;
	}
}
