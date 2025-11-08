/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author dv15312
 */

import dal.RequestDBContext;
import jakarta.servlet.ServletException;
import model.Request;
import model.User;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/requests")
public class ListRequestServlet extends HttpServlet {

    RequestDBContext dao = new RequestDBContext();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        try {
            List<Request> mine = dao.listByUser(user.getId());
            List<Request> sub = dao.listBySubordinates(user.getId());
            req.setAttribute("mine", mine);
            req.setAttribute("sub", sub);
            req.getRequestDispatcher("/jsp/listRequests.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
