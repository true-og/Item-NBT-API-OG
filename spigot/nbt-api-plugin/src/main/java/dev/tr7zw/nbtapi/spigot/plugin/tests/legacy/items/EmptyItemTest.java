package dev.tr7zw.nbtapi.spigot.plugin.tests.legacy.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.nbtapi.NBTItem;
import dev.tr7zw.nbtapi.NBTApiException;
import dev.tr7zw.nbtapi.spigot.plugin.tests.Test;

public class EmptyItemTest implements Test {

	@Override
	public void test() throws Exception {
		ItemStack item = new ItemStack(Material.STONE);
		NBTItem nbti = new NBTItem(item);
		if (nbti.getBoolean("test") == null || nbti.getString("test") == null)
			throw new NBTApiException("Getters return null instead of the default value");

		try {
			Material barrel = Material.valueOf("BARREL");
			item = new ItemStack(barrel);
			nbti = new NBTItem(item);
		} catch (IllegalArgumentException ex) {
			// old version
		}
	}

}