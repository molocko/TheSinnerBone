package io.BM;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class funcs {

    private static long startTime;

    public static void timerStart() {
        startTime = System.nanoTime();
    }

    public static long timerStop() {
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        return TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
    }
    public static final List<Material> BELOW_MATERIALS = Arrays.asList(
            Material.NETHERRACK, Material.NETHER_QUARTZ_ORE, Material.NETHER_GOLD_ORE, Material.SHROOMLIGHT,
            Material.CRIMSON_NYLIUM, Material.GRAVEL, Material.BONE_BLOCK, Material.BLACKSTONE,
            Material.BASALT, Material.GILDED_BLACKSTONE, Material.POLISHED_BLACKSTONE_BRICKS,
            Material.GLOWSTONE, Material.CRACKED_POLISHED_BLACKSTONE_BRICKS, Material.WARPED_WART_BLOCK,
            Material.NETHER_WART_BLOCK, Material.WARPED_NYLIUM, Material.NETHER_BRICKS,
            Material.SOUL_SAND, Material.SOUL_SOIL, Material.GOLD_BLOCK
    );

    public static final List<Material> MID_MATERIALS = Arrays.asList(
            Material.RED_MUSHROOM, Material.BROWN_MUSHROOM, Material.WARPED_FUNGUS, Material.CRIMSON_ROOTS,
            Material.CRIMSON_FUNGUS, Material.TWISTING_VINES, Material.WARPED_ROOTS, Material.NETHER_SPROUTS,
            Material.WEEPING_VINES, Material.AIR, Material.NETHER_WART
    );

    public static final List<Material> ABOVE_MATERIALS = Arrays.asList(
            Material.TWISTING_VINES, Material.WEEPING_VINES, Material.AIR
    );

    public static Location safeLocationGen(Player p) {
        World netherWorld = Bukkit.getWorlds().get(1);

        if (netherWorld == null) {
            p.sendMessage("The nether world does not exist!");
            return null;
        }

        Location safeLocation;
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        int x, y, z;
        Material belowMaterial, midMaterial, aboveMaterial;
        if (!Main.getInstance().locs.isEmpty()) {
            Location genCompSL = genCompSL(p);
            if(genCompSL != null) return genCompSL;



            int size = Main.getInstance().locs.size();
            int index = rand.nextInt(0, size);// 0 1 2 3 4 5 // 1 2 3 4 5 6
            Location loc = Main.getInstance().locs.get(index);
            if (checkSafeLocation(netherWorld.getBlockAt(loc.getBlockX(),loc.getBlockY()-1,loc.getBlockZ()).getType(), netherWorld.getBlockAt(loc.getBlockX(),loc.getBlockY(),loc.getBlockZ()).getType(), netherWorld.getBlockAt(loc.getBlockX(),loc.getBlockY()+1,loc.getBlockZ()).getType())){
                return loc;
            } else {
                Main.getInstance().locs.remove(index);
                return safeLocationGen(p);
            }


        } else {
            int coords = Main.getInstance().getConfig().getInt("coords");
            while (true) {
                x = rand.nextInt(-coords, coords + 1); // Чтобы избежать спавна только в одном квадранте
                z = rand.nextInt(-coords, coords + 1);  // Для высоты от 32 до 119
                y = rand.nextInt(32, 100 + 1);

                belowMaterial = netherWorld.getBlockAt(x, y - 1, z).getType(); /// ДЕЛАТЬ ПРОВЕРКУ ПОСЛЕ КАЖДОЙ СТРОКИ .,,,,, НЕЕЕЕЕЕТИИИИ
                midMaterial = netherWorld.getBlockAt(x, y, z).getType();        /// ЗАПИСЫВАТЬ УЖЕ ПРОВЕРЕННЫЕ КООРДИНАТЫ В СПИСОК, ЧТОБЫ НЕ ПОВТОРЯЛИСЬ ПРИ ПОВТОРЕ, ПОСЛЕ ЧЕГО ОЧИЩАТЬ СПИСОК
                aboveMaterial = netherWorld.getBlockAt(x, y + 1, z).getType();

                if(checkSafeLocation(belowMaterial, midMaterial, aboveMaterial)){
                    safeLocation = new Location(netherWorld, x + 0.5, y, z + 0.5);
                    Main.getInstance().locs.add(safeLocation);



                    return safeLocation;
                }




            }
        }
    }

    private static boolean checkSafeLocation(Material belowMaterial, Material midMaterial , Material aboveMaterial) {
        if (BELOW_MATERIALS.contains(belowMaterial)) {
            if (ABOVE_MATERIALS.contains(aboveMaterial)) {
                if (MID_MATERIALS.contains(midMaterial)) {
                    return true;

                }
            }

        }
        return false;

    }

    private static Location genCompSL(Player p){
        World netherWorld = Bukkit.getWorlds().get(1);

        if (netherWorld == null) {
            p.sendMessage("The nether world does not exist!");
            return null;
        }
        Location safeLocation;
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        int x, y, z;
        Material belowMaterial, midMaterial, aboveMaterial;
        int coords = Main.getInstance().getConfig().getInt("coords");
        int i = 0;
        while (i<Main.getInstance().getConfig().getInt("tryLoop")) {
            i++;
            x = rand.nextInt(-coords, coords + 1); // Чтобы избежать спавна только в одном квадранте
            z = rand.nextInt(-coords, coords + 1);  // Для высоты от 32 до 119
            y = rand.nextInt(32, 100 + 1);

            belowMaterial = netherWorld.getBlockAt(x, y - 1, z).getType(); /// ДЕЛАТЬ ПРОВЕРКУ ПОСЛЕ КАЖДОЙ СТРОКИ .,,,,, НЕЕЕЕЕЕТИИИИ
            midMaterial = netherWorld.getBlockAt(x, y, z).getType();        /// ЗАПИСЫВАТЬ УЖЕ ПРОВЕРЕННЫЕ КООРДИНАТЫ В СПИСОК, ЧТОБЫ НЕ ПОВТОРЯЛИСЬ ПРИ ПОВТОРЕ, ПОСЛЕ ЧЕГО ОЧИЩАТЬ СПИСОК
            aboveMaterial = netherWorld.getBlockAt(x, y + 1, z).getType();

            if(checkSafeLocation(belowMaterial, midMaterial, aboveMaterial)){
                safeLocation = new Location(netherWorld, x + 0.5, y, z + 0.5);
                Main.getInstance().locs.add(safeLocation);
                return safeLocation;
            }




        }
        return null;
    }

}
