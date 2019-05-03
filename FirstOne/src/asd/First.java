package asd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.namespace.QName;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
       
       // Set response content type
       response.setContentType("text/html");

       PrintWriter out = response.getWriter();
       String title = "Using GET Method to Read Form Data";
//       String docType =
//          "<!doctype html public \"-//w3c//dtd html 4.0 " +
//          "transitional//en\">\n";
       

          
       out.println("" +
          "<html>\n" +
             "<head><title>" + title + "</title></head>\n" +
             "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                   "  <li><b>First Name</b>: "
                   + request.getParameter("first_name") + "\n" +
                   "  <li><b>Last Name</b>: "
                   + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
             "</body>" +
          "</html>"
       );
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
