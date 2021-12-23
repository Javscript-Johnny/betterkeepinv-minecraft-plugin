/*    */ package xyz.mrsherobrine.betterkeepinventory.betterkeepinventory;
/*    */ 
/*    */ import java.util.logging.Logger;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public final class BetterKeepInventory
/*    */   extends JavaPlugin {
/*  9 */   public static Logger LOGGER = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 14 */     LOGGER = getLogger();
/*    */     
/* 16 */     LOGGER.info("BetterKeepInventory has started!");
/*    */     
/* 18 */     getServer().getPluginManager().registerEvents(new KeepInventoryListener(), (Plugin)this);
/*    */   }
/*    */   
/*    */   public void onDisable() {}
/*    */ }


/* Location:              C:\Users\Johnn\Desktop\BetterKeepInventory-1.0.jar!\xyz\mrsherobrine\betterkeepinventory\BetterKeepInventory.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */