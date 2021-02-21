package com.codecool.wardrobe.clothing;

import java.util.UUID;

public class Clothes {
    private UUID id = UUID.randomUUID();
    private String brandName;

    protected ClothesType type;

    public Clothes(String brandName) {
        this.brandName = brandName;
    }

    public UUID getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public ClothesType getType() {
        return this.type;
    }

    public enum ClothesType {
        SHIRT,
        BLOUSE,
        TROUSERS,
        SKIRT
    }
}
