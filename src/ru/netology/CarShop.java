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

    public Car buyNewCar() {
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
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            lock.unlock();
        }
        return getCarList().remove(0);
    }

    public void receiveCar() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " поставил в салон новое авто");
            int getCarTimeOut = 3000;
            Thread.sleep(getCarTimeOut);
            carList.add(new Car("Toyota"));
            condition.signal();
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


