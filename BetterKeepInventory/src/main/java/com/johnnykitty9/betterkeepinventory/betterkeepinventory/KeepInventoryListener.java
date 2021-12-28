 package com.johnnykitty9.betterkeepinventory.betterkeepinventory;

 import java.util.HashMap;
 import java.util.Map;
 import java.util.UUID;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.entity.EntityDamageEvent;
 import org.bukkit.event.entity.EntityDeathEvent;
 import org.bukkit.event.player.PlayerRespawnEvent;
 import org.bukkit.inventory.ItemStack;


 public class KeepInventoryListener
  implements Listener
 {
      private static Map<UUID, ItemStack[]> inventoryList = (Map) new HashMap<>();
      private static Map<UUID, Integer> experienceMap = new HashMap<>();

    @EventHandler
     public void onDeath(EntityDeathEvent ede) {

        if (ede.getEntity() instanceof Player && ede
.getEntity().getLastDamageCause().getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK && ede
.getEntity().getKiller() == null) {
            Player player = ((Player) ede.getEntity()).getPlayer();
            inventoryList.put(player.getUniqueId(), player.getInventory().getContents());
            experienceMap.put(player.getUniqueId(), Integer.valueOf(player.getTotalExperience()));
            ede.getDrops().clear();
            ede.setDroppedExp(0);
            System.out.println("player died to another player(dropping items)");
        }
    }


    @EventHandler
    public void onRespawn(PlayerRespawnEvent pre) {
        System.out.println("player respawned");
        if (inventoryList.containsKey(pre.getPlayer().getUniqueId()) && experienceMap.containsKey(pre.getPlayer().getUniqueId())
                && !inventoryList.isEmpty() && !experienceMap.isEmpty()) {
            pre.getPlayer().getInventory().setContents(inventoryList.get(pre.getPlayer().getUniqueId()));
            pre.getPlayer().setTotalExperience((Integer) experienceMap.get(pre.getPlayer().getUniqueId()));
            System.out.println("gave "+ pre.getPlayer().getUniqueId() + " :" + inventoryList);
            inventoryList.remove(pre.getPlayer().getUniqueId());
            experienceMap.remove(pre.getPlayer().getUniqueId());
            System.out.println("removing player from database");
        }
        /*    */
    }
}


/* Location:              C:\Users\Johnn\Desktop\BetterKeepInventory-1.0.jar!\com\johnnykitty9\betterkeepinventory\KeepInventoryListener.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */