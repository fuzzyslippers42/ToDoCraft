package org.fuzzyslippers.ToDoCraft.commands;

import java.io.File;
import java.io.IOException;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TaskAddCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		String foldername = "ToDoCraft";
		File textfolder = new File(foldername);
		boolean folderexists = textfolder.exists();
		String sendername = sender.getName();
		File currentfile = new File(foldername + "/" + sendername +"todolist.txt");
		boolean exists = currentfile.exists();
		String priority = "";
		
		if(args[0].equalsIgnoreCase("high")){
			priority = "High";
		}
		else if (args[0].equalsIgnoreCase("normal")){
			priority = "Normal";
		}
		else if (args[0].equalsIgnoreCase("low")){
			priority = "Low";
		}
		else{
			sender.sendMessage("Your priority was not high, normal, or low!");
			return false;
		}
		String tasktoadd = MiscFunctions.argsToString(args, 1, " ");
		String task = priority + ": " + tasktoadd + "\n";
		sendername = sender.getName();
		MiscFunctions.writeTasks(task, currentfile);
		if(!folderexists){
			textfolder.mkdir();
		}
		if(!exists){
			MiscFunctions.report(sendername+" did not have a file, we created one");
			try {
				currentfile.createNewFile();
				sender.sendMessage("We created a file for you!");
				MiscFunctions.report("File created for" + sendername);
			} catch(IOException e){
				MiscFunctions.report("Invalid File Name!");
				return false;
			}
		
			}
		return true;
	}
}
