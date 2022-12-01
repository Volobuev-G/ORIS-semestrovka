package ru.kpfu.itis.servlets;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.kpfu.itis.models.Flat;
import ru.kpfu.itis.repositories.FlatRepositoryImpl;

import java.io.IOException;

@WebServlet(name = "FlatDetailServlet", value = "/flat/detail")
public class FlatDetailServlet extends HttpServlet {

    private FlatRepositoryImpl flatRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        flatRepository = (FlatRepositoryImpl) getServletContext().getAttribute("flatRepository");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Bad request. No id has been provided");
        }
        Flat flat = flatRepository.findById(Long.valueOf(id)).get();
        if (flat == null) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            getServletContext().getRequestDispatcher("/WEB-INF/views/errors/notfound.jsp").forward(request,response);
        }
        request.setAttribute("flat",flat);
        getServletContext().getRequestDispatcher("/WEB-INF/views/flats/detail.jsp").forward(request,response);
    }
}
