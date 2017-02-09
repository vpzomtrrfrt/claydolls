package vpzomtrrfrt.mods.claydolls

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.util.ResourceLocation

class GuiDoll(container: ContainerDollConfig) extends GuiContainer(container) {
  override def drawGuiContainerBackgroundLayer(v: Float, i: Int, i1: Int): Unit = {
    mc.getTextureManager.bindTexture(new ResourceLocation(ClayDolls.MODID, "textures/gui/doll.png"))
    drawTexturedModalRect((width - xSize) / 2, (height - ySize) / 2, 0, 0, xSize, ySize)
  }
}
