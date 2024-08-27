package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author upekhansaja
 */
@MultipartConfig
@WebServlet(name = "User_Registration", urlPatterns = {"/User_Registration"})
public class User_Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Gson gson = new Gson();
        User user = gson.fromJson(req.getReader(), User.class);
        
        System.out.println(user.getMobile());
        System.out.println(user.getName());
        System.out.println(user.getGender());
        System.out.println(user.getCountry());
        System.out.println(user.getPassword());
    }

}
