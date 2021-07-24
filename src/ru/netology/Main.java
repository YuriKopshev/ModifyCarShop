package ru.netology;

public class Main {

    public static void main(String[] args) {
        final CarShop shop = new CarShop();
        new Thread(null, shop::buyNewCar, "Покупатель 1").start();
        new Thread(null, shop::buyNewCar, "Покупатель 2").start();
        new Thread(null, shop::buyNewCar, "Покупатель 3").start();
        new Thread(null, shop::buyNewCar, "Покупатель 4").start();
        new Thread(null, shop::buyNewCar, "Покупатель 5").start();
        new Thread(null, shop::buyNewCar, "Покупатель 6").start();
        new Thread(null, shop::buyNewCar, "Покупатель 7").start();
        new Thread(null, shop::buyNewCar, "Покупатель 8").start();
        new Thread(null, shop::buyNewCar, "Покупатель 9").start();
        new Thread(null, shop::buyNewCar, "Покупатель 10").start();
        new Thread(null, shop::receiveCar, "Производитель").start();
        new Thread(null, shop::receiveCar, "Производитель").start();
        new Thread(null, shop::receiveCar, "Производитель").start();
        new Thread(null, shop::receiveCar, "Производитель").start();
        new Thread(null, shop::receiveCar, "Производитель").start();
        new Thread(null, shop::receiveCar, "Производитель").start();
        new Thread(null, shop::receiveCar, "Производитель").start();
        new Thread(null, shop::receiveCar, "Производитель").start();
        new Thread(null, shop::receiveCar, "Производитель").start();
        new Thread(null, shop::receiveCar, "Производитель").start();

    }
}
