package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.UpperClothes;

import java.util.Optional;
import java.util.UUID;

public class ShirtHanger implements Hanger<UpperClothes> {

    private Optional<UpperClothes> hanger = Optional.empty();

    @Override
    public Optional<UpperClothes> takeOff() {
        Optional<UpperClothes> shirt = hanger;
        hanger = Optional.empty();
        return shirt;
    }

    @Override
    public Optional<UpperClothes> takeOff(UUID id) {
        if (hanger.isEmpty()) return Optional.empty();
        return hanger.get().getId().equals(id) ? hanger : Optional.empty();
    }

    @Override
    public void put(UpperClothes item) {
        if (hanger.isEmpty()) {
            hanger = Optional.of(item);
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean hasSlotFor(Clothes.ClothesType type) {
        return hanger.isEmpty() && (type.equals(Clothes.ClothesType.SHIRT) || type.equals(Clothes.ClothesType.BLOUSE));
    }
    /*
    private static final int freeSlots = 10;
    private static final HashMap<UUID, UpperClothes> hangedShirts = new HashMap<>(freeSlots);

    @Override
    public Optional<UpperClothes> takeOff() {
        return hangedShirts.values().stream().findFirst();
        //Optional.ofNullable(hangedPants.values().stream().findFirst().get());
    }

    @Override
    public Optional<UpperClothes> takeOff(UUID id) {
        return Optional.ofNullable(hangedShirts.get(id));
    }

    @Override
    public void put(UpperClothes item) {
        try {
            hangedShirts.put(item.getId(), item);
        } catch (IllegalStateException ex) {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean hasSlotFor(Clothes.ClothesType type) {
        if (type.equals(Clothes.ClothesType.SHIRT) || type.equals(Clothes.ClothesType.BLOUSE)) {
            return freeSlots - hangedShirts.size() > 0;
        } else {
            return false;
        }
    }
*/
}
