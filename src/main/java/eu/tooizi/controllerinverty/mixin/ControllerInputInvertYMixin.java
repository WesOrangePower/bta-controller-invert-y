package eu.tooizi.controllerinverty.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import eu.tooizi.controllerinverty.ControllerInvertY;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = WorldRenderer.class, remap = false)
public class ControllerInputInvertYMixin {
  @ModifyExpressionValue(
      method = "updateCameraAndRender",
      at =
          @At(value = "INVOKE", target = "Lnet/minecraft/client/input/controller/Joystick;getY()F"))
  private float invertControllerLookY(float original) {
    return ControllerInvertY.CONTROLLER_INVERT_Y.isTrue() ? -original : original;
  }
}
