package craig_proj;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CosNaming.IstringHelper;

@WebServlet("/project")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Hashtable users = new Hashtable();
	
    public LogInServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getAction(request, response);
	}
	
	private void getAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usrname = request.getParameter("username");
		String pswrd = request.getParameter("password");
		Cookie[] cke = request.getCookies();

		if (usrname != "" && pswrd != "" && pswrd.equals(users.get(usrname))) {
			storeName(request, usrname);
			setHeader(response, usrname, cke);
			response.sendRedirect("./welcome.jsp");
		}
		else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND,"Not recognized.");
		}
	}

	private void setHeader(HttpServletResponse response, String usrname,
		Cookie[] cke) {
		response.setHeader("Cookie-Monster", usrname + ' ' + "has visited" 
							+ ' ' + cke.length + ' ' + "times");
	}

	private void storeName(HttpServletRequest request, String usrname) {
		HttpSession session = request.getSession(true);
		session.setAttribute("username", usrname);
		session.getAttribute(usrname);
	}

	private java.util.Date getDate() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	@SuppressWarnings("unchecked")
	public void init() {
		users.put("drew", "pass1");
		users.put("webuser", "pass2");
		users.put("amir", "pass3");
	}
}
