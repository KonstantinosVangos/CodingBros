
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="error_aueb.jsp" %>
<%@ page import="auebproject.User, auebproject.UserDAO" %>
<%
    // ???? pa?a ?t??? ap? t? request
    String username = request.getParameter("username");
    String password = request.getParameter("password");
   UserDAO userDAO = new UserDAO();
    try {
                User user = userDAO.authenticate(username, password);

        if (user != null) {
            session.setAttribute("userObj2024", user);

            response.sendRedirect("whereto.jsp");
        } else {
            
            request.setAttribute("message", "Invalid username or password. Please try again.");

            request.getRequestDispatcher("login_aueb_path.jsp").forward(request, response);
        }
    } catch (Exception e) {
        request.setAttribute("message", "An error occurred. Please try again later." + e.getMessage());
        request.getRequestDispatcher("login_aueb_path.jsp").forward(request, response);
    }
%>
%>
