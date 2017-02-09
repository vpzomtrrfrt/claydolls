package vpzomtrrfrt.mods.claydolls

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{Container, Slot}
import net.minecraft.item.ItemStack

class ContainerDollConfig(itemStack: ItemStack, player: EntityPlayer) extends Container {
  private val playerInv = player.inventory
  private var inv = new InventoryDollConfig(itemStack)

  for (y <- 0 until 2) {
    for (x <- 0 until 9) {
      addSlotToContainer(new Slot(inv, y * 9 + x, x * 20 + 20, y * 20 + 20))
    }
  }

  for (y <- 0 until 3) {
    for (x <- 0 until 9) {
      addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18))
    }
  }

  for (x <- 0 until 9) {
    addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142))
  }

  override def canInteractWith(entityPlayer: EntityPlayer): Boolean = true
}
