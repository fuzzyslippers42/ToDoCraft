package org.fuzzyslippers.ToDoCraft;

import java.io.File;
import java.util.logging.Logger;
//import java.util.logging.Logger.*;

import org.bukkit.plugin.java.JavaPlugin;
import org.fuzzyslippers.ToDoCraft.commands.MiscFunctions;
import org.fuzzyslippers.ToDoCraft.commands.TaskAddCommand;
import org.fuzzyslippers.ToDoCraft.commands.TaskMakeTaskTableCommand;
import org.fuzzyslippers.ToDoCraft.commands.TaskReadCommand;
//import lib.PatPeter.*;
import lib.PatPeter.SQLibrary.*;
import org.fuzzyslippers.ToDoCraft.commands.TaskFinishTask;
//import java.io.BufferedWriter;
//import java.io.DataOutputStream;

public class ToDoCraft extends JavaPlugin {
	public SQLite dbManage;
	static Logger log = Logger.getLogger("Minecraft");
	public String logPrefix = "[ToDoCraft]";
	public File pFolder = new File("plugins/ToDoCraft");
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		MiscFunctions.report("Shutting Down!");
		MiscFunctions.report("Closing DB!");
		MiscFunctions.disableDB();
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		try{
			MiscFunctions.enableDB();
		} catch (Exception e){
			MiscFunctions.report("Something went wrong with initializing the DataBase!");
		}
		MiscFunctions.report("Starting Up!");
		MiscFunctions.report("Enabling Commands!");
		getCommand("addtask").setExecutor(new TaskAddCommand());
		//TaskReadCommand readtaskcommand = new TaskReadCommand();
		getCommand("readtask").setExecutor(new TaskReadCommand());
		try{
			getCommand("maketasktable").setExecutor(new TaskMakeTaskTableCommand());
		} catch (Exception e) {
			MiscFunctions.report("Something went wrong adding command maketasktable! " + e.getStackTrace());
		}
                                     getCommand("finishtask").setExecutor(new TaskFinishTask());
		MiscFunctions.report("Starting database!");
		
		
	}
	
}


