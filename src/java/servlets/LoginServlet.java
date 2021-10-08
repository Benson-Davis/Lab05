
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
        
        User theUser = bouncer.login(username, password);
        
        //check if either box is empty or if username or password is wrong
        if(username == null || username.equals("") || password == null || password.equals("") || theUser == null)
        {
            //create an attribute that is a boolean to flag if the validation was tripped
            request.setAttribute("invalidInput", true);
            //display form again
            request.setAttribute("uname", username);
            request.setAttribute("psswd", password);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else 
        {
            
        }
    }


}
