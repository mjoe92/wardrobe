package com.codecool.wardrobe.clothing;

import java.util.Optional;

public class UpperClothes extends Clothes {
    public UpperClothes(String brandName, ClothesType type) {
        super(brandName);
        Optional.ofNullable(type)
                .filter(v -> v.equals(ClothesType.BLOUSE) || v.equals(ClothesType.SHIRT))
                .orElseThrow(IllegalArgumentException::new);
    }
}
