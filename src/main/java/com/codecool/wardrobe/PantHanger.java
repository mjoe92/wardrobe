package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.UpperClothes;
import com.codecool.wardrobe.clothing.LowerClothes;

import java.util.*;

public class PantHanger implements Hanger<Clothes> {

    private Optional<Clothes> hangerWithPants = Optional.empty();
    private Optional<Clothes> hangerWithShirt = Optional.empty();

    @Override
    public Optional<Clothes> takeOff() {
        if (hangerWithShirt.isPresent()) {
            Optional<Clothes> shirt = hangerWithShirt;
            hangerWithShirt = Optional.empty();
            return shirt;
        } else if (hangerWithPants.isPresent()) {
            Optional<Clothes> pants = hangerWithPants;
            hangerWithPants = Optional.empty();
            return pants;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Clothes> takeOff(UUID id) {
        if(hangerWithShirt.isPresent()) {
            if (hangerWithShirt.get().getId().equals(id)) return hangerWithShirt;
        } else if(hangerWithPants.isPresent()) {
            if (hangerWithPants.get().getId().equals(id)) return hangerWithPants;
        }
        return Optional.empty();
    }

    @Override
    public void put(Clothes item) {
        if (hangerWithShirt.isEmpty() && item instanceof UpperClothes) {
            hangerWithShirt = Optional.of(item);
        } else if (hangerWithPants.isEmpty() && item instanceof LowerClothes) {
            hangerWithPants = Optional.of(item);
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean hasSlotFor(Clothes.ClothesType type) {
        if (hangerWithShirt.isEmpty() && (type.equals(Clothes.ClothesType.SHIRT) || type.equals(Clothes.ClothesType.BLOUSE))) {
            return true;
        }
        return hangerWithPants.isEmpty() && (type.equals(Clothes.ClothesType.TROUSERS) || type.equals(Clothes.ClothesType.SKIRT));
    }

/*
    private static final int freeSlots = 10;
    private static final HashMap<UUID, Clothes> hangedPants = new HashMap<>(freeSlots);
    private static final HashMap<UUID, Clothes> hangedShirts = new HashMap<>(freeSlots);

    @Override
    public Optional<Clothes> takeOff() {
        return hangedShirts.size() > 0 ?
                hangedShirts.values().stream().findFirst() :
                Optional.ofNullable(hangedPants.values().stream().findFirst().get());
        //Optional.ofNullable(hangedPants.values().stream().findFirst().get());
    }

    @Override
    public Optional<Clothes> takeOff(UUID id) {
        return Optional.ofNullable(hangedPants.get(id));
    }

    @Override
    public void put(Clothes item) {
        try {
            if (item.getType().equals(ClothesType.SHIRT) || item.getType().equals(ClothesType.BLOUSE)) {
                hangedShirts.put(item.getId(), item);
            } else {
                hangedPants.put(item.getId(), item);
            }
        } catch (IllegalStateException ex) {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean hasSlotFor(ClothesType type) {
        if (type.equals(ClothesType.SHIRT) || type.equals(ClothesType.BLOUSE)) {
            return freeSlots - hangedShirts.size() > 0;
        } else {
            return freeSlots - hangedPants.size() > 0;
        }
    }
    */
}
