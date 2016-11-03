package com.strangeone101.bendinggui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.jedk1.jedcore.configuration.JedCoreConfig;

public class BendingBoard 
{
	public enum BBPlugin {
		
		JEDCORE, BE, NONE;
		
		public Plugin getPlugin() {
			if (this == BE) return Bukkit.getPluginManager().getPlugin("BendingEssentials");
			if (this == JEDCORE) return Bukkit.getPluginManager().getPlugin("JedCore");
			return null;
		}
	};
	
	private static BBPlugin boardPlugin = BBPlugin.NONE;
	
	/**Checks all BendingBoard plugins supported*/
	public static void checkPlugins() {
		if (BBPlugin.JEDCORE.getPlugin() != null) {
			if (JedCoreConfig.board.getConfig().getBoolean("Settings.Enabled")) {
				boardPlugin = BBPlugin.JEDCORE;
			}
		}
		
		if (boardPlugin == BBPlugin.NONE && BBPlugin.BE.getPlugin() != null) {
			if (me.loony.Config.ConfigWriter.defaultConfig.get().getBoolean("BendingBoard.Enabled")) {
				boardPlugin = BBPlugin.BE;
			}
		}
	}
	
	/**Returns whether the current board is toggled or not*/
	public static boolean isToggled(Player player) {
		if (boardPlugin == BBPlugin.BE) {
			return me.loony.Config.ConfigWriter.toggledPlayersFile.get().getBoolean(player.getName());
		} else if (boardPlugin == BBPlugin.JEDCORE) {
			return com.jedk1.jedcore.scoreboard.BendingBoard.disabled.contains(player.getUniqueId());
		}
		
		return false;
	}
	
	/**Toggle the current bending board, if it's in use.*/
	public static void toggle(Player player) {
		if (boardPlugin == BBPlugin.BE) {
			me.loony.Config.ConfigWriter.toggledPlayersFile.get().set(player.getName(), !me.loony.Config.ConfigWriter.toggledPlayersFile.get().getBoolean(player.getName()));
		} else if (boardPlugin == BBPlugin.JEDCORE) {
			com.jedk1.jedcore.scoreboard.BendingBoard.toggle(player);
		}
	}
	
	/**Returns whether there is a bendingboard that can be used on the server*/
	public static boolean isBoardEnabled() {
		return boardPlugin != BBPlugin.NONE && boardPlugin != null;
	}
}
