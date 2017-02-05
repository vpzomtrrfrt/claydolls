package vpzomtrrfrt.mods.claydolls

import net.minecraft.creativetab.CreativeTabs
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(modid = ClayDolls.MODID, modLanguage = "scala")
object ClayDolls {
  val TAB = /*new CreativeTabs("claydolls") {
    override def getTabIconItem = new ItemStack(ItemDoll)
  }*/CreativeTabs.MISC

  final val MODID = "claydolls"

  @SidedProxy(clientSide="vpzomtrrfrt.mods.claydolls.ClientProxy", serverSide="vpzomtrrfrt.mods.claydolls.CommonProxy")
  var proxy : CommonProxy = _

  @SubscribeEvent
  def preInit(event: FMLPreInitializationEvent): Unit = {
    proxy.preInit()
  }

  @SubscribeEvent
  def init(event: FMLInitializationEvent): Unit = {
    proxy.init()
  }

}
