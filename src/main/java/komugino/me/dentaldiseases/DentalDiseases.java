package komugino.me.dentaldiseases;

import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Objects;

public final class DentalDiseases extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Dental Disease Plugin enabled.");
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Dental Disease Plugin disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //Is command name "dental"?
        if (command.getName().equalsIgnoreCase("dental")) {
            if(args.length != 1){
                sender.sendMessage("§c[Dental]Please add least 1 argument.");
            }
            else {
                if(Objects.equals(args[0], "toothbrush")){
                        if(sender instanceof Player){
                            Player player = (Player) sender;
                            ItemStack item = new ItemStack(Material.WOODEN_HOE, 1); //鉄の鍬を作成
                            ItemMeta meta = item.getItemMeta(); //アイテムのメタデータを取得
                            meta.setCustomModelData(1);
                            meta.setDisplayName("Toothbrush"); //アイテムの名前を設定
                            item.setItemMeta(meta); //アイテムにメタデータを反映
                            player.getInventory().addItem(item); //プレイヤーのインベントリにアイテムを追加
                        }
                        sender.sendMessage("[Dental]You have received  toothbrush successfully.");
                }

                else{
                    sender.sendMessage("[Dental]Incorrect argument.");
                }
            }
        }
        //コマンドが存在しない場合はfalseを返す
        return false;
    }


}
