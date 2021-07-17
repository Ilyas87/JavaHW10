package org.itstep.Lesson10.servlet;

import org.itstep.Lesson10.entity.Car;
import org.itstep.Lesson10.service.DbService;
import org.itstep.Lesson10.service.DbServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {

    private DbService dbService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        dbService.removeCar(id);
        response.sendRedirect("/index");
    }

    @Override
    public void init() throws ServletException {
        dbService = new DbServiceImpl();
    }
}
