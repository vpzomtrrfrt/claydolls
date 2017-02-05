package vpzomtrrfrt.mods.claydolls

import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry


class CommonProxy {
  def preInit(): Unit = {
    registerItem(ItemDoll, "claydoll")
  }

  def init(): Unit = {

  }

  def registerItem(item: Item, name: String): Unit = {
    item.setRegistryName(name)
    GameRegistry.register(item)
  }
}
