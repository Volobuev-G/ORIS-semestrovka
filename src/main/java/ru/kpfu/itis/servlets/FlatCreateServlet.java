package ru.kpfu.itis.servlets;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.kpfu.itis.repositories.FlatRepositoryImpl;

import java.io.IOException;

@WebServlet(name = "FlatCreateServlet")
public class FlatCreateServlet extends HttpServlet {

    private FlatRepositoryImpl flatRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        flatRepository = (FlatRepositoryImpl) getServletContext().getAttribute("flatRepository");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Create flat");
    }
}
