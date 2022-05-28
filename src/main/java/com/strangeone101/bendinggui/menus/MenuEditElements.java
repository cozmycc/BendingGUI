package com.strangeone101.bendinggui.menus;

import java.util.Arrays;
import java.util.List;

import com.projectkorra.projectkorra.event.PlayerChangeSubElementEvent;
import com.strangeone101.bendinggui.BendingBoard;
import com.strangeone101.bendinggui.LangBuilder;
import com.strangeone101.bendinggui.Util;
import com.strangeone101.bendinggui.api.ChooseSupport;
import com.strangeone101.bendinggui.api.ElementSupport;
import com.strangeone101.bendinggui.config.ConfigStandard;
import com.strangeone101.bendinggui.spirits.SpiritsSupport;
import me.xnuminousx.spirits.elements.SpiritElement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.Element;
import com.projectkorra.projectkorra.Element.SubElement;
import com.projectkorra.projectkorra.GeneralMethods;
import com.projectkorra.projectkorra.event.PlayerChangeElementEvent;
import com.projectkorra.projectkorra.event.PlayerChangeElementEvent.Result;
import com.strangeone101.bendinggui.BendingGUI;
import com.strangeone101.bendinggui.DynamicUpdater;
import com.strangeone101.bendinggui.MenuBase;
import com.strangeone101.bendinggui.MenuItem;
import com.strangeone101.bendinggui.RunnablePlayer;


public class MenuEditElements extends MenuBase 
{
	protected MenuBase prev;
	protected OfflinePlayer player;
	protected Player openPlayer;
	protected boolean dirty;
	
	public MenuEditElements(OfflinePlayer player, MenuBase previousMenu) 
	{
		super(new LangBuilder("Display.Edit.Title").yourOrPlayer(player, player).toString(), 3);
		this.prev = previousMenu;
		this.player = player;
	}

	/**Called to update menu*/
	public void update()
	{
		this.getInventory().clear();
		
		BendingPlayer p = BendingPlayer.getBendingPlayer(player);
		List<Element> list = Arrays.asList(new Element[] {Element.FIRE, Element.WATER, Element.CHI, Element.EARTH, Element.AIR});
		
		for (int i = 0; i < list.size(); i++) {
			this.addMenuItem(this.getBendingItem(list.get(i)), 9 + 2 + i);
		}
		this.addMenuItem(this.getBackItem(), 18);
		this.addMenuItem(this.getRemoveAllItem(), 26);

		for (Element customElement : BendingGUI.INSTANCE.getSupportedElements()) {
			ElementSupport support = BendingGUI.INSTANCE.getSupportedElement(customElement);
			if (support instanceof ChooseSupport) {
				this.addMenuItem(this.getBendingItem(support.getElement()), ((ChooseSupport) support).getChooseMenuIndex());
			}
		}
	}
	
	public MenuItem getRemoveAllItem()
	{
		final OfflinePlayer p = this.player;
		final MenuConfirm confirm = new MenuConfirm(this, new RunnablePlayer() {

			@Override
			public void run(Player player1) 
			{
				BendingPlayer bPlayer = BendingPlayer.getBendingPlayer(p);
				if (bPlayer == null) {
					player1.sendMessage(ChatColor.RED + new LangBuilder("Chat.Edit.Admin.Offline").player(p).toString());
					closeMenu(player1);
				}
				bPlayer.getElements().clear();
				bPlayer.getSubElements().clear();
				GeneralMethods.saveElements(bPlayer);
				GeneralMethods.saveSubElements(bPlayer);
				GeneralMethods.removeUnusableAbilities(p.getName());
				if (p instanceof Player) {
					Bukkit.getServer().getPluginManager().callEvent(new PlayerChangeElementEvent(player1, (Player)player, null, Result.REMOVE));

					if (player1 != p){
						//playerwhoclicked.sendMessage(ChatColor.YELLOW + player.getName() + " is no longer " + (element == Element.AIR || element == Element.EARTH ? "an " : "a ") + c + ChatColor.YELLOW + element.getName().toLowerCase() + element.getType().getBender() + "!");
						((Player)p).sendMessage(ChatColor.RED + new LangBuilder("Chat.Edit.RemoveAll.Self").player(player).toString());
					}
				}

				player1.sendMessage(ChatColor.RED + new LangBuilder("Chat.Edit.RemoveAll.Admin").player(player).plural(player.getName()).toString());

				DynamicUpdater.setPage(p.getPlayer(), 0);
				switchMenu(player1, prev);
			}
			
		}, new RunnablePlayer() {

			@Override
			public void run(Player player) 
			{
				switchMenu(player, getInstance());
			}
			
		}, /*Arrays.asList(new String[] {ChatColor.GRAY + "Are you sure you want to remove all",ChatColor.GRAY + player.getName() + "'s elements? This can't",ChatColor.GRAY + "be undone"}),
		Arrays.asList(new String[] {ChatColor.GRAY + "Return back to the element menu"})*/
				(context) -> context.yourOrPlayer(p, openPlayer).player(p).plural(p.getName()),
				"Edit.RemoveAll");
		
		MenuItem item = new MenuItem(ChatColor.RED + new LangBuilder("Display.Edit.RemoveAll.Title").toString(), Material.BARRIER)
		{
			@Override
			public void onClick(Player player) 
			{
				switchMenu(player, confirm);
			}
		};
		item.addDescription(ChatColor.GRAY + new LangBuilder("Display.Edit.RemoveAll.Lore").yourOrPlayer(player, openPlayer).plural(player.getName()).player(player).toString());
		return item;
	}
	
	public MenuEditElements getInstance()
	{
		return this;
	}
	
	public MenuItem getBendingItem(final Element element)
	{
		MenuItem item;
		final OfflinePlayer player = this.player;
		final ChatColor c = BendingGUI.getColor(element);
		String key = "Display.Edit.Element";
		item = new MenuItem( c + new LangBuilder(key + ".Title").element(element).toString(), this.getElementData(element)) {
			@Override
			public void onClick(Player playerwhoclicked) 
			{
				BendingPlayer p = BendingPlayer.getBendingPlayer(player);
				if (!p.hasElement(element))
				{
					if (playerwhoclicked.hasPermission("bending.admin.add"))
					{
						if (player instanceof Player)
							((Player)player).sendMessage(ChatColor.YELLOW + new LangBuilder("Chat.Edit.Add.Self").element(element).anOrA(element.getName()).toString());
							//((Player)player).sendMessage(ChatColor.YELLOW + "You are now " + (element == Element.AIR || element == Element.EARTH ? "an " : "a ") + c + element.getName().toLowerCase() + " " + element.getType().getBender() + ChatColor.YELLOW + "!");

						if (SpiritsSupport.isSpiritElement(element)) {
							SpiritsSupport.giveElement(element, p, playerwhoclicked, false);
						} else {
							Bukkit.getPluginManager().callEvent(new PlayerChangeElementEvent(playerwhoclicked, player.getPlayer(), element, Result.ADD));
							p.addElement(element);
						}
						
						for (SubElement sub : Element.getAllSubElements()) {
							if (sub.getParentElement() == element && p.hasSubElementPermission(sub)) {
								PlayerChangeSubElementEvent event = new PlayerChangeSubElementEvent(playerwhoclicked, player.getPlayer(), sub,
										PlayerChangeSubElementEvent.Result.ADD);
								Bukkit.getPluginManager().callEvent(event);
								p.addSubElement(sub);
							}
						}

						dirty = true;
						
						GeneralMethods.saveElements(p);
						GeneralMethods.saveSubElements(p);
						
						if (!playerwhoclicked.getName().equals(player.getName()))
							playerwhoclicked.sendMessage(ChatColor.YELLOW + new LangBuilder("Chat.Edit.Add.Admin").player(player).element(element).anOrA(element.getName()).toString());

						update();
					}
					else
					{
						playerwhoclicked.sendMessage(ChatColor.RED + new LangBuilder("Chat.Edit.NoPermission").player(player).toString());
						closeMenu(playerwhoclicked);
					}
				} else {
					if (player instanceof Player)
						((Player)player).sendMessage(ChatColor.YELLOW + new LangBuilder("Chat.Edit.Remove.Self").element(element).toString());

					if (SpiritsSupport.isSpiritElement(element)) {
						SpiritsSupport.removeElement(element, p, playerwhoclicked);
					} else {
						Bukkit.getPluginManager().callEvent(new PlayerChangeElementEvent((Player)player, (Player)player, element, Result.REMOVE));
						p.getElements().remove(element);
					}

					dirty = true;

					GeneralMethods.saveElements(p);
					GeneralMethods.removeUnusableAbilities(p.getName());
					BendingBoard.updateBoard((Player)player);

					if (!playerwhoclicked.getName().equals(player.getName()))
						playerwhoclicked.sendMessage(ChatColor.YELLOW + new LangBuilder("Chat.Edit.Remove.Admin").player(player).element(element).toString());
					update();
				}
	
				update();
			}
		};
		boolean b = BendingPlayer.getBendingPlayer(player).hasElement(element);
		String lore = new LangBuilder(key + ".Lore." + (b ? "Has" : "HasNot")).yourOrPlayer(player, openPlayer).anOrA(element.getName()).element(element).player(player).toString();

		item.setDescriptions(Util.lengthSplit(lore, 58));
		if (BendingPlayer.getBendingPlayer(player).hasElement(element)) {
			item.setEnchanted(true);
		}
		return item;
	}
	
	public MenuItem getBackItem()
	{
		String key = "Display.Edit.Back";
		MenuItem item = new MenuItem(ChatColor.YELLOW + new LangBuilder(key + ".Title").toString(), Material.ARROW) {
			@Override
			public void onClick(Player player) 
			{
				if (prev != null)
				{
					//The overview player skull won't update with new elements naturally, so we make new menu instead
					if (dirty && prev instanceof MenuBendingOptions) switchMenu(player, new MenuBendingOptions(((MenuBendingOptions) prev).thePlayer));
					else switchMenu(player, prev);
					return;
				}
				closeMenu(player);
			}
		};
		//String s1 = this.prev == null ? "Exit menu and return to your normal inventory" : "Return to the previous menu";
		item.addDescription(ChatColor.DARK_GRAY + new LangBuilder(key + ".Lore").toString());
		return item;
	}
	
	public Material getElementData(Element type)
	{
		if (type instanceof SubElement)
		{
			type = ((SubElement)type).getParentElement();
		}
		Material mat = ConfigStandard.getInstance().getChooseIconMaterial(type);
		return mat == null ? Material.REDSTONE : mat;
	}
	
	@Override
	public void openMenu(Player player) 
	{
		this.openPlayer = player;
		this.dirty = false;
		update();
		//this.title = new LangBuilder("Display.Edit.Title").yourOrPlayer(this.player, openPlayer).toString();
		super.openMenu(player);
	}
}
