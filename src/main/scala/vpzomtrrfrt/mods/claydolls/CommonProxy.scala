package vpzomtrrfrt.mods.claydolls

import net.minecraft.item.Item
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.registry.GameRegistry


class CommonProxy {
  def preInit(): Unit = {
    registerItem(ItemDoll, "claydoll")

    NetworkRegistry.INSTANCE.registerGuiHandler(ClayDolls, new GUIHandler)
  }

  def init(): Unit = {

  }

  def registerItem(item: Item, name: String): Unit = {
    item.setRegistryName(name)
    GameRegistry.register(item)
  }
}
