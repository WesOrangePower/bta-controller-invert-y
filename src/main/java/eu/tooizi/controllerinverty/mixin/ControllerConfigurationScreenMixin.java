package eu.tooizi.controllerinverty.mixin;

import eu.tooizi.controllerinverty.ControllerInvertY;
import net.minecraft.client.gui.options.components.BooleanOptionComponent;
import net.minecraft.client.gui.options.components.OptionsCategory;
import net.minecraft.client.gui.options.components.OptionsComponent;
import net.minecraft.client.gui.options.data.OptionsPages;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = OptionsPages.class, remap = false)
public class ControllerConfigurationScreenMixin {
  @Inject(method = "init", at = @At("TAIL"))
  private static void addInvertYButton(CallbackInfo ci) {
    for (OptionsComponent component : OptionsPages.CONTROLS.getComponents()) {
      if (!(component instanceof OptionsCategory category)) {
        continue;
      }

      OptionsCategoryAccessor accessor = (OptionsCategoryAccessor) category;
      if (!"gui.options.page.controls.category.controller".equals(accessor.getTranslationKey())) {
        continue;
      }

      accessor
          .getComponents()
          .add(2, new BooleanOptionComponent(ControllerInvertY.CONTROLLER_INVERT_Y));
      return;
    }
  }
}
