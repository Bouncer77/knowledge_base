package boost.brain.youtube.http.servlet;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* Вариант с прямым доступом к объекту сессии
* */

@WebServlet("/servlet")
public class HttpSessionServlet extends HttpServlet {

    private static final String NAME = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Достать объект сессии
        HttpSession httpSession = req.getSession();

        // Если объект сессии отсутствует, вернуть ошибку
        if(httpSession == null){
            resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return;
        }

        // Достаем параметр запроса из запроса
        String name = req.getParameter(NAME);
        // Если параметр 'name'
        if(!StringUtils.isEmpty(name)){
            httpSession.setAttribute(NAME, name); // сохранить в хранилище, доступное по сессии
            resp.getWriter().println("New name have been received - " + name);
            return;
        }

        // Если в запросе не было имени, то пытаемся достать атрибут из сессии
        Object nameAttribute = httpSession.getAttribute(NAME);
        // Если атрибут из сессии не является строкой, то ошибка
        if(!(nameAttribute instanceof String)){
            resp.getWriter().println("There is no saved name");
            return;
        }

        // Преобразуем полученный атрибут к строке
        String currentName = (String) nameAttribute;
        resp.getWriter().println("Current name: " + currentName);
    }
}
