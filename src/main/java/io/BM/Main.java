package io.BM;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    public List<Location> locs = new ArrayList<>();

    private static Main Instance;
    Logger log = getLogger();


    @Override
    public void onEnable() {
        log.info("TSB Enabled");
        log.info("Developed by BM");

        Instance = this;



        if (!getConfig().getBoolean("turn")) {
            log.severe("TSB is disabled in config file");
        }

        Objects.requireNonNull(getCommand("tsb")).setExecutor(new TSBCMD());
        getServer().getPluginManager().registerEvents(new onPlayerKill(), this);
        getServer().getPluginManager().registerEvents(new onPlayerRespawn(), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        FileUtils.setup();

        locs = FileUtils.loadLocations();
        //  #ДОБАВИТЬ ОТМЕНУ УДАЛЕНИЯ ЭФФЕКТА ПРИ МОЛОКЕ
        //  #ДОБАВИТЬ СПИСОК ВЫБОРА ПРИ ВВОДЕ TSB
        //  #СКРЫТНО ДОБАВИТЬ ПЯТНИЦУ
        //  #ДОБАВИТЬ КОНФИГ ЧАТА
        //  #ДОБАВИТЬ КОНФИГ УВЕДОМЛЕНИЯ С НАХОЖДЕНИЯ tryLoop
        //  #ДОБАВИТЬ ОТКЛЮЧЕНИЕ КОМАНД С КОНФИГА turn: false
        //  #ДОБАВИТЬ ПРОВЕРКУ НА КОМАНДЫ, ЕСЛИ ОТ КОНСОЛИ, ПРИСЫЛАТЬ НАЙДЕНЫЕ ЛОКАЦИИ ЕЙ И ОПКАМ
        //  #ДОБАВИТЬ В КФГ ПУНКТ С "УМНЫМ ПОИСКОМ", УМНЫЙ ПОИСК - ПОИСК КОГДА НА СЕРВЕРЕ НЕТ ИГРОКОВ, КОГДА ЕСТЬ - НЕ РОБИТ





    }

    @Override
    public void onDisable() {
        FileUtils.saveLocationsToFile(locs);
        TSBCMD.stopGenerator();
    }





    public static Main getInstance() {
        return Instance;
    }

}