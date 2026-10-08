package com.billy.siegecraft.client;

import com.billy.siegecraft.operator.Operator;
import com.billy.siegecraft.operator.OperatorRegistry;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class OperatorMenuScreen extends Screen {
    private static final int BUTTON_W = 150;
    private static final int BUTTON_H = 20;
    private static final int GAP = 4;

    private Operator.Side filter = null;

    public OperatorMenuScreen() {
        super(Component.literal("SiegeCraft — Operator Selection"));
    }

    @Override
    protected void init() {
        rebuild();
    }

    private void rebuild() {
        clearWidgets();

        int y = 28;
        this.addRenderableWidget(Button.builder(Component.literal("All Operators"), b -> {
            filter = null;
            rebuild();
        }).bounds(10, 8, 110, BUTTON_H).build());

        this.addRenderableWidget(Button.builder(Component.literal("Attackers"), b -> {
            filter = Operator.Side.ATTACKER;
            rebuild();
        }).bounds(124, 8, 100, BUTTON_H).build());

        this.addRenderableWidget(Button.builder(Component.literal("Defenders"), b -> {
            filter = Operator.Side.DEFENDER;
            rebuild();
        }).bounds(228, 8, 100, BUTTON_H).build());

        int columns = Math.max(1, Math.min(4, this.width / (BUTTON_W + GAP)));
        int visible = 0;
        for (Operator operator : OperatorRegistry.ALL) {
            if (filter != null && operator.side() != filter) continue;

            int col = visible % columns;
            int row = visible / columns;
            int x = 10 + col * (BUTTON_W + GAP);
            int buttonY = y + row * (BUTTON_H + GAP);

            this.addRenderableWidget(Button.builder(Component.literal(operator.name()), b -> select(operator))
                .bounds(x, buttonY, BUTTON_W, BUTTON_H)
                .build());
            visible++;
        }
    }

    private void select(Operator operator) {
        if (this.minecraft.player != null) {
            this.minecraft.player.sendSystemMessage(
                Component.literal("Selected " + operator.name() + " — " + operator.side().name())
            );
        }
        this.onClose();
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(null);
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);
        graphics.text(this.font, "SiegeCraft Operator Selection", 10, 0, 0xFFFFFFFF, true);
        graphics.text(this.font, "O = open menu | Normal Minecraft is unchanged", 340, 12, 0xFFAAAAAA, false);
    }
}
