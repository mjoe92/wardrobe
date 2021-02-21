# Wardrobe

## Story

Your company, WardROBOT is in the fashion industry who wants to sell smart wardrobes and hangers on the market.
This is the prototyping phase when you asked to create some basic functionality for
this revolutionary furniture. It shouldn't have a graphical interface for the time being
only a simple console version. Just to see the different wardrobe scenarios.

## What are you going to learn?

You'll have to:

- practice the principles of object oriented programming
- use built-in exceptions
- use generics
- use Optionals and streams
- run tests

## Tasks

1. There are different clothes that can be placed on hangers.
    - All clothes have a unique identifier (UUID) field named `id` which is set when created. Cannot be changed later. Available via `UUID getId()` method.
    - Every clothes has a `brandName` field which can be set only once at creation. It can received by calling `getBrandName` method.
    - Each clothes must have a `type` field, which is different for different kinds of clothing.
This can be one from the following list:
- shirt
- blouse
- trousers
- skirt
    - There is a special type of clothing named `UpperClothes`. Its type can be only `shirt` or `blouse`. In other case should throw `IllegalArgumentException`.
    - There is a special type of clothing named `LowerClothes`. Its type can be only `trousers` or `skirt`. In other case should throw `IllegalArgumentException`.

2. There are different types of hangers which can store different clothes in different ways.
    - All `Hanger`'s have the following capabilities:
- `Optional<Clothes> takeOff()` -> returns one clothes at a time stored on hanger
- `Optional<Clothes> takeOff(UUID id)` -> returns the requested clothes by id. If the clothes is not on the hanger returns empty
- `void put(Clothes clothes)` -> put clothes on hanger if there is free slot otherwise throws `IllegalStateException`
- `boolean hasSlotFor(ClothesType type)` -> defines that is there a free slot for a particular ClothesType
    - `ShirtHanger` can accommodate only those clothes that can be worn on the upper body (shirts and blouses). As a `ShirtHanger` can accommodate only one piece of upper clothes, `hasSlotFor` method is only true when the hanger doesn't store any upper clothes at the moment. We can take off the currently stored piece of clothes or try to take off by it's id.
    - `PantHanger` can accommodate one piece of an upper clothes plus one piece of trousers or skirts. Based on the `put(Clothes clothes)` parameter runtime type it is automatically place the clothes to proper slot. If no place for the particular type it signals this illegal state.
    - `hasSlotFor` method returns with true if the hanger has free slot for the requested clothes type.
    - We have the possibility to take off the upper and lower clothes one-by-one from a PantHanger via the `Optional<Clothes> takeOff()` method. It always returns first the upper clothes when it is accommodated. Only if upper is empty than returns with the lower clothes.

3. Wardrobe is a storage for clothes but there are some rules how these clothes can be placed in it.
    - A `Wardrobe` can accommodate only a certain number of hangers, field named `limit` (the actual `limit` can vary between different wardrobes). This `limit` is defined at creation time and cannot be changed afterwards. It can be queried at any time by `getLimit()` method. The `limit` cannot be bigger than `120`. In case somebody tries to create a `Wardrobe` with 120+ limit than code should throw `IllegalArgumentException` with a message: 'Maximum limit is 120.'
    - There is a method which enables placing a hanger into the wardrobe. It should be named `put(Hanger hanger)`. If there is free place in wardrobe the hanger is stored.
    - Make sure that you don't allow more than physically possible. In case of putting hanger when wardrobe is full, the method throws a `IllegalStateException` with a message 'The wardrobe currently is full.'
    - Empty hangers can be put into the wardrobe by calling `put(Hanger hanger)`.
    - There is a method `count()` which returns the amount of placed hangers in the wardrobe.
    - Hangers with clothes on them can be placed in wardrobe by calling `put(Hanger hanger)`
    - A piece of clothing can only be hanged in the wardrobe if it's on a hanger already – you can't hang a shirt directly into the wardrobe.
    - You can get an empty hanger by `Hanger getHanger(ClothesType type)` method. It returns an available hanger. In case of no free hangers in wardrobe it should throw `NoSuchElementException` with a message 'No empty hangers for your clothes'.
    - Clothes can be taken out of the wardrobe by their unique identifier by calling the `Clothes getClothes(UUID id)` method. In case the searched clothes isn't in the wardrobe it should raise an `NoSuchElementException` with a message 'Clothes not found.'.

## General requirements

- All test results are green.
- All code is pushed to GitHub repository by atomic commits. The implemented feature related commits managed on separated feature branches and merged by a pull request to the `master` branch.

## Hints

- You can draw some inspiration from the provided unit tests for other projects
- In case of wardrobe's take off functionality try to use streams
- Always check what is the expected exception message when throwing exception is required
- You can run tests in your IDE easily as follows:
  ![Run tests in your IDE](media/java/run-tests.gif)


## Background materials

- <i class="far fa-exclamation"></i> [Nulls are evil](project/curriculum/materials/pages/java/java-nulls-are-evil.md)
- <i class="far fa-exclamation"></i> [Guide to Java 8 Optional](https://www.baeldung.com/java-optional)
- <i class="far fa-exclamation"></i> [Exception handling](project/curriculum/materials/pages/java/exception-handling.md)
- <i class="far fa-exclamation"></i> [Generics](project/curriculum/materials/competencies/java-data-structures/java-generics.md.html)
- <i class="far fa-candy-cane"></i> [Functional programming](project/curriculum/materials/pages/general/functional-programming.md)
- <i class="far fa-candy-cane"></i> [Functional elements in Java](project/curriculum/materials/pages/java/functional-elements-in-java.md)
- <i class="far fa-candy-cane"></i> [Java streams](https://www.baeldung.com/java-streams)
- <i class="far fa-book-open"></i> [Software testing](project/curriculum/materials/pages/general/software-testing.md)

