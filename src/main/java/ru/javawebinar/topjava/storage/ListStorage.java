package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListStorage implements Storage {

    private static final List<Meal> storage = new ArrayList<>();

    static {
        storage.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        storage.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        storage.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        storage.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        storage.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        storage.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        storage.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
    }

    private Integer searchIndex(LocalDateTime time) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getDateTime().equals(time)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(LocalDateTime time, Meal meal) {
        int index = searchIndex(time);
        if (index != -1) {
            storage.set(index, meal);
        }
        storage.add(meal);

    }

    @Override
    public Meal get(LocalDateTime time) {
        return storage.get(searchIndex(time));
    }

    @Override
    public void delete(Meal meal) {
        storage.remove(meal);
    }

    @Override
    public List<Meal> getMealList() {
        return storage;
    }
}
