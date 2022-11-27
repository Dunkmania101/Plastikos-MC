package dunkmania101.plastikos_forge;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.registry.impl.BaseRegistryAcceptor;
import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import dunkmania101.plastikos.PlastikosMod;
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
            public Entry<ResourceLocation, Supplier<T>> acceptObject(ResourceLocation rn, Supplier<T> value) {
                RegistryObject<T> obj = register.register(rn.getPath(), value);
                return Map.entry(obj.getId(), (Supplier<T>) obj);
            }
        };
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
