package me.srb.starterp.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class SilkTouchHelper implements Listener {

    @EventHandler
    public void spawnerCatcher(BlockBreakEvent e) {
        if (!(e.getBlock().getType() == Material.SPAWNER)) return;
        if (!(e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH))) return;
        e.setCancelled(true);

        // old spawner
        Block breaked_block = e.getBlock();
        CreatureSpawner breaked_spawner = (CreatureSpawner) breaked_block.getState();

        // new spawner
        ItemStack new_spawner = new ItemStack(Material.SPAWNER);
        BlockStateMeta new_spawner_meta = (BlockStateMeta) new_spawner.getItemMeta();
        CreatureSpawner final_spawner = (CreatureSpawner) new_spawner_meta.getBlockState();

        final_spawner.setSpawnedType(breaked_spawner.getSpawnedType());
        new_spawner_meta.setBlockState(final_spawner);
        new_spawner.setItemMeta(new_spawner_meta);

        breaked_block.setType(Material.AIR);
        breaked_block.getWorld().dropItemNaturally(breaked_block.getLocation(), new_spawner);

    }

    @EventHandler
    public void spawnerPlacer(BlockPlaceEvent e) {
        if (!(e.getBlock().getType() == Material.SPAWNER)) return;

        ItemStack hand_item = new ItemStack(e.getPlayer().getInventory().getItemInMainHand());
        BlockStateMeta hand_item_meta = (BlockStateMeta) hand_item.getItemMeta();
        CreatureSpawner hand_spawner = (CreatureSpawner) hand_item_meta.getBlockState();


        CreatureSpawner spawn = (CreatureSpawner) e.getBlockPlaced().getState();
        spawn.setSpawnedType(hand_spawner.getSpawnedType());
    }
}
