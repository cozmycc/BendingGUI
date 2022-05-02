package com.strangeone101.bendinggui.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.projectkorra.projectkorra.ability.ComboAbility;
import com.projectkorra.projectkorra.ability.CoreAbility;
import com.strangeone101.bendinggui.BendingGUI;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigLanguage extends ConfigBase {
	
	private static ConfigLanguage INSTANCE;

	public ConfigLanguage() {
		super("language.yml");
		
		this.load();
		
		INSTANCE = this;
	}

	@Override
	public Map<String, Object> addDefaults() {
		Map<String, Object> defaults = new HashMap<String, Object>();
		defaults.put("Command.PlayerOnly", "&cSorry bud! Only players can run this command!");
		defaults.put("Command.NoPermission", "&cYou don't have permission to run this command!");
		defaults.put("Command.GiveItem", "&aRight click the compass to configure your bending!");

		defaults.put("Generic.Yourself", "yourself");
		defaults.put("Generic.You", "you");
		defaults.put("Generic.Your", "your");
		defaults.put("Generic.A", "a");
		defaults.put("Generic.An", "an");
		defaults.put("Generic.List1", "{item}");
		defaults.put("Generic.List2", "{item} and {item}");
		defaults.put("Generic.List3", "{item}, {item} and {item}");
		defaults.put("Generic.List4", "{item}, {item}, {item} and {item}");

		defaults.put("Display.Choose.Title", "Please select an element!");
		defaults.put("Display.Choose.Back", "Return to Menu");
		defaults.put("Display.Choose.NoPerm", "You don't have permission to choose this element!");
		defaults.put("Display.Choose.PermRemoved.Self", "You cannot choose an element because your bending has been permanently removed!");
		defaults.put("Display.Choose.PermRemoved.Admin", "This player has had their bending permanently removed!");
		defaults.put("Display.Choose.Confirm.Success", "You are now {a} {element}{bender}!");
		defaults.put("Display.Choose.Confirm.Success.Admin", "{player} is now {a} {element}{bender}!");
		defaults.put("Display.Choose.Confirm.Title", "Choose {element}?");
		defaults.put("Display.Choose.Confirm.Yes.Title", "YES");
		defaults.put("Display.Choose.Confirm.Yes.Lore", "Are you sure you want to choose {element}? This cannot be changed!");
		defaults.put("Display.Choose.Confirm.No.Title", "NO");
		defaults.put("Display.Choose.Confirm.No.Lore", "Return to the previous menu");
		defaults.put("Display.Choose.Fire.Title", "Choose {ELEMENT}");
		defaults.put("Display.Choose.Fire.Lore", "Firebenders can create fire with their bare fists. "
				+ "They are more prone to fire based damage and in some cases are completely fire resistant. "
				+ "Some skilled firebenders can even create lightning, making them very dangerous.");
		defaults.put("Display.Choose.Water.Title", "Choose {ELEMENT}");
		defaults.put("Display.Choose.Water.Lore", "Waterbenders can manipulate anything with water in them, "
				+ "including ice, plants and of course, water. They can freeze and thaw ice at will, and can "
				+ "also swim extremely fast in water.");
		defaults.put("Display.Choose.Earth.Title", "Choose {ELEMENT}");
		defaults.put("Display.Choose.Earth.Lore", "Earthbenders can manipulate almost anything natrual from "
				+ "the earth. Earthebenders take no fall damage while landing on blocks they can bend and some"
				+ " skilled benders can even bend sand, metal or lava!");
		defaults.put("Display.Choose.Air.Title", "Choose {ELEMENT}");
		defaults.put("Display.Choose.Air.Lore", "Airbenders can manipulate air at will, making them extremely "
				+ "fast and agile and have a powerful connection with spirits. They can also jump higher, run "
				+ "faster and they take no fall damage when they hit the ground.");
		defaults.put("Display.Choose.Chi.Title", "Choose &e&lCHIBLOCKER");
		defaults.put("Display.Choose.Chi.Lore", "Chiblocking isn't stricly an element but it is a form of art "
				+ "that makes the user faster and more agile than other benders. Chiblockers can paralyze other "
				+ "benders, take their bending away and can fight extremely well.");
		
		defaults.put("Display.Edit.Title", "Change Elements");
		defaults.put("Display.Edit.Title.Admin", "Edit {player}'{s} Elements");
		defaults.put("Display.Edit.Element.Title", "{element}");
		defaults.put("Display.Edit.Element.Lore.Has", "This player is already a {element}{bender}!");
		defaults.put("Display.Edit.Element.Lore.HasNot", "Click to make {player|yourself} {a} {element}{bender}!");
		defaults.put("Display.Edit.Back.Title", "Back");
		defaults.put("Display.Edit.Back.Lore", "Return to the previous menu");
		defaults.put("Display.Edit.Add.Success.Self", "You are now {a} {element}{bender}!");
		defaults.put("Display.Edit.Add.Success.Admin", "{player} is now {a} {element}{bender}!");
		defaults.put("Display.Edit.Remove.Success.Self", "Your {element}{bending} has been removed!");
		defaults.put("Display.Edit.Remove.Success.Admin", "{player} is no longer {a} {element}{bender}!");
		defaults.put("Display.Edit.RemoveAll.Title", "Remove All Elements");
		defaults.put("Display.Edit.RemoveAll.Lore", "This will remove all {player|your} existing elements");
		defaults.put("Display.Edit.RemoveAll", "");
		defaults.put("Display.Edit.RemoveAll.Confirm.Title", "Are you sure?");
		defaults.put("Display.Edit.RemoveAll.Confirm.Yes.Title", "YES");
		defaults.put("Display.Edit.RemoveAll.Confirm.Yes.Lore", "Are you sure you want to remove all {player|your} elements?");
		defaults.put("Display.Edit.RemoveAll.Confirm.No.Title", "NO");
		defaults.put("Display.Edit.RemoveAll.Confirm.No.Lore", "Return to the element menu");
		
		defaults.put("Display.Main.Title", "Bending Options");
		defaults.put("Display.Main.Items.Info.On.Title", "&eMove Info Tool &7(On)");
		defaults.put("Display.Main.Items.Info.Off.Title", "&eMove Info Tool &7(Off)");
		defaults.put("Display.Main.Items.Info.On.Lore", "&7When toggled on, click on an ability for more information.\\nClick to turn off again");
		defaults.put("Display.Main.Items.Info.Off.Lore", "&7When toggled on, click on an ability for more information.\\nClick to turn on");
		defaults.put("Display.Main.Items.Info.AbilityLore", "&e&lCLICK FOR MORE INFO\\n&r&7Click to display more infomation about this move!");
		defaults.put("Display.Main.Items.Remove.AbilityLore", "&c&lTOGGLE THE REMOVAL TOOL BEFORE\\nREBINDING!\\n&r&7You must turn off the unbind tool before you\\ncan rebind moves again");
		defaults.put("Display.Main.Items.Bind.AbilityLore", "&a&lCURRENTLY SELECTED\\n&r&7Click a slot to bind to this move to!");
		defaults.put("Display.Main.Items.Edit.Title", "&eAdd/Remove Elements");
		defaults.put("Display.Main.Items.Edit.Lore", "&7Edit the elements {player|you} can bend");
		defaults.put("Display.Main.Items.Change.Title", "&eChange Element");
		defaults.put("Display.Main.Items.Change.Lore", "&7Change your main bending element");
		defaults.put("Display.Main.Items.Page.Next.Title", "&eNext Page &7(&e{current}&7/&e{max}&7)");
		defaults.put("Display.Main.Items.Page.Next.Lore", "&7Click to go to the next page of moves");
		defaults.put("Display.Main.Items.Page.Previous.Title", "&ePrevious Page &7(&e{current}&7/&e{max}&7)");
		defaults.put("Display.Main.Items.Page.Previous.Lore", "&7Click to go to the previous page of moves");
		defaults.put("Display.Main.Items.Combos.Title", "&eView Combos");
		defaults.put("Display.Main.Items.Combos.Lore", "&7View the available combos");
		defaults.put("Display.Main.Items.ComboAbility.Title", "{abilitycolor}{ability} (Combo)");
		defaults.put("Display.Main.Items.Toggle.On.Title", "&cDisable Bending");
		defaults.put("Display.Main.Items.Toggle.Off.Title", "&aEnable Bending");
		defaults.put("Display.Main.Items.Toggle.On.Lore", "&7Click to disable your bending");
		defaults.put("Display.Main.Items.Toggle.Off.Lore", "&7Click to re-enable your bending");
		defaults.put("Display.Main.Items.Board.On.Title", "&aToggle BendingBoard &7(ACTIVE)");
		defaults.put("Display.Main.Items.Board.Off.Title", "&cToggle BendingBoard &7(INACTIVE)");
		defaults.put("Display.Main.Items.Board.On.Lore", "&7Click to toggle the bending board");
		defaults.put("Display.Main.Items.Board.Off.Lore", "&7Click to toggle the bending board");
		defaults.put("Display.Main.Items.Overview.Title.Self", "&eYour Bending");
		defaults.put("Display.Main.Items.Overview.Title.Others", "&e{player}'{s} Bending");
		defaults.put("Display.Main.Items.Overview.Lore.Who", "&e&lClick to view other players bending");
		defaults.put("Display.Main.Items.Overview.Lore.AdminWho", "&e&lClick to view and edit other players bending");
		defaults.put("Display.Main.Items.Overview.Lore.AvatarSelf", "&5You are the avatar!");
		defaults.put("Display.Main.Items.Overview.Lore.Avatar", "&5They are the avatar!");
		defaults.put("Display.Main.Items.Overview.Lore.ElementList", "(Can {list})");
		defaults.put("Display.Main.Items.Overview.Element.Air", "&7Airbender");
		defaults.put("Display.Main.Items.Overview.Element.Earth", "&aEarthbender");
		defaults.put("Display.Main.Items.Overview.Element.Water", "&9Waterbender");
		defaults.put("Display.Main.Items.Overview.Element.Fire", "&cFirebender");
		defaults.put("Display.Main.Items.Overview.Element.Chi", "&6Chiblocker");
		defaults.put("Display.Main.Items.Overview.Element.Flight", "Fly");
		defaults.put("Display.Main.Items.Overview.Element.SpiritualProjection", "Spiritually Project");
		defaults.put("Display.Main.Items.Overview.Element.Sand", "Sandbend");
		defaults.put("Display.Main.Items.Overview.Element.Metal", "Metalbend");
		defaults.put("Display.Main.Items.Overview.Element.Lava", "Lavabend");
		defaults.put("Display.Main.Items.Overview.Element.Lightning", "use Lightning");
		defaults.put("Display.Main.Items.Overview.Element.Combustion", "Combust");
		defaults.put("Display.Main.Items.Overview.Element.BlueFire", "use Blue Fire");
		defaults.put("Display.Main.Items.Overview.Element.Blood", "Bloodbend");
		defaults.put("Display.Main.Items.Overview.Element.Plant", "Plantbend");
		defaults.put("Display.Main.Items.Overview.Element.Healing", "Heal");


		defaults.put("Display.Main.Items.Slot.Full.Title", "{abilitycolor}Slot {slot} &7({abilitycolor}{ability}&7)");
		defaults.put("Display.Main.Items.Slot.Full.Lore", "&7Currently bound: {abilitycolor}{ability}\\n\\n&7To bind a new move, click a move then click\\nthe slot you want to bind it to.");
		defaults.put("Display.Main.Items.Slot.Empty.Title", "&cSlot {slot} &7(Empty)");
		defaults.put("Display.Main.Items.Slot.Empty.Lore", "&7Nothing is currently bound to this slot!\\n\\nClick a move and click a slot to bind!");
		defaults.put("Display.Main.Items.Slot.Disabled.Multi", "&c&lYOU CANNOT EDIT YOUR BINDS RIGHT NOW!\\n&r&7You are using a multi-ability move and must stop\\nusing it before you can bind again!");
		defaults.put("Display.Main.Items.Slot.Disabled.Toggled", "&cBending is disabled!");
		defaults.put("Display.Main.Items.Slot.Disabled.ToggledLore", "&7Enable bending to use again!");

		defaults.put("Display.Errors.NoAbilName", "&4Error: &cMove doesn't exist! Please contact StrangeOne101 about this!");
		defaults.put("Display.Errors.SlotOutOfRange", "&cError: Slot binding out of range! Please contact StrangeOne101 about this!");
		defaults.put("Display.Errors.FailedToOpen", "&cAn error occurred while trying to open the bending interface. Please report this to your admin or the plugin developer!");
		defaults.put("Display.Errors.NoAbilityDescription", "&7[[This move doesn't have a description set! Bug your server owner about it!]]");
		defaults.put("Display.Errors.ClickEvent", "&cAn error occurred while processing the clickevent. Please report this to your admin or the plugin developer!");
		defaults.put("Display.Errors.CantEditNow", "&cYou cannot edit your binds right now!");

		defaults.put("Chat.Choose.CantChoose", "&cYou must have an element to modify your bending!");
		defaults.put("Chat.Choose.ChooseNow", "&aYou aren't a bender yet! Please choose an element!");
		defaults.put("Chat.Edit.Admin.NoPermission", "&aYou don't have permission to edit this player's bending!");
		defaults.put("Chat.Board.Offline", "&aCan't toggle an offline player's bending board.");
		defaults.put("Chat.Toggle.Admin.NoPermission", "&aYou don't have permission to toggle this player's bending!");
		defaults.put("Chat.Toggle.Admin.On", "&aYou toggled {player}'{s} bending on!");
		defaults.put("Chat.Toggle.Admin.Off", "&cYou toggled {player}'{s} bending off!");
		defaults.put("Chat.Toggle.Player.On", "&aYou have turned your bending back on.");
		defaults.put("Chat.Toggle.Player.Off", "&cYour bending has been toggled off. You will not be able to use most abilities until you toggle it back.");
		defaults.put("Chat.Toggle.NoPermission", "&aYou don't have permission to toggle your bending bending!");
		defaults.put("Chat.Combo.Help", "{abilitycolor}{ability} (Combo) -");
		defaults.put("Chat.Bind.Ability", "{abilitycolor}{ability} &ebound to slot {slot}!");
		defaults.put("Chat.Bind.Remove", "&cRemoved {abilitycolor}{ability}&c from slot {slot}!");
		defaults.put("Chat.Bind.RemoveAll", "&cRemoved all bound moves from slots!");

		defaults.put("Staff.Developer", "&5ProjectKorra Developer");
		defaults.put("Staff.Contributor", "&5ProjectKorra Contributor");
		defaults.put("Staff.Admin", "&4ProjectKorra Administrator");
		defaults.put("Staff.Mist", "&4ProjectKorra Founder");

		defaults.put("Abilities.AirBlast", "Releases a blast of air that pushing all mobs and items");
		defaults.put("Abilities.AirBubble", "Allows the user to keep a bubble of air around them while traveling underwater");
		defaults.put("Abilities.AcrobatStance", "Makes the users faster and stronger but uses more energy in the process");
		defaults.put("Abilities.AirBurst", "Creates a powerful gust of air that can blow away your enemies");
		defaults.put("Abilities.AirScooter", "Allows the user to ride a ball of air to scale across terrain fast");
		defaults.put("Abilities.AirSpout", "Allows the user to walk on a spout of air");
		defaults.put("Abilities.AirSuction", "Pulls all mobs and items towards the the user");
		defaults.put("Abilities.AirSwipe", "Releases a wider gust of air, pushing mobs and items");
		defaults.put("Abilities.AirShield", "Shield yourself from everything using air");
		defaults.put("Abilities.Flight", "Allows the user to fly by holding sneak (SHIFT)");
		defaults.put("Abilities.Suffocate", "Bends the air right out of another player's lungs");
		defaults.put("Abilities.Tornado", "Creates a tornado of air that will misplace other users");	
		
		defaults.put("Abilities.Bloodbending", "Allows the user to manipulate other players and mobs with their bending");
		defaults.put("Abilities.HealingWaters", "Allows the user to heal with water");	
		defaults.put("Abilities.IceBlast", "Blasts a chunk of ice towards your target");	
		defaults.put("Abilities.IceSpike", "Pulls a spike of ice up from bellow your enemy");	
		defaults.put("Abilities.OctopusForm", "Creates a octopus of water around the user");	
		defaults.put("Abilities.PhaseChange", "Allows the user to freeze and melt water");
		defaults.put("Abilities.Surge", "Creates a wave or a shield of water and ice");	
		defaults.put("Abilities.Torrent", "Creates a ring of water around the user which can be used to freeze targets or push them away");	
		defaults.put("Abilities.WaterArms", "Allows the user to use water to create arms with lots of different abilities");
		defaults.put("Abilities.WaterBubble", "Allows the user to travel underwater with a bubble of air around them");
		defaults.put("Abilities.WaterManipulation", "Allows the user to fire water at a target");
		defaults.put("Abilities.WaterSpout", "Allows the user to stand on a spout of water");
		
		defaults.put("Abilities.Blaze", "Releases a powerful ring of fire around you");
		defaults.put("Abilities.Combustion", "Creates a fire-like projectile with their the user's mind");
		defaults.put("Abilities.FireBlast", "Blasts a ball of fire towards your enemy");	
		defaults.put("Abilities.FireBurst", "Sets fire to everything around you");	
		defaults.put("Abilities.FireJet", "Allows the user to fly for short distances with fire");	
		defaults.put("Abilities.FireShield", "Allows the user to create a shield of fire in front of them");	
		defaults.put("Abilities.HeatControl", "Allows the user to put out fire and not burn");	
		defaults.put("Abilities.Illumination", "Allows the bender to see by holding a flame");	
		defaults.put("Abilities.Lightning", "Allows the user to release a strike of lightning");
		
		defaults.put("Abilities.Catapult", "Allows the user to catapult themselves through the air by launching themselves up from the earth");
		defaults.put("Abilities.Collapse", "Collapses or pulls down the earth");
		defaults.put("Abilities.EarthArmor", "Uses earth as armor for short periods of time");
		defaults.put("Abilities.EarthBlast", "Blasts a chunk of earth wherever the user wants it to go");
		defaults.put("Abilities.EarthGrab", "Allows the user to trap other mobs and players in earth");
		defaults.put("Abilities.EarthSmash", "Allows the user to grab a huge chunk of earth and throw it");
		defaults.put("Abilities.EarthTunnel", "Allows the user to tunnel through the earth");	
		defaults.put("Abilities.RaiseEarth", "Creates walls or columns of earth in front of the user");
		defaults.put("Abilities.SandSpout", "Creates a spout of sand for the user to stand on while blinding users bellow");
		defaults.put("Abilities.Shockwave", "Releases a powerful shockwave of earth that sends targets flying");
		defaults.put("Abilities.Tremorsense", "Allows the user to see nearby airpockets (caves)");	
		
		defaults.put("Abilities.Extraction", "Allows the user to extract metals directly from the ore");
		defaults.put("Abilities.LavaFlow", "Turns earth into a pool or lava or creates a ring of lava around the user");	
		defaults.put("Abilities.MetalClips", "Allows the user to fire slices of metal at a target and capture them");	
		
		defaults.put("Abilities.HighJump", "Makes the user jump high in the air");	
		defaults.put("Abilities.Paralyze", "Allows the user to paralyze other benders and block their bending");	
		defaults.put("Abilities.QuickStrike", "Allows the user to attack quickly with a chance to chi block the target");	
		defaults.put("Abilities.RapidPunch", "Allows the user to attack faster while dealing more damage");	
		defaults.put("Abilities.Smokescreen", "Releases smoke and blinds all nearby players");	
		defaults.put("Abilities.SwiftKick", "Damages the target with a high chance of blocking their chi, if the user is in the air");	
		defaults.put("Abilities.WarriorStance", "Makes the user's attacks more powerful but also makes the user more vulnerable");
		
		defaults.put("Abilities.AvatarState", "Users in the Avatar State are much more powerful than normal benders. Their bending power is multiplied heavily and they take far less damage from attacks.");
		
		
		defaults.put("Abilities.AirBlade", "Creates a powerful blade of air that damages mobs and players");
		defaults.put("Abilities.AirBreath", "Releases a powerful breath of air that knocks back your target");
		defaults.put("Abilities.AirGlide", "Allows the user to glide down safely instead of falling");
		defaults.put("Abilities.AirPunch", "Allows the user to punch in rapid succession with blasts of air");
		defaults.put("Abilities.Meditate", "Allows the user to become stronger for short periods of time after meditating");
		defaults.put("Abilities.SonicBlast", "Creates an ear-piecing sonicblast that does high damage to other mobs and players");
		defaults.put("Abilities.FartBlast", "Allows the user to stink other players out by farting on them");
		
		defaults.put("Abilities.EarthKick", "Allows the user to kick the earth and hurl chunks at their opponent");
		defaults.put("Abilities.EarthLine", "Creates a line of risen earth that inflicts damage on all mobs and players that it hits");
		defaults.put("Abilities.EarthShard", "Allows the user to pickup multiple chunks of earth and hurl them towards their target");
		defaults.put("Abilities.EarthSurf", "Allows the user to ride on earth to scale the terrain fast");
		defaults.put("Abilities.EarthPillar", "Pulls a pillar of earth out in whatever direction you look");
		defaults.put("Abilities.MudSurge", "Hurls mud towards a target");
		defaults.put("Abilities.SandBlast", "Blasts sand towards an enemy, temporarily blinding them");
		defaults.put("Abilities.SandShift", "Allows the user to change sandstone without the need for crafting it");
		defaults.put("Abilities.StatePhase", "Allows the bender to create sand from earth and vise versa");
		defaults.put("Abilities.MetalFragments", "Allows the bender to shoot fragments of metal towards a target");
		defaults.put("Abilities.MetalShred", "Allows the user to shred a metal wall to gain access through it");
		defaults.put("Abilities.MetalHook", "Allows the bender to use metalbending to hook or grapple onto a surface and pull themselves in");
		defaults.put("Abilities.MagnetShield", "Repels all metal objects hurling towards the user");
		defaults.put("Abilities.LavaFlux", "Creates a wave of lava that can be hurled towards a target");
		defaults.put("Abilities.LavaDisc", "Melts a block of earth into a disk of lava that can be thrown");
		defaults.put("Abilities.Fissure", "Creates a line of lava that can swallow up mobs");
		defaults.put("Abilities.LavaThrow", "Allows the user to hurl waves of lava at a target");
		
		defaults.put("Abilities.FireBall", "Creates a fireball that can be cast towards a user");
		defaults.put("Abilities.FireBreath", "Allows the user to breathe a powerful breath of fire");
		defaults.put("Abilities.FirePunch", "Allows the user to damage and set fire to their enemy with just one punch");
		defaults.put("Abilities.FireComet", "Charge up the power of an entire comet to throw towards your enemies");
		defaults.put("Abilities.FireShots", "Allows the user to cast multiple and short fireballs towards a target");
		defaults.put("Abilities.WallOfFire", "Creates wall of fire that blocks all incoming projectiles and mobs");
		defaults.put("Abilities.Discharge", "Creates a powerful bolt of electricity to fry your targets");
		defaults.put("Abilities.LightningBurst", "Allows the user to charge lightning and release it in all directions at once");
		
		defaults.put("Abilities.Maelstrom", "Creates a whirlpool that sucks all mobs and players into it");
		defaults.put("Abilities.Drain", "Fill up all bottles in your inventory from the water in plants around you!");
		defaults.put("Abilities.WakeFishing", "Allows the user to use waterbending to fish");
		defaults.put("Abilities.WaterGimbal", "Creates wall of fire that blocks all incoming projectiles and mobs");
		defaults.put("Abilities.PlantDrain", "Drains all nearby plants of water to create water for waterbending");
		defaults.put("Abilities.PlantWhip", "Creates a vine of leaves that can quickly whip a target");
		defaults.put("Abilities.PlantArmor", "Allows the user to create basic armor for themselves with leaves");
		defaults.put("Abilities.PlantBlast", "Allows the user to blast quick, plant projectiles at their target");
		defaults.put("Abilities.IceClaws", "Creates ice on your hand that can damage and slow your target");
		defaults.put("Abilities.IceWall", "Creates a wall of ice in front of the user");
		defaults.put("Abilities.IceStream", "Creates an stream-like projectile that freezes and slows targets on impact");
		defaults.put("Abilities.FrostBreath", "Allows the user to freeze their breath, damaging and slowing their targets");
		defaults.put("Abilities.BloodPuppet", "Allows the manipulation of mobs and players to make them damage each other");
		
		defaults.put("Abilities.DaggerThrow", "Allows the user to rapidfire arrows towards a target");
		defaults.put("Abilities.Backstab", "Hit the user in their back to block their chi and deal a lot of damage");
		defaults.put("Abilities.WallRun", "Click rapidly to run up walls");

		defaults.put("Abilities.SpiritBeam", "Releases a powerful blast as the spirit of the avatar. The user must be in the AvatarState to use this move.");
		defaults.put("Abilities.ElementSphere", "Creates a sphere of all the elements around the user, allowing them to use all four at once");
		
		defaults.put("Abilities.LoonyBlast", "Use Loonergy to blast away enemies with extreme power!");
		defaults.put("Abilities.ToonShield", "Shield yourself from any attack with the power of Loonergy!");
		defaults.put("Abilities.BanBlaze", "Charge up a deadly admin-blast that 'bans' any user it hits!");
		defaults.put("Abilities.OwnerState", "The avatar state, buffed with the power of an admin to the extreme!");

		defaults.put("Abilities.CactusBlast", "Fight in the desert by throwing cactus!");
		defaults.put("Abilities.Sandstorm", "Allows the user to whip up a sandstorm!");
		defaults.put("Abilities.EarthBurrow", "Allows the user to burrow themselves in the ground");
		defaults.put("Abilities.BloodRip", "Rip the blood out of living things with bloodbending");

		defaults.put("Abilities.Combo-AirSlam", "Kick your enemy up in the air then kick them away!");
		defaults.put("Abilities.Combo-AirStream", "Creates a current of air that can be controlled by the player for a while");
		defaults.put("Abilities.Combo-AirSweep", "Create a sweeping current of air that can sweep enemies off their feet!");
		defaults.put("Abilities.Combo-Twister", "Create a twister to suck up and blow away your opponents!");
		defaults.put("Abilities.Combo-SwiftStream", "Pull all enemies along with you as you fly!");
		
		defaults.put("Abilities.Combo-Crevice", "Creates a crevice in the ground that can swallow players!");
		defaults.put("Abilities.Combo-MagmaBlast", "Fire balls of magma at your enemies!");
		defaults.put("Abilities.Combo-EarthDome", "Surround yourself (or others) in earth for protection");
		defaults.put("Abilities.Combo-EarthPillars", "Send players flying into the air by raising the earth bellow them suddenly");

		defaults.put("Abilities.Combo-FireKick", "Create a small arc of fire from your feet!");
		defaults.put("Abilities.Combo-FireSpin", "Create a huge ring of fire around you that does damage and huge knockback!");
		defaults.put("Abilities.Combo-FireWheel", "Hurl a spinning wheel of fire towards your enemies!");
		defaults.put("Abilities.Combo-JetBlaze", "Blaze it up as you launch from your powerful FireJet!");
		defaults.put("Abilities.Combo-JetBlast", "Launch with a boom as your launch with a powerful FireJet!");
		
		defaults.put("Abilities.Combo-WaterFlow", "Create a huge torrent of water that can sweep away your enemies!");
		defaults.put("Abilities.Combo-Maelstrom", "Suck everyone and everything up in a deep whirlpool!");
		defaults.put("Abilities.Combo-WaterGimbal", "Control two torrents of water at once!");
		defaults.put("Abilities.Combo-IceBullet", "Make a dome of ice and that can shoot shards of ice!");
		defaults.put("Abilities.Combo-IceWave", "Freeze your WaterWave to damage enemies that you hit!");
		
		defaults.put("Abilities.Combo-Immobilize", "Freeze your enemies for a few seconds!");
		
		return defaults;
	}
	
	public static ConfigLanguage getInstance() {
		return INSTANCE;
	}
	
	public void addDefaultDescription(CoreAbility ability, String description) {
		String name = ability.getName();
		if (ability instanceof ComboAbility) name = "Combo-" + name;
		
		addDefault("Abilities." + name, description);
	}

	@Override
	public void load() {
		if (!getFile().exists()) {
			File oldlang = new File(getFile().getParentFile(), "lang.yml");
			if (oldlang.exists()) {
				super.load();
				YamlConfiguration oldConfig = YamlConfiguration.loadConfiguration(oldlang);
				for (String key : oldConfig.getKeys(false)) {
					this.set("Abilities." + key, oldConfig.get(key));
				}
				try {
					BendingGUI.INSTANCE.getLogger().info("Imported old lang.yml data!");
					this.config.save(getFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		super.load();
	}
}
