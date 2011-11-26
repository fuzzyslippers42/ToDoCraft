package org.fuzzyslippers.ToDoCraft.commands;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Logger;

import org.bukkit.command.CommandSender;

public class MiscFunctions {
	static Logger log = Logger.getLogger("Minecraft");
	public static void report(String string){
		String newstring = "[ToDoCraft] " + string;
		log.info(newstring);
	}
	public static String argsToString(String[] args, int startingarg, String separator){
		String arraystring = "";
		for(int i = startingarg; i<args.length; i++){
			arraystring = arraystring + separator + args[i];
		}
		return arraystring;
	}
	Charset chars = Charset.forName("US-ASCII");
	public static void writeTasks(String task, File filename){
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename,true));
			out.write(task);
			out.close();
		} catch (IOException x) {
			report("IOError!");
		}
	}
	public static void readTasks(int linenumber, File file, CommandSender sender){
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String filecontents = in.toString();
			sender.sendMessage(filecontents);
			in.close();
		} catch (IOException e){
			report("IOError!");
		}
	}
}
