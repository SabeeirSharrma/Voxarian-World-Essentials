package com.sabcodes.voxarianworldessentials;

import com.sabcodes.voxarianworldessentials.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;

public class VoxarianWorldEssentialsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModConfig.load();
	}
}