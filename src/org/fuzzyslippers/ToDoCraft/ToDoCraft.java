package org.fuzzyslippers.ToDoCraft;

import org.bukkit.plugin.java.JavaPlugin;
import org.fuzzyslippers.ToDoCraft.commands.MiscFunctions;
import org.fuzzyslippers.ToDoCraft.commands.TaskAddCommand;
import org.fuzzyslippers.ToDoCraft.commands.TaskReadCommand;

//import java.io.BufferedWriter;
//import java.io.DataOutputStream;

public class ToDoCraft extends JavaPlugin {

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		MiscFunctions.report("Shutting Down!");
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		MiscFunctions.report("Starting Up!");
		getCommand("addtask").setExecutor(new TaskAddCommand());
		TaskReadCommand readtaskcommand = new TaskReadCommand();
		getCommand("readtask").setExecutor(readtaskcommand);
	}
	
}


