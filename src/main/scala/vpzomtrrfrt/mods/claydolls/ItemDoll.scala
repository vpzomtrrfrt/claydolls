package vpzomtrrfrt.mods.claydolls

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.math.BlockPos
import net.minecraft.util.{ActionResult, EnumActionResult, EnumFacing, EnumHand}
import net.minecraft.world.World

object ItemDoll extends Item {
  setUnlocalizedName("clayDoll")
  setCreativeTab(ClayDolls.TAB)

  override def onItemRightClick(world : World, player : EntityPlayer, hand : EnumHand): ActionResult[ItemStack] = {
    val pos = new BlockPos(player)
    val x = pos.getX
    val y = pos.getY
    val z = pos.getZ
    player.openGui(ClayDolls, GUIHandler.GUI_DOLLCONFIG, world, x, y, z)
    new ActionResult[ItemStack](EnumActionResult.SUCCESS, player.getHeldItem(hand))
  }
}
