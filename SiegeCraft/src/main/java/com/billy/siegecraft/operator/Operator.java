package com.billy.siegecraft.operator;

public record Operator(String id, String name, Side side) {
    public enum Side { ATTACKER, DEFENDER }
}
