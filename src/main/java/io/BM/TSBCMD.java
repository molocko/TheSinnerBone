package io.BM;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.ThreadLocalRandom;

public class TSBCMD implements CommandExecutor {
    private static Thread generatorThread;
    private static volatile boolean isStopped = true;

    //private int local_size = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.isOp()) {
            Player p = (Player)sender;
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            p.sendMessage(system.ar_prefix+ ChatColor.translateAlternateColorCodes('&',"&x&C&B&2&D&3&EЭ&x&C&D&2&E&3&Eт&x&C&F&3&0&3&Eа &x&D&1&3&1&3&Dк&x&D&3&3&3&3&Dо&x&D&5&3&4&3&Dм&x&D&7&3&6&3&Dа&x&D&9&3&7&3&Cн&x&D&B&3&9&3&Cд&x&D&E&3&A&3&Cа &x&E&0&3&C&3&Cн&x&E&2&3&D&3&Bе &x&E&4&3&F&3&Bд&x&E&6&4&0&3&Bо&x&E&8&4&2&3&Bс&x&E&A&4&3&3&Bт&x&E&C&4&5&3&Aу&x&E&E&4&6&3&Aп&x&E&E&4&6&3&Bн&x&E&B&4&3&3&Cа &x&E&8&4&0&3&Eп&x&E&5&3&D&3&Fр&x&E&2&3&A&4&1о&x&D&F&3&8&4&2с&x&D&C&3&5&4&4т&x&D&9&3&2&4&5ы&x&D&6&2&F&4&7м &x&D&3&2&C&4&8с&x&D&0&2&A&4&Aм&x&C&D&2&7&4&Bе&x&C&B&2&4&4&Dр&x&C&8&2&1&4&Eт&x&C&5&1&E&5&0н&x&C&2&1&C&5&1ы&x&B&F&1&9&5&3м&x&B&C&1&6&5&4!"));
            return true;
        }
        if (!Main.getInstance().getConfig().getBoolean("turn")) {
            Player p = (Player)sender;
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_HURT, 2, 1);
            p.sendMessage(system.ar_prefix+ ChatColor.translateAlternateColorCodes('&',"&x&C&B&2&D&3&EН&x&C&C&2&D&3&Eа &x&C&C&2&E&3&Eд&x&C&D&2&E&3&Eа&x&C&D&2&F&3&Eн&x&C&E&2&F&3&Eн&x&C&E&2&F&3&Eы&x&C&F&3&0&3&Eй &x&C&F&3&0&3&Eм&x&D&0&3&1&3&Dо&x&D&0&3&1&3&Dм&x&D&1&3&1&3&Dе&x&D&2&3&2&3&Dн&x&D&2&3&2&3&Dт &x&D&3&3&3&3&Dп&x&D&3&3&3&3&Dл&x&D&4&3&3&3&Dа&x&D&4&3&4&3&Dг&x&D&5&3&4&3&Dи&x&D&5&3&4&3&Dн &x&D&6&3&5&3&Dв&x&D&6&3&5&3&Dы&x&D&7&3&6&3&Dк&x&D&8&3&6&3&Dл&x&D&8&3&6&3&Dю&x&D&9&3&7&3&Cч&x&D&9&3&7&3&Cе&x&D&A&3&8&3&Cн&x&D&A&3&8&3&C, &x&D&B&3&8&3&Cс&x&D&B&3&9&3&Cо&x&D&C&3&9&3&Cв&x&D&C&3&A&3&Cе&x&D&D&3&A&3&Cт&x&D&E&3&A&3&Cу&x&D&E&3&B&3&Cе&x&D&F&3&B&3&Cм &x&D&F&3&C&3&Cв&x&E&0&3&C&3&Cк&x&E&0&3&C&3&Cл&x&E&1&3&D&3&Cю&x&E&1&3&D&3&Cч&x&E&2&3&E&3&Bи&x&E&2&3&E&3&Bт&x&E&3&3&E&3&Bь &x&E&4&3&F&3&Bе&x&E&4&3&F&3&Bг&x&E&5&4&0&3&Bо&x&E&5&4&0&3&B, &x&E&6&4&0&3&Bв&x&E&6&4&1&3&Bо &x&E&7&4&1&3&Bи&x&E&7&4&1&3&Bз&x&E&8&4&2&3&Bб&x&E&8&4&2&3&Bе&x&E&9&4&3&3&Bж&x&E&A&4&3&3&Bа&x&E&A&4&3&3&Bн&x&E&B&4&4&3&Aи&x&E&B&4&4&3&Aи &x&E&C&4&5&3&Aо&x&E&C&4&5&3&Aш&x&E&D&4&5&3&Aи&x&E&D&4&6&3&Aб&x&E&E&4&6&3&Aо&x&E&E&4&7&3&Aк&x&E&F&4&7&3&A!"));
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&x&0&0&F&F&E&0T&x&1&4&E&A&E&3h&x&2&7&D&5&E&5e&x&3&B&B&F&E&8S&x&4&E&A&A&E&Ai&x&6&2&9&5&E&Dn&x&7&6&8&0&F&0n&x&8&9&6&A&F&2e&x&9&D&5&5&F&5r&x&B&0&4&0&F&7B&x&C&4&2&B&F&Ao&x&D&7&1&5&F&Cn&x&E&B&0&0&F&Fe &6плагин &bV1\n&x&F&F&E&2&5&9Р&x&F&F&D&C&5&8а&x&F&F&D&6&5&7з&x&F&F&D&0&5&7р&x&F&F&C&A&5&6а&x&F&F&C&5&5&5б&x&F&F&B&F&5&4о&x&F&F&B&9&5&3т&x&F&F&B&3&5&3ч&x&F&F&A&D&5&2и&x&F&F&A&7&5&1к:\n&x&0&0&F&F&E&0T&x&0&D&F&1&E&2G&x&1&A&E&3&E&3: &x&2&7&D&5&E&5@&x&3&4&C&6&E&7y&x&4&1&B&8&E&9a&x&4&E&A&A&E&Ah&x&5&B&9&C&E&Co&x&6&8&8&E&E&Ec&x&7&6&8&0&F&0h&x&8&3&7&1&F&1u&x&9&0&6&3&F&3d&x&9&D&5&5&F&5o&x&A&A&4&7&F&6s&x&B&7&3&9&F&8h&x&C&4&2&B&F&Ai&x&D&1&1&C&F&Cr&x&D&E&0&E&F&Da&x&E&B&0&0&F&Fk&r\n&x&F&3&9&0&4&FD&x&E&C&8&B&5&8S&x&E&5&8&5&6&2: &x&D&E&8&0&6&Be&x&D&7&7&A&7&4c&x&D&0&7&5&7&Eh&x&C&9&7&0&8&7o&x&C&1&6&A&9&0_&x&B&A&6&5&9&Ae&x&B&3&5&F&A&3c&x&A&C&5&A&A&Ch&x&A&5&5&4&B&6p&x&9&E&4&F&B&Fo&r\n\n&x&9&5&8&A&F&FИ&x&9&B&8&A&F&Fс&x&A&0&8&B&F&Fп&x&A&6&8&B&F&Fо&x&A&B&8&B&F&Fл&x&B&1&8&C&F&Fь&x&B&6&8&C&F&Fз&x&B&C&8&C&F&Fо&x&C&1&8&C&F&Fв&x&C&7&8&D&F&Fа&x&C&C&8&D&F&Fн&x&D&2&8&D&F&Fи&x&D&7&8&E&F&Fе&x&D&D&8&E&F&F: &n/tsb help\n&x&1&4&8&8&C&CC&x&1&6&8&0&C&Ao&x&1&8&7&8&C&7m&x&1&A&7&1&C&5i&x&1&C&6&9&C&3n&x&1&E&6&1&C&0g &x&2&1&5&9&B&Es&x&2&3&5&1&B&Bo&x&2&5&4&9&B&9o&x&2&7&4&2&B&7n&x&2&9&3&A&B&4.&x&2&B&3&2&B&2.\n"));
            return true;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("gen")) {
                if (isStopped) {
                    isStopped = false;
                    generatorThread = new Thread(new GeneratorRunnable(sender));
                    generatorThread.start();
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (p.isOp()) {
                            p.sendMessage(system.pur_prefix+ChatColor.translateAlternateColorCodes('&',"&x&9&5&8&A&F&FГ&x&9&9&8&A&F&Fе&x&9&D&8&A&F&Fн&x&A&2&8&B&F&Fе&x&A&6&8&B&F&Fр&x&A&A&8&B&F&Fа&x&A&E&8&B&F&Fц&x&B&3&8&C&F&Fи&x&B&7&8&C&F&Fя &x&B&B&8&C&F&Fн&x&B&F&8&C&F&Fа&x&C&4&8&D&F&Fч&x&C&8&8&D&F&Fа&x&C&C&8&D&F&Fл&x&D&0&8&D&F&Fа&x&D&5&8&E&F&Fс&x&D&9&8&E&F&Fь&x&D&D&8&E&F&F!"));
                        }
                    }
                } else {
                    sender.sendMessage(system.pur_prefix+ChatColor.translateAlternateColorCodes('&',"&x&9&5&8&A&F&FГ&x&9&9&8&A&F&Fе&x&9&C&8&A&F&Fн&x&A&0&8&B&F&Fе&x&A&3&8&B&F&Fр&x&A&7&8&B&F&Fа&x&A&B&8&B&F&Fц&x&A&E&8&B&F&Fи&x&B&2&8&C&F&Fя &x&B&5&8&C&F&Fу&x&B&9&8&C&F&Fж&x&B&D&8&C&F&Fе &x&C&0&8&C&F&Fз&x&C&4&8&D&F&Fа&x&C&7&8&D&F&Fп&x&C&B&8&D&F&Fу&x&C&F&8&D&F&Fщ&x&D&2&8&D&F&Fе&x&D&6&8&E&F&Fн&x&D&9&8&E&F&Fа&x&D&D&8&E&F&F!"));
                }
            } else if (args[0].equalsIgnoreCase("stop")) {
                if (isStopped) {
                    sender.sendMessage(system.ar_prefix+ChatColor.translateAlternateColorCodes('&',"&x&C&B&2&D&3&EГ&x&C&D&2&E&3&Eе&x&C&E&2&F&3&Eн&x&D&0&3&0&3&Eе&x&D&1&3&1&3&Dр&x&D&3&3&2&3&Dа&x&D&4&3&4&3&Dц&x&D&6&3&5&3&Dи&x&D&7&3&6&3&Dя &x&D&9&3&7&3&Dу&x&D&A&3&8&3&Cж&x&D&C&3&9&3&Cе &x&D&D&3&A&3&Cб&x&D&F&3&B&3&Cы&x&E&0&3&C&3&Cл&x&E&2&3&D&3&Cа &x&E&3&3&E&3&Bв&x&E&5&3&F&3&Bы&x&E&6&4&1&3&Bк&x&E&8&4&2&3&Bл&x&E&9&4&3&3&Bю&x&E&B&4&4&3&Bч&x&E&C&4&5&3&Aе&x&E&E&4&6&3&Aн&x&E&F&4&7&3&Aа"));
                    return true;
                }
                isStopped = true;
                if (generatorThread != null) {
                    generatorThread.interrupt();
                }
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.isOp()) {
                        p.sendMessage(system.ar_prefix+ChatColor.translateAlternateColorCodes('&',"&x&C&B&2&D&3&EГ&x&C&F&3&0&3&Eе&x&D&3&3&3&3&Dн&x&D&7&3&6&3&Dе&x&D&B&3&9&3&Cр&x&D&F&3&B&3&Cа&x&E&3&3&E&3&Bц&x&E&7&4&1&3&Bи&x&E&B&4&4&3&Aя &x&E&F&4&7&3&Aп&x&E&9&4&2&3&Dр&x&E&4&3&C&4&0е&x&D&E&3&7&4&3к&x&D&8&3&1&4&6р&x&D&3&2&C&4&8а&x&C&D&2&6&4&Bщ&x&C&7&2&1&4&Eе&x&C&2&1&B&5&1н&x&B&C&1&6&5&4а"));
                    }
                }
            } else if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(system.pur_prefix+ChatColor.translateAlternateColorCodes('&',"&x&9&5&8&A&F&FИ&x&9&B&8&A&F&Fс&x&A&0&8&B&F&Fп&x&A&6&8&B&F&Fо&x&A&B&8&B&F&Fл&x&B&1&8&C&F&Fь&x&B&6&8&C&F&Fз&x&B&C&8&C&F&Fо&x&C&1&8&C&F&Fв&x&C&7&8&D&F&Fа&x&C&C&8&D&F&Fн&x&D&2&8&D&F&Fи&x&D&7&8&E&F&Fе&x&D&D&8&E&F&F:\n&r&x&D&D&8&E&F&F&n/tsb gen &r&x&D&D&8&E&F&F- генерация \"сейф\" зоны\n&r&x&D&D&8&E&F&F&n/tsb stop &r&x&D&D&8&E&F&F- остановка генерации"));
                return true;
            } else if (args[0].equalsIgnoreCase("check") || args[0].equalsIgnoreCase("info")) {
                int size = Main.getInstance().locs.size();
                //int size = local_size;
                if (!isStopped) {
                    sender.sendMessage(system.pur_prefix+ChatColor.translateAlternateColorCodes('&',"&x&3&4&9&4&E&6Н&x&3&C&9&2&E&3а&x&4&5&9&1&E&1й&x&4&D&8&F&D&Eд&x&5&5&8&D&D&Cе&x&5&E&8&B&D&9н&x&6&6&8&A&D&6о &x&6&F&8&8&D&4"+size+" &x&7&7&8&6&D&1л&x&7&F&8&4&C&Fо&x&8&8&8&3&C&Cк&x&9&0&8&1&C&Aа&x&9&8&7&F&C&7ц&x&A&1&7&E&C&4и&x&A&9&7&C&C&2й &x&B&1&7&A&B&F\n&x&B&A&7&8&B&DС&x&C&2&7&7&B&Aт&x&C&B&7&5&B&7а&x&D&3&7&3&B&5т&x&D&B&7&1&B&2у&x&E&4&7&0&B&0с&x&E&C&6&E&A&D: &nГенерирует!"));
                } else {
                    sender.sendMessage(system.pur_prefix+ChatColor.translateAlternateColorCodes('&',"&x&3&4&9&4&E&6Н&x&3&C&9&2&E&3а&x&4&5&9&1&E&1й&x&4&D&8&F&D&Eд&x&5&5&8&D&D&Cе&x&5&E&8&B&D&9н&x&6&6&8&A&D&6о &x&6&F&8&8&D&4"+size+" &x&7&7&8&6&D&1л&x&7&F&8&4&C&Fо&x&8&8&8&3&C&Cк&x&9&0&8&1&C&Aа&x&9&8&7&F&C&7ц&x&A&1&7&E&C&4и&x&A&9&7&C&C&2й &x&B&1&7&A&B&F\n&x&B&A&7&8&B&DС&x&C&2&7&7&B&Aт&x&C&B&7&5&B&7а&x&D&3&7&3&B&5т&x&D&B&7&1&B&2у&x&E&4&7&0&B&0с&x&E&C&6&E&A&D: &nНе генерирует!"));
                }
                return true;
            } else if (args[0].equalsIgnoreCase("clear")) {
                sender.sendMessage(system.yl_prefix+ChatColor.translateAlternateColorCodes('&',"&x&F&F&E&2&5&9Д&x&F&F&E&1&5&9л&x&F&F&D&F&5&9я &x&F&F&D&E&5&8п&x&F&F&D&D&5&8о&x&F&F&D&B&5&8д&x&F&F&D&A&5&8т&x&F&F&D&8&5&8в&x&F&F&D&7&5&8е&x&F&F&D&6&5&7р&x&F&F&D&4&5&7ж&x&F&F&D&3&5&7д&x&F&F&D&2&5&7е&x&F&F&D&0&5&7н&x&F&F&C&F&5&6и&x&F&F&C&D&5&6я &x&F&F&C&C&5&6у&x&F&F&C&B&5&6д&x&F&F&C&9&5&6а&x&F&F&C&8&5&5л&x&F&F&C&7&5&5е&x&F&F&C&5&5&5н&x&F&F&C&4&5&5и&x&F&F&C&2&5&5я &x&F&F&C&1&5&5в&x&F&F&C&0&5&4с&x&F&F&B&E&5&4е&x&F&F&B&D&5&4х &x&F&F&B&C&5&4с&x&F&F&B&A&5&4е&x&F&F&B&9&5&3й&x&F&F&B&7&5&3ф &x&F&F&B&6&5&3з&x&F&F&B&5&5&3о&x&F&F&B&3&5&3н&x&F&F&B&2&5&2, &x&F&F&B&1&5&2в&x&F&F&A&F&5&2в&x&F&F&A&E&5&2е&x&F&F&A&C&5&2д&x&F&F&A&B&5&2и&x&F&F&A&A&5&1т&x&F&F&A&8&5&1е&x&F&F&A&7&5&1: \n&r&x&D&D&8&E&F&F&n/tsb clear confirm"));
                return true;
            } else if (args[0].equalsIgnoreCase("reload")) {
                Main.getInstance().reloadConfig();
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.isOp()){
                        sender.sendMessage(system.yl_prefix+ChatColor.translateAlternateColorCodes('&',"&x&F&F&E&2&5&9П&x&F&F&D&F&5&9л&x&F&F&D&C&5&8а&x&F&F&D&A&5&8г&x&F&F&D&7&5&7и&x&F&F&D&4&5&7н &x&F&F&D&1&5&7б&x&F&F&C&E&5&6ы&x&F&F&C&C&5&6л &x&F&F&C&9&5&6п&x&F&F&C&6&5&5е&x&F&F&C&3&5&5р&x&F&F&C&0&5&4е&x&F&F&B&D&5&4з&x&F&F&B&B&5&4а&x&F&F&B&8&5&3г&x&F&F&B&5&5&3р&x&F&F&B&2&5&3у&x&F&F&A&F&5&2ж&x&F&F&A&D&5&2е&x&F&F&A&A&5&1н&x&F&F&A&7&5&1!"));
                    }
                }
                return true;
            }
        } else if (args.length == 2 && args[0].equalsIgnoreCase("clear") && args[1].equalsIgnoreCase("confirm")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.isOp()){
                    p.sendMessage(system.yl_prefix+ChatColor.translateAlternateColorCodes('&',"&x&F&F&E&2&5&9В&x&F&F&D&F&5&9с&x&F&F&D&D&5&8е &x&F&F&D&A&5&8с&x&F&F&D&7&5&8е&x&F&F&D&5&5&7й&x&F&F&D&2&5&7ф &x&F&F&C&F&5&6з&x&F&F&C&D&5&6о&x&F&F&C&A&5&6н&x&F&F&C&7&5&5ы &x&F&F&C&5&5&5б&x&F&F&C&2&5&5ы&x&F&F&B&F&5&4л&x&F&F&B&C&5&4и &n&x&F&F&B&A&5&4у&x&F&F&B&7&5&3д&x&F&F&B&4&5&3а&x&F&F&B&2&5&2л&x&F&F&A&F&5&2е&x&F&F&A&C&5&2н&x&F&F&A&A&5&1ы&x&F&F&A&7&5&1!"));
                }
            }
            Main.getInstance().locs.clear();
        }
        return true;
    }

    private class GeneratorRunnable implements Runnable {
        private final CommandSender sender;

        public GeneratorRunnable(CommandSender sender) {
            this.sender = sender;
        }


        @Override
        public void run() {
            World netherWorld = Bukkit.getWorlds().get(1);

            if (netherWorld == null) {
                sender.sendMessage(system.ar_prefix+ChatColor.translateAlternateColorCodes('&',"&x&C&B&2&D&3&EН&x&D&0&3&0&3&Eе&x&D&4&3&4&3&Dз&x&D&9&3&7&3&Dе&x&D&D&3&A&3&Cр &x&E&2&3&D&3&Cм&x&E&6&4&1&3&Bи&x&E&B&4&4&3&Bр &x&E&F&4&7&3&Aн&x&E&9&4&1&3&Dе &x&E&2&3&B&4&1н&x&D&C&3&5&4&4а&x&D&6&2&F&4&7й&x&C&F&2&8&4&Aд&x&C&9&2&2&4&Eе&x&C&2&1&C&5&1н&x&B&C&1&6&5&4!"));
                return;
            }

            ThreadLocalRandom rand = ThreadLocalRandom.current();
            int x, y, z;
            Material belowMaterial, midMaterial, aboveMaterial;
            Location safeLocation;
            int coords = Main.getInstance().getConfig().getInt("coords");
            while (!isStopped) {
                x = rand.nextInt(-coords, coords + 1);
                z = rand.nextInt(-coords, coords + 1);
                y = rand.nextInt(32, 100 + 1);

                belowMaterial = netherWorld.getBlockAt(x, y - 1, z).getType();
                midMaterial = netherWorld.getBlockAt(x, y, z).getType();
                aboveMaterial = netherWorld.getBlockAt(x, y + 1, z).getType();

                if (funcs.BELOW_MATERIALS.contains(belowMaterial)) {
                    if (funcs.ABOVE_MATERIALS.contains(aboveMaterial)) {
                        if (funcs.MID_MATERIALS.contains(midMaterial)) {
                            safeLocation = new Location(netherWorld, x + 0.5, y, z + 0.5);
                            if (!Main.getInstance().locs.contains(safeLocation)) {
                                //local_size+=1;
                                Main.getInstance().locs.add(safeLocation);
                                if (Main.getInstance().getConfig().getBoolean("msgByFound")){
                                    for (Player p : Bukkit.getOnlinePlayers()) {
                                        if (p.isOp()) {
                                            p.sendMessage(system.yl_prefix+ChatColor.translateAlternateColorCodes('&',"&x&F&F&E&2&5&9С&x&F&F&D&E&5&8е&x&F&F&D&A&5&8й&x&F&F&D&6&5&7ф &x&F&F&D&2&5&7з&x&F&F&C&E&5&6о&x&F&F&C&A&5&6н&x&F&F&C&6&5&5а &x&F&F&C&3&5&5н&x&F&F&B&F&5&4а&x&F&F&B&B&5&4й&x&F&F&B&7&5&3д&x&F&F&B&3&5&3е&x&F&F&A&F&5&2н&x&F&F&A&B&5&2а&x&F&F&A&7&5&1!\n&r&x&F&F&E&2&5&9К&x&F&F&D&C&5&8о&x&F&F&D&6&5&7о&x&F&F&D&0&5&7р&x&F&F&C&A&5&6д&x&F&F&C&5&5&5и&x&F&F&B&F&5&4н&x&F&F&B&9&5&3а&x&F&F&B&3&5&3т&x&F&F&A&D&5&2ы&x&F&F&A&7&5&1: "+x+" "+y+" "+z));
                                        }
                                    }
                                }

                            }

                        }
                    }
                }

                try {
                    Thread.sleep(Main.getInstance().getConfig().getInt("loopCD")); // Задержка между итерациями цикла
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

    }
    public static void stopGenerator() {
        if (generatorThread != null) {
            isStopped = true;
            generatorThread.interrupt();
            generatorThread = null;
        }
    }

}