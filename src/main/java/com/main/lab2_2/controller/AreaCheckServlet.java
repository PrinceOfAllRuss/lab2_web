package com.main.lab2_2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.lab2_2.model.ResultBean;
import com.main.lab2_2.model.ElementForTable;
import com.main.lab2_2.model.Validator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/area-check")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        String event = request.getParameter("event");
        Validator validator = new Validator();
        if (validator.inputDataCheck(x, y, r, event)) {
            double[] arrY = objectMapper.readValue(y, double[].class);
            ResultBean result = (ResultBean) request.getSession().getAttribute("resultBean");
            for (double elY : arrY) {
                ElementForTable element = new ElementForTable(x, Double.toString(elY), r);
                validator.checkPointInArea(element);
                element.setTimeOfWork(System.nanoTime());
                result.getListOfResults().add(element);
            }
            String jsonDotsList = result.toAllDots().toJson();
            request.getSession().setAttribute("dots", jsonDotsList);
        } else {
            request.getSession().setAttribute("error", "Wrong data");
        }
        request.getRequestDispatcher("table.jsp").forward(request, response);
    }

}
