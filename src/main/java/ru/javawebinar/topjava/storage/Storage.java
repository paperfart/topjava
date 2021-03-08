package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface Storage {
    void update(LocalDateTime time, Meal meal);

    Meal get(LocalDateTime time);

    void delete(Meal meal);

    List<Meal> getMealList();
}
