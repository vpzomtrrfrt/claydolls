package vpzomtrrfrt.mods.claydolls

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler

class GUIHandler extends IGuiHandler {
  override def getClientGuiElement(i: Int, entityPlayer: EntityPlayer, world: World, i1: Int, i2: Int, i3: Int): AnyRef = {
    if(i == GUIHandler.GUI_DOLLCONFIG) {
      return new GuiDoll(getServerGuiElement(i, entityPlayer, world, i1, i2, i3).asInstanceOf[ContainerDollConfig])
    }
    null
  }

  override def getServerGuiElement(i: Int, entityPlayer: EntityPlayer, world: World, i1: Int, i2: Int, i3: Int): AnyRef = {
    if(i == GUIHandler.GUI_DOLLCONFIG) {
      return new ContainerDollConfig(entityPlayer.getHeldItemMainhand, entityPlayer)
    }
    null
  }
}

object GUIHandler {
  val GUI_DOLLCONFIG = 0
}