package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.storage.ListStorage;
import ru.javawebinar.topjava.storage.Storage;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private final Storage storage = new ListStorage();
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String oldTime = req.getParameter("oldtime");
        LocalDateTime oldTimes = oldTime.equals("") ? LocalDateTime.now() : LocalDateTime.parse((oldTime));
        LocalDateTime time = TimeUtil.formatDate(req.getParameter("time").trim());
        String description = req.getParameter("description");
        String calories = req.getParameter("calories");
        storage.update(oldTimes, new Meal(time, description, Integer.parseInt(calories)));
        resp.sendRedirect("meals");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meal");
        String action = request.getParameter("action");
        String time = request.getParameter("time");
        if (action == null) {
            List<MealTo> mealToList = MealsUtil.transformMealTo(storage.getMealList());
            request.setAttribute("meals", mealToList);
            request.getRequestDispatcher("/WEB-INF/jsp/meals.jsp").forward(request, response);
            return;
        }
        Meal meal;
        switch (action) {
            case "delete":
                meal = storage.get(LocalDateTime.parse(time));
                storage.delete(meal);
                response.sendRedirect("meals");
                break;
            case "edit":
                meal = storage.get(LocalDateTime.parse(time));
                request.setAttribute("meal", meal);
                request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
                break;
            case "new":
                meal = new Meal(null, "", 0);
                request.setAttribute("meal", meal);
                request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
                break;
        }
        // response.sendRedirect("meal.jsp");
    }

}
