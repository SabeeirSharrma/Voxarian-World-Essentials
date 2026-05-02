package com.sabcodes.voxarianworldessentials.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.SplashTextRenderer;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {

    @Shadow
    private SplashTextRenderer splashText;

    @Inject(
        method = "init()V",
        at = @At("TAIL"),
        require = 0
    )
    private void voxarian$removeSplash(CallbackInfo ci) {
        this.splashText = null;
    }
}
