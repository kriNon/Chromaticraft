package kriNon.mods.Chromaticraft;

import kriNon.mods.Chromaticraft.proxy.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kriNon.mods.Chromaticraft.init.TFBlocks;

@Mod(modid = Chromaticraft.MODID, name = Chromaticraft.NAME, version = Chromaticraft.VERSION, dependencies = "required-after:cofhcore")
public class Chromaticraft
{
    public static final String MODID = "chromaticraft";
    public static final String NAME = "Chromaticraft";
    public static final String VERSION = "0.0.1";

    @Mod.Instance
    private static Chromaticraft instance;

    @SidedProxy(clientSide = "kriNon.mods.Chromaticraft.proxy.ClientProxy",serverSide = "kriNon.mods.Chromaticraft.proxy.ServerProxy")
    public static ServerProxy proxy;

    public static final Logger LOG = LogManager.getLogger(MODID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {


        proxy.preInit(event);

        TFBlocks.preInit();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    public static String appendModID(String value)
    {
        return MODID + ":" + value;
    }
}

//TODO: Fix rockwool block item not rendering properly in inventory
//TODO: Rename Rockwool to Runes


//https://www.youtube.com/channel/UCjd9lUZT3Z2We0kON0t8Fhg
//https://github.com/CoFH/ThermalFoundation/blob/1.12/src/main/java/cofh/thermalfoundation/block/ItemBlockRockwool.java