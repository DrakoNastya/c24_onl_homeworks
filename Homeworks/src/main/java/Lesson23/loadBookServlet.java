package main.java.Lesson23;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

//Написать приложение, которое при запуске будет сообщать в консоль что оно
//работает. На любой запрос в консоли должна отображаться запись со временем этого
//запроса.
//Создать 2 эндпоинта:
///book - который будет скачивать с сервера клиенту любую книгу.
///load-book - который позволит загружать свои книги на сервер.

@WebServlet("/load-book")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class loadBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        try {
            Part filePart = req.getPart("file");
            String name = filePart.getName();
            filePart.write("C:\\Users\\ad800\\c24_onl_HW\\Homeworks\\src\\main\\java\\Lesson23\\Book" + name);
            resp.getWriter().print("The book loaded successfully ");
        } catch (Exception e) {
            resp.getWriter().print("Something wrong ");
        }


    }
}






