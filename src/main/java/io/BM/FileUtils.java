package io.BM;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    static File file;
    static FileConfiguration config;

    public static void setup() {
        file = new File(Main.getInstance().getDataFolder(), "locations.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);

        // Установка пустого списка locations по умолчанию, если он еще не существует
        if (!config.contains("locations")) {
            config.set("locations", new ArrayList<String>());
            saveConfig();
        }
    }



    public static void saveConfig() {
        try {
            config.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<Location> loadLocations() {
        List<Location> locations = new ArrayList<>();
        List<String> locationStrings = config.getStringList("locations");

        for (String locationString : locationStrings) {
            Location location = parseLocation(locationString);
            if (location != null) {
                locations.add(location);
            }
        }

        return locations;
    }

    private static Location parseLocation(String locationString) {
        String[] parts = locationString.split(";");
        if (parts.length != 3) {
            return null;
        }

        double x = Double.parseDouble(parts[0]);
        double y = Double.parseDouble(parts[1]);
        double z = Double.parseDouble(parts[2]);
        World world = Bukkit.getWorlds().get(1);
        if (world == null) {
            return null;
        }
        return new Location(world, x, y, z);
    }

    public static void saveLocationsToFile(List<Location> locations) {
        List<String> locationStrings = new ArrayList<>();
        for (Location location : locations) {
            String locationString =
                    location.getX() + ";" +
                    location.getY() + ";" +
                    location.getZ();
            locationStrings.add(locationString);
        }
        config.set("locations", locationStrings);
        saveConfig();
    }

}
