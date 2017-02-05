package vpzomtrrfrt.mods.claydolls

import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item

import scala.collection.mutable.ArrayBuffer

class ClientProxy extends CommonProxy {
  val items = new ArrayBuffer[Item]()

  override def registerItem(item: Item, name: String): Unit = {
    super.registerItem(item, name)
    items.append(item)
  }

  def registerModel(item: Item, i: Int, path: String): Unit = {
    val loc = item.getRegistryName
    Minecraft.getMinecraft.getRenderItem.getItemModelMesher.register(item, i, new ModelResourceLocation(loc.getResourceDomain + ":" + path, "inventory"))
  }

  def registerModel(item: Item): Unit = {
    val loc = item.getRegistryName
    registerModel(item, 0, loc.getResourcePath)
  }

  override def init(): Unit = {
    super.init()
    for(item <- items) {
      registerModel(item)
    }
  }
}