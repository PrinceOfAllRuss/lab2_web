package com.main.lab2_2.controller;

import java.io.*;

import com.main.lab2_2.model.ResultBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ResultBean result = (ResultBean) request.getSession().getAttribute("resultBean");
        if (result == null) {
            result = new ResultBean();
            request.getSession().setAttribute("resultBean", result);
        }
        request.getSession().setAttribute("startTime", System.currentTimeMillis());
        request.getSession().setAttribute("error", "All good");
        request.getRequestDispatcher("/area-check").forward(request, response);
    }
}