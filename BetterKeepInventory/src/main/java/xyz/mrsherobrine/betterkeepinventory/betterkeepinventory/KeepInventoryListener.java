/*    */ package xyz.mrsherobrine.betterkeepinventory.betterkeepinventory;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDeathEvent;
/*    */ import org.bukkit.event.player.PlayerRespawnEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class KeepInventoryListener
/*    */   implements Listener
/*    */ {
    /* 17 */   private static Map<UUID, ItemStack[]> inventoryList = (Map) new HashMap<>();
    /* 18 */   private static Map<UUID, Integer> experienceMap = new HashMap<>();

    /*    */
    /*    */
    /*    */
    @EventHandler
    /*    */ public void onDeath(EntityDeathEvent ede) {
        /* 23 */
        if (ede.getEntity() instanceof Player && ede
/* 24 */.getEntity().getLastDamageCause().getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK && ede
/* 25 */.getEntity().getKiller() == null) {
            /*    */
            /* 27 */
            Player player = ((Player) ede.getEntity()).getPlayer();
            /*    */
            /* 29 */
            inventoryList.put(player.getUniqueId(), player.getInventory().getContents());
            /* 30 */
            experienceMap.put(player.getUniqueId(), Integer.valueOf(player.getTotalExperience()));
            /*    */
            /* 32 */
            ede.getDrops().clear();
            /* 33 */
            ede.setDroppedExp(0);
            /*    */
        }
        /*    */
    }

    /*    */
    /*    */
    /*    */
    @EventHandler
    /*    */ public void onRespawn(PlayerRespawnEvent pre) {
        if (inventoryList.containsKey(pre.getPlayer().getUniqueId()) && experienceMap.containsKey(pre.getPlayer().getUniqueId())) {
            pre.getPlayer().getInventory().setContents(inventoryList.get(pre.getPlayer().getUniqueId()));
            pre.getPlayer().setTotalExperience((Integer) experienceMap.get(pre.getPlayer().getUniqueId()));
            inventoryList.remove(pre.getPlayer().getUniqueId());
            experienceMap.remove(pre.getPlayer().getUniqueId());
        }
        /*    */
    }
}


/* Location:              C:\Users\Johnn\Desktop\BetterKeepInventory-1.0.jar!\xyz\mrsherobrine\betterkeepinventory\KeepInventoryListener.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */