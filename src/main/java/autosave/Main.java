package autosave;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class Main extends PluginBase {

    public void onEnable() {
        saveDefaultConfig();
        Config config = getConfig();
        getServer().getScheduler().scheduleDelayedRepeatingTask(this, new SaveTask(config.getBoolean("async")), config.getInt("save-every-x-minutes") * 1200, config.getInt("save-every-x-minutes") * 1200, config.getBoolean("async"));
    }
}
