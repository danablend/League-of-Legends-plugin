package devs.danablend.ender.league;

import org.bukkit.plugin.java.JavaPlugin;

public class League extends JavaPlugin {
	
	public static League i;
	
	@Override
	public void onEnable() {
		i = this;
	}
	
}
