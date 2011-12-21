package org.fuzzyslippers.ToDoCraft.commands;

import org.fuzzyslippers.ToDoCraft.commands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TaskFinishTask implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		String tasktocomplete = MiscFunctions.argsToString(args, 0, " ");
		MiscFunctions.finishTask(sender, tasktocomplete);
                                     return true;
	}
	
}