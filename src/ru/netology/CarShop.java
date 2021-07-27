package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarShop {
    List<Car> carList = new ArrayList<>(10);
    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    public void buyNewCar() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " зашел в магазин");
            int customerTimeOut = 1000;
            Thread.sleep(customerTimeOut);
            while (getCarList().size() == 0) {
                System.out.println("Нет машин в продаже");
                condition.await();
            }
            Thread.sleep(customerTimeOut);
            System.out.println(Thread.currentThread().getName() + " уехал на новой " + getCarList().get(0).getName());
            getCarList().remove(0);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void receiveCar() {
        int carCount = 10;
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " поставил в салон новые авто");
            int getCarTimeOut = 3000;
            Thread.sleep(getCarTimeOut);
            for (int i = 0; i < carCount; i++) {
                carList.add(new Car("Toyota"));
                condition.signal();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}


