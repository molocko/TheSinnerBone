package io.BM;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;


public class onPlayerRespawn implements Listener {

    @EventHandler
    public void PlayerRespawn(PlayerRespawnEvent event) {
        Player p = event.getPlayer();
        if (Main.getInstance().getConfig().getBoolean("turn")) {
            Main.getInstance().log.info("Respawn event");
            if (p.hasMetadata("preDeathEffects")) {
                if(p.getMetadata("preDeathEffects").get(0).asBoolean()) {
                    Main.getInstance().log.info("UNLUCK");
                    //funcs.timerStart();
                    Location safeLocation = funcs.safeLocationGen(event.getPlayer());
                    //p.sendMessage(String.valueOf(funcs.timerStop()));

                    if (safeLocation != null) {
                        event.setRespawnLocation(safeLocation);
                    }
                }

            }
            return;
        }



    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player p = event.getEntity();
        // Сохраняем эффекты в метаданные
        p.setMetadata("preDeathEffects", new FixedMetadataValue(Main.getInstance(), p.hasPotionEffect(PotionEffectType.UNLUCK)));
        Main.getInstance().log.info("HAS");
    }
}
