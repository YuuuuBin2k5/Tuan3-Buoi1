package murach.email;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import murach.business.User;

// Cần cấu hình URL Pattern trong web.xml hoặc sử dụng @WebServlet
// Vì bạn đang sử dụng /survey, tôi sẽ đặt tên là SurveyServlet và giả định cấu hình:
// @WebServlet("/survey") 
@WebServlet(name = "EmailListServlet", urlPatterns = {"/emailList"}
        , initParams={@WebInitParam(name="relativePathToFile", value="/WEB-INF/EmailList.txt")}) 
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/survey.html"; // Mặc định chuyển về trang chính

        // Lấy action (Giả định bạn đã thêm input hidden name="action" value="add" trong form)
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }
        
        // **QUAN TRỌNG: Form Survey của bạn có action="survey", không có action="add"**
        // Tôi sẽ sửa logic để xử lý việc submit form Survey:
        
        if (action.equals("join")) {
             // Thường dùng để hiển thị form
            url = "/survey.jsp"; 
        } else { // Xử lý dữ liệu form (submit)
            
            // Lấy tham số từ request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String heardFrom = request.getParameter("heardFrom");
            String contactOKParam = request.getParameter("contactOK");
            String emailOKParam = request.getParameter("emailOK");
            String contactMethod = request.getParameter("contactMethod");
            
            String message;
            if (firstName == null || lastName == null || 
                email == null ||
                firstName.isEmpty() || lastName.isEmpty() || 
                email.isEmpty()) {
                
                message = "Vui lòng nhập đầy đủ vào các trường không để trống!!!";
                request.setAttribute("errorMessage", message);
                url = "/survey.jsp";
            } else {
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setDateOfBirth(dateOfBirth);
                user.setHeardFrom(heardFrom);
                user.setContactMethod(contactMethod);
                
                
                request.setAttribute("user", user);
                message = "";
                
                // Xử lý Checkbox (Checkbox chỉ gửi giá trị nếu được chọn)
                user.setContactOK(contactOKParam != null ? "Yes" : "No");
                user.setEmailOK(emailOKParam != null ? "Yes" : "No");
                url = "/thanks.jsp";
//                UserDB.insert(user);
            }
                
        }
        
        // forward request và response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
    
    // Giữ nguyên doGet gọi doPost
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }    
}