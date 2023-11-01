package main.java.Lesson23;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.time.LocalTime;

@WebServlet("/*")
public class InfoServlet extends HttpServlet {
    @Override
    public String getServletInfo() {
        String str = "Time: " + LocalTime.now() + " The application is working ";
        return str;
    }
}
