package dunkmania101.plastikos.loader_forge;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.ModularModCreativeModeTab;
import dunkmania101.modularmod.base.registry.impl.BaseRegistryAcceptor;
import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import dunkmania101.modularmod.base.util.NameUtils;
import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(PlastikosConstants.MODID)
public class PlastikosModForge {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PlastikosConstants.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PlastikosConstants.MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PlastikosConstants.MODID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PlastikosConstants.MODID);
    private static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PlastikosConstants.MODID);

    public static final PlastikosMod MOD = new PlastikosMod(getRegistryAcceptor(ITEMS), getRegistryAcceptor(BLOCKS), getRegistryAcceptor(BLOCK_ENTITIES), getRegistryAcceptor(ENTITIES), getRegistryAcceptor(MENUS));

    static {
        MOD.earlyCommonSetup();
    }

    @OnlyIn(Dist.CLIENT)
    private static final class EarlyClientSetup {
        static {
            MOD.earlyClientSetup();
        }
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    private static final class EarlyServerSetup {
        static {
            MOD.earlyServerSetup();
        }
    }

    public PlastikosModForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(this::onServerSetup);
        modEventBus.addListener(this::onCreativeModeTabsRegistry);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        ENTITIES.register(modEventBus);
        MENUS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private static <T> IRegistryAcceptor<T> getRegistryAcceptor(DeferredRegister<T> register) {
        return new BaseRegistryAcceptor<T>() {
            @Override
            public <U extends T> Entry<ResourceLocation, Supplier<U>> acceptObject(ResourceLocation rn, Supplier<U> value) {
                RegistryObject<U> obj = register.register(rn.getPath(), value);
                return Map.entry(obj.getId(), obj);
            }
        };
    }

    private void handleModuleCreativeModeTabsRegistry(final CreativeModeTabEvent.Register event, IPlastikosModule module) {
        if (module != null) {
            ArrayList<ModularModCreativeModeTab> tabs = module.getCreativeTabs();
            if (tabs != null) {
                for (ModularModCreativeModeTab tab : tabs) {
                    if (tab != null) {
                        event.registerCreativeModeTab(new ResourceLocation(PlastikosConstants.MODID, NameUtils.appendName(module.getId(), tab.getId())), (builder) -> builder.withTabFactory((b) -> tab));
                    }
                }
            }
            Map<String, IPlastikosModule> children = module.getChildren();
            if (children != null) {
                for (IPlastikosModule child : children.values()) {
                    if (child != null) {
                        handleModuleCreativeModeTabsRegistry(event, child);
                    }
                }
            }
        }
    }

    private void onCreativeModeTabsRegistry(final CreativeModeTabEvent.Register event) {
        handleModuleCreativeModeTabsRegistry(event, MOD);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        MOD.commonSetup();
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        MOD.clientSetup();
    }

    private void onServerSetup(final FMLDedicatedServerSetupEvent event) {
        MOD.serverSetup();
    }
}
