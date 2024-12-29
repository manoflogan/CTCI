package com.manoflogan.ctci.chapter03.queue

import java.util.LinkedList

/**
 *
 */
class AnimalShelter {

    var order = 0

    private val dogs = LinkedList<Dog>()
    private val cats = LinkedList<Cat>()

    fun enqueueAny(animal: Animal) {
        order ++
        animal.order = order
        when (animal) {
            is Dog -> dogs.offerLast(animal)
            is Cat -> cats.offerLast(animal)
        }
    }

    fun dequeueAny(): Animal? {
        if (dogs.isEmpty() && cats.isEmpty()) {
            return null
        }
        val olderDog = dogs.peekFirst()
        val olderCat = cats.peekFirst()
        return if (olderCat.order < olderDog.order) {
            dogs.pollFirst()
        } else {
            cats.pollFirst()
        }
    }

    fun deqeueCat(): Cat? = cats.pollFirst()

    fun dequeueDog(): Dog? = dogs.pollFirst()

    abstract inner class Animal {
        var order: Int = 0
    }

    inner class Cat: Animal()

    inner class Dog: Animal()
}
