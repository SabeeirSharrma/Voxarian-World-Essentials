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
        method = "render(Lnet/minecraft/client/gui/DrawContext;IIF)V",
        at = @At("HEAD"),
        require = 0
    )
    private void voxarian$removeSplash(
            net.minecraft.client.gui.DrawContext context,
            int mouseX,
            int mouseY,
            float delta,
            CallbackInfo ci
    ) {
        this.splashText = null;
    }
}
