package io.BM;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class onPlayerKill implements Listener {

    @EventHandler
    public void PlayerKill(PlayerDeathEvent e){


        if(!(e.getEntity().getKiller() instanceof Player)) return;
        if (!Main.getInstance().getConfig().getBoolean("turn")) return;

        Player killer = e.getEntity().getKiller();
        killer.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK, PotionEffect.INFINITE_DURATION, 0, false, false));

    }
}
