package com.billy.siegecraft.client;

import com.billy.siegecraft.SiegeCraft;
import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public final class SiegeCraftClient implements ClientModInitializer {
    private static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(
        Identifier.fromNamespaceAndPath(SiegeCraft.MOD_ID, "operator")
    );

    private static final KeyMapping OPEN_OPERATOR_MENU = KeyMappingHelper.registerKeyMapping(
        new KeyMapping(
            "key.siegecraft.operator_menu",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_O,
            CATEGORY
        )
    );

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (OPEN_OPERATOR_MENU.consumeClick()) {
                if (client.screen == null) {
                    client.setScreen(new OperatorMenuScreen());
                }
            }
        });
    }
}
