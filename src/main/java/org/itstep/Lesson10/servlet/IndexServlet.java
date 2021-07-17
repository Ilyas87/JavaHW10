package org.itstep.Lesson10.servlet;

import lombok.extern.java.Log;
import org.itstep.Lesson10.entity.Car;
import org.itstep.Lesson10.service.DbService;
import org.itstep.Lesson10.service.DbServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@Log
@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {

    private DbService dbService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> allCars = dbService.getAllCars();

        log.info("CARS===========" + allCars.toString());

        request.setAttribute("cars", allCars);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        Double engineVolume = Double.valueOf(request.getParameter("engine_volume"));
        Car car = new Car(null, name, engineVolume, price);

        dbService.addCar(car);

        response.sendRedirect("/index");
    }

    @Override
    public void init() throws ServletException {
        dbService = new DbServiceImpl();
    }
}
