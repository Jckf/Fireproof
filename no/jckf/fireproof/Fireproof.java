package no.jckf.fireproof;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Fireproof extends JavaPlugin implements Listener {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this,this);
	}

	public void onDisable() {

	}

	@EventHandler
	public void onBurn(BlockBurnEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onIgnite(BlockIgniteEvent event) {
		if (!event.getCause().equals(BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onSpread(BlockSpreadEvent event) {
		if (event.getSource().getType().equals(Material.FIRE)) {
			event.setCancelled(true);
		}
	}
}
