package com.codecool.wardrobe.clothing;

import java.util.Optional;

public class LowerClothes extends Clothes {
    public LowerClothes(String brandName, ClothesType type) {
        super(brandName);
        Optional.ofNullable(type)
                .filter(v -> v.equals(ClothesType.SKIRT) || v.equals(ClothesType.TROUSERS))
                .orElseThrow(IllegalArgumentException::new);
    }
}
