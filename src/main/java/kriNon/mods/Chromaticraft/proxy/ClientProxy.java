package kriNon.mods.Chromaticraft.proxy;

import cofh.core.proxy.EventHandlerClient;
import cofh.core.render.IModelRegister;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;

public class ClientProxy extends ServerProxy {

    /* INIT */
    @Override
    public void preInit(FMLPreInitializationEvent event) {

        super.preInit(event);

        MinecraftForge.EVENT_BUS.register(EventHandlerClient.INSTANCE);



        for (IModelRegister register : modelList) {
            register.registerModels();
        }
        registerRenderInformation();
    }

    @Override
    public void init(FMLInitializationEvent event) {

        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

        super.postInit(event);
    }

    /* REGISTRATION */
    public void registerRenderInformation() {

    }

    /* HELPERS */
    public boolean addIModelRegister(IModelRegister modelRegister) {

        return modelList.add(modelRegister);
    }

    private static ArrayList<IModelRegister> modelList = new ArrayList<>();

}