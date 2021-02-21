package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;

import java.util.*;

/**
 * The task of the class is to model a wardrobe.
 */
public class Wardrobe {

    private final int limit;
    private final List<Hanger> hangers;

    public Wardrobe(int limit) {
        this.limit = Optional.of(limit).filter(v -> v <= 120).orElseThrow(() -> new IllegalArgumentException("Maximum limit is 120."));
        this.hangers = new ArrayList<>(limit);
    }

    public int getLimit() {
        return limit;
    }

    public int count() {
        return hangers.size();
    }

    public void put(Hanger<? extends Clothes> hanger) {
        if (count() < limit) {
            hangers.add(hanger);
        } else {
            throw new IllegalStateException("The wardrobe currently is full.");
        }
    }

    public Hanger<? extends Clothes> getHanger(Clothes.ClothesType clothesType) {

        if (clothesType.equals(Clothes.ClothesType.SHIRT) || clothesType.equals(Clothes.ClothesType.BLOUSE)) {
            return hangers.stream().filter(h -> h.hasSlotFor(clothesType)).findFirst().get();
        } else {
            return hangers.stream().filter(h -> h.hasSlotFor(clothesType)).findFirst()
                    .orElseThrow(() -> new NoSuchElementException("No empty hangers for your clothes."));
        }
    }

    public Clothes getClothes(UUID clothesId) {

        return (Clothes) hangers.stream().filter(c -> c.takeOff(clothesId).isPresent()).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Clothes not found.")).takeOff(clothesId).get();

    }

    // The main method with this declaration is the entry point of Java applications.
    public static void main(String[] args) {
        // Create an instance of our class with the test data.
        System.out.println("Hello WardROBO");
    }
}
