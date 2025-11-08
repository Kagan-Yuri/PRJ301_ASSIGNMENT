/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author dv15312
 */
// ApproveServlet.java
import dal.RequestDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import java.io.IOException;

@WebServlet("/requests/approve")
public class ApproveServlet extends HttpServlet {
    RequestDBContext dao = new RequestDBContext();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) { resp.sendRedirect(req.getContextPath() + "/login"); return; }
        int requestId = Integer.parseInt(req.getParameter("requestId"));
        String action = req.getParameter("action"); // approve or reject
        String note = req.getParameter("note");

        try {
            if ("approve".equalsIgnoreCase(action)) {
                dao.updateStatus(requestId, "APPROVED", user.getId(), note);
            } else {
                dao.updateStatus(requestId, "REJECTED", user.getId(), note);
            }
            resp.sendRedirect(req.getContextPath() + "/requests");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

