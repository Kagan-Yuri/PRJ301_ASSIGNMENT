/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author dv15312
 */
// CreateRequestServlet.java
import dal.RequestDBContext;
import jakarta.servlet.ServletException;
import model.Request;
import model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/requests/create")
public class CreateRequestServlet extends HttpServlet {
    RequestDBContext dao = new RequestDBContext();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/createRequest.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        String title = req.getParameter("title");
        Date from = Date.valueOf(req.getParameter("from_date"));
        Date to = Date.valueOf(req.getParameter("to_date"));
        String reason = req.getParameter("reason");

        Request r = new Request();
        r.setTitle(title);
        r.setFromDate(from);
        r.setToDate(to);
        r.setReason(reason);
        r.setCreatedBy(user.getId());

        try {
            dao.create(r);
            resp.sendRedirect(req.getContextPath() + "/requests");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

