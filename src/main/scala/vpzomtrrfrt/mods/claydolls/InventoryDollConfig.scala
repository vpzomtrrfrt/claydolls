package vpzomtrrfrt.mods.claydolls

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.nbt.{NBTTagCompound, NBTTagList}
import net.minecraft.util.text.{ITextComponent, TextComponentString, TextComponentTranslation}

class InventoryDollConfig(itemStack: ItemStack) extends IInventory {
  var slots: Array[ItemStack] = _

  load()

  def load(): Unit = {
    clear()
    if (itemStack.hasTagCompound) {
      val nbt = itemStack.getTagCompound
      if (nbt.hasKey("Items")) {
        val list = nbt.getTag("Items").asInstanceOf[NBTTagList]
        for (i <- 0 until list.tagCount()) {
          list.get(i) match {
            case y: NBTTagCompound =>
              slots(y.getByte("Slot")) = new ItemStack(y)
            case _ =>
          }
        }
      }
    }
  }

  override def closeInventory(entityPlayer: EntityPlayer): Unit = save()

  def save(): Unit = {
    var nbt: NBTTagCompound = null
    if (!itemStack.hasTagCompound) {
      nbt = new NBTTagCompound
      itemStack.setTagCompound(nbt)
    }
    else {
      nbt = itemStack.getTagCompound
    }
    val list = new NBTTagList
    for (i <- slots.indices) {
      val stack = slots(i)
      if (stack != null && !stack.isEmpty) {
        val tag = new NBTTagCompound
        stack.writeToNBT(tag)
        tag.setByte("Slot", i.asInstanceOf[Byte])
        list.appendTag(tag)
      }
    }
    nbt.setTag("Items", list)
  }

  override def decrStackSize(i: Int, i1: Int): ItemStack = {
    val tr = slots(i).splitStack(i1)
    save()
    tr
  }

  override def isUsableByPlayer(entityPlayer: EntityPlayer): Boolean = true

  override def getSizeInventory: Int = slots.length

  override def getInventoryStackLimit: Int = 1

  override def clear(): Unit = {
    slots = Array.fill(21)(ItemStack.EMPTY)
  }

  override def markDirty(): Unit = {}

  override def isItemValidForSlot(i: Int, itemStack: ItemStack): Boolean = !slots(i).isEmpty

  override def openInventory(entityPlayer: EntityPlayer): Unit = {}

  override def getFieldCount: Int = 0

  override def getField(i: Int): Int = 0

  override def setInventorySlotContents(i: Int, itemStack: ItemStack): Unit = {
    slots(i) = itemStack
    save()
  }

  override def removeStackFromSlot(i: Int): ItemStack = {
    val tr = slots(i)
    slots(i) = ItemStack.EMPTY
    save()
    tr
  }

  override def getStackInSlot(i: Int): ItemStack = slots(i)

  override def setField(i: Int, i1: Int): Unit = {}

  override def isEmpty: Boolean = {
    for (x <- slots) {
      if (!x.isEmpty) {
        return false
      }
    }
    true
  }

  override def getDisplayName: ITextComponent = {
    if (hasCustomName) {
      return new TextComponentString(getName)
    }
    new TextComponentTranslation(getName)
  }

  override def getName: String = {
    if (itemStack.hasDisplayName) {
      return itemStack.getDisplayName
    }
    "text.claydolls.config"
  }

  override def hasCustomName: Boolean = itemStack.hasDisplayName
}
