
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author bdavi
 */
public class LoginServlet extends HttpServlet
{


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //get session and attempt to create a User based on session's stored User
        HttpSession session = request.getSession();  
        User checkUser = (User)session.getAttribute("user");
        if(checkUser == null)//no user exists, this is a new session. Load login page as normal
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else if(request.getParameter("logout") != null)//check if user got here by clicking logout on home page
        {
            //invalidate the session, expunging login credentials
            session.invalidate();
            //set attribute so proper message is displayed
            request.setAttribute("loggedOut", true);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else //user is logged in and trying to reach login screen
        {
            response.sendRedirect("home");
        }
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //activates when the user clicks the log in button on the login form
        AccountService bouncer = new AccountService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        User theUser = bouncer.login(username, password);//will return null of login fails
        session.setAttribute("user", theUser);
        
        //check if either box is empty or if username or password is wrong
        if(username == null || username.equals("") || password == null || password.equals("") || theUser == null)
        {
            //create an attribute that is a boolean to flag if the validation was tripped
            request.setAttribute("invalidInput", true);
            //display form again
            session.setAttribute("uname", username);
            session.setAttribute("psswd", password);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else 
        {
            //store username in session variable and then redirect user to HomeServlet
            session.setAttribute("uname", username);
            response.sendRedirect("home");
        }
    }


}
