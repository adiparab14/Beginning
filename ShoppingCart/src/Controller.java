

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shoppingcart.action.ShoppingCart;
import com.shoppingcart.bean.ProductBean;
import com.shoppingcart.dao.*;
import com.shoppingcart.util.ConnectionDtls;
import com.shoppingcart.util.DBConnection;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductBean b = new ProductBean();
		Dao d = new Dao();
		ShoppingCart s = new ShoppingCart();
		//System.out.println(request.getParameter("id"));
		String work = request.getParameter("work");
		//System.out.println(work);
		//System.out.println(request.getParameter("username"));
		//System.out.println(request.getParameter("password"));
		if(work.equals("updateProduct"))
			
		{
			s.updateProduct(request,response);
		}
		
		if(work.equals("singleProductView"))
		{
			
			//System.out.println("A"+id);
			try {
				s.singleProductEdit(request, response);
				request.getRequestDispatcher("/jsp/editproductinfo.jsp").forward(request, response);
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(work.equals("listview"))
		{
			
			try {
				s.listProducts(request, response);
				request.getRequestDispatcher("/jsp/editproducts.jsp").forward(request, response);
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(work.equals("productadd"))
		{
			try {
				s.addProducts(request, response);
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		if(work.contains("admin"))
		{
			if(work.equals("adminLogin"))
			{
				//System.out.println("Hello");
				
				try {
					String message = s.verifyAdmin(request, response);
					if(message.equalsIgnoreCase("Invalid Username") || message.equalsIgnoreCase("Invalid password"))
					{
						request.setAttribute("message", message);
						request.getRequestDispatcher("/jsp/adminlogin.jsp").forward(request, response);
					
					}
					else
					{
						HttpSession session = request.getSession();
						//session.setMaxInactiveInterval(1);
						request.setAttribute("message", message);
						request.getRequestDispatcher("/jsp/adminhome.jsp").forward(request, response);
					}
						
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			else
				if(work.equals("adminLogout"))
				{
					request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
				}
		
		
			}

		}
	}
