package vpzomtrrfrt.mods.claydolls

import net.minecraft.creativetab.CreativeTabs
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(modid = ClayDolls.MODID, modLanguage = "scala", name = ClayDolls.NAME)
object ClayDolls {
  val TAB = /*new CreativeTabs("claydolls") {
    override def getTabIconItem = new ItemStack(ItemDoll)
  }*/CreativeTabs.MISC

  final val MODID = "claydolls"
  final val NAME = "Clay Dolls"

  @SidedProxy(clientSide="vpzomtrrfrt.mods.claydolls.ClientProxy", serverSide="vpzomtrrfrt.mods.claydolls.CommonProxy")
  var proxy : CommonProxy = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    proxy.preInit()

    MinecraftForge.EVENT_BUS.register(this)
  }

  @EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    proxy.init()
  }

}
