package cn.ksmcbrigade.osf.mixin;

import net.minecraft.client.resources.DefaultPlayerSkin;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(DefaultPlayerSkin.class)
public class DefaultSkinMixin {
    @Shadow @Final private static DefaultPlayerSkin.SkinType[] DEFAULT_SKINS;

    @Inject(method = "getSkinType",at = @At("HEAD"),cancellable = true)
    private static void skin(UUID p_260299_, CallbackInfoReturnable<DefaultPlayerSkin.SkinType> cir){
        cir.setReturnValue(Math.floorMod(p_260299_.hashCode(),DEFAULT_SKINS.length)<=10?DEFAULT_SKINS[15]:DEFAULT_SKINS[0]);
    }
}
