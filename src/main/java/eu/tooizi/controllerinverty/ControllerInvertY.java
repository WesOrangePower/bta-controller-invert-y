package eu.tooizi.controllerinverty;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.option.OptionBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;

public class ControllerInvertY implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("controllerinverty", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final OptionBoolean CONTROLLER_INVERT_Y =
		GameSettings.register(new OptionBoolean("controllerInvertY", false));

	@Override
	public void onInitialize() {
	}
}
