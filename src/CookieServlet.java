import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("metoda do get");
        String option = request.getParameter("cookie");
        if("create".equals(option)){
            Cookie cookie = createCookie();
            response.addCookie(cookie);
            request.getRequestDispatcher("cookieInfo.jsp").forward(request, response);
        } else if ("print".equals(option)){
            request.getRequestDispatcher("cookieInfo.jsp").forward(request, response);
        } else if ("remove".equals(option)){
            removeCookies(request, response);
            request.getRequestDispatcher("noCookie.jsp").forward(request, response);
        }
    }


    private void removeCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c: cookies) {
            c.setMaxAge(0);
            response.addCookie(c);
        }
    }



    private Cookie createCookie() {
        Random r = new Random();
        String cookieName = "cookie"+r.nextInt(100);
        String cookieValue = "" + r.nextInt(1000);
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(1*60*60);
        return cookie;
    }

}
