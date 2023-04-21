package dunkmania101.modularmod.base.modules;

import java.util.Collection;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModularModCreativeModeTab extends CreativeModeTab {
    private final String ID;

    public ModularModCreativeModeTab(Builder builder, String id) {
        super(builder);
        this.ID = id;
    }

    public ModularModCreativeModeTab(String label, Supplier<Collection<Supplier<? extends Item>>> items, String id) {
        this(builder(Row.TOP, 0).title(Component.translatable(label)).displayItems((CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) -> {
            items.get().forEach((i) -> output.accept(i.get()));
        }), id);
    }

    public ModularModCreativeModeTab(String label, Supplier<Collection<Supplier<? extends Item>>> items) {
        this(label, items, label);
    }

    public String getId() {
        return this.ID;
    }

    @Nullable
    public ResourceLocation getIconId() {
        return null;
    }

    @Nonnull
    public ResourceLocation getBlankIconId() {
       return new ResourceLocation("minecraft:air");
    }

    public ItemStack makeIcon() {
        ResourceLocation iconId = this.getIconId();
        return new ItemStack(BuiltInRegistries.ITEM.get(iconId == null ? this.getBlankIconId() : iconId));
    }

    @Override
    public ItemStack getIconItem() {
        return makeIcon();
    }
}

