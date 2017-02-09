package vpzomtrrfrt.mods.claydolls

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{Container, Slot}
import net.minecraft.item.ItemStack

class ContainerDollConfig(itemStack: ItemStack, player: EntityPlayer) extends Container {
  private val playerInv = player.inventory
  private var inv = new InventoryDollConfig(itemStack)

  for (y <- 0 until 3) {
    for (x <- 0 until 7) {
      addSlotToContainer(new Slot(inv, y * 7 + x, x * 18 + 26, y * 18 + 18))
    }
  }

  for (y <- 0 until 3) {
    for (x <- 0 until 9) {
      addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 86 + y * 18))
    }
  }

  for (x <- 0 until 9) {
    addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 144))
  }

  override def canInteractWith(entityPlayer: EntityPlayer): Boolean = true
}
