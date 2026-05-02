package com.sabcodes.voxarianworldessentials.mixin;

import com.sabcodes.voxarianworldessentials.config.ModConfig;
import net.minecraft.resource.ResourcePackManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mixin(ResourcePackManager.class)
public abstract class ResourcePackManagerMixin {

    @ModifyVariable(method = "setEnabledProfiles", at = @At("HEAD"), argsOnly = true)
    private Collection<String> voxarian$forceEnabledProfiles(Collection<String> enabled) {
        if (ModConfig.INSTANCE.forcedResourcePacks == null || ModConfig.INSTANCE.forcedResourcePacks.isEmpty()) {
            return enabled;
        }

        List<String> newEnabled = new ArrayList<>(enabled);
        for (String pack : ModConfig.INSTANCE.forcedResourcePacks) {
            if (!newEnabled.contains(pack)) {
                newEnabled.add(pack);
            }
        }
        return newEnabled;
    }
}
