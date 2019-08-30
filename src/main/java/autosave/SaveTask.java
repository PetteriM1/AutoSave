package autosave;

import cn.nukkit.Player;
import cn.nukkit.Server;

public class SaveTask extends Thread {

    private final boolean async;

    SaveTask(boolean asyncTask) {
        async = asyncTask;
        setName("PlayerDataAutoSaveTask");
    }

    public void run() {
        try {
            for (Player p : Server.getInstance().getOnlinePlayers().values()) {
                p.save(async);
            }
            Server.getInstance().getLogger().debug("Player data saved");
        } catch (Exception e) {
            Server.getInstance().getLogger().debug("Player data saving failed: ", e);
        }
    }
}
