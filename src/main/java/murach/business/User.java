package murach.business;

import java.io.Serializable;

public class User implements Serializable {
    //implements Serializable
    //Quy tắc get - set
    // Quy tắc Name Conventions
    
    // Trường cơ bản
    private String firstName;
    private String lastName;
    private String email;
    
    // Trường mới
    private String dateOfBirth; // Trường Ngày sinh
    private String heardFrom; // Từ nhóm Radio Buttons: Search engine, Social Media, v.v.
    private String contactOK; // Checkbox 1: YES, I'd like that.
    private String emailOK; // Checkbox 2: YES, please send me email announcements.
    private String contactMethod; // Từ Dropdown: Email or postal mail

    // Constructor mặc định
    public User() {
        firstName = "";
        lastName = "";
        email = "";
        dateOfBirth = "";
        heardFrom = "unknown"; // Giá trị mặc định
        contactOK = "No";
        emailOK = "No";
        contactMethod = "unknown";
    }
    
    // Constructor đầy đủ (Bạn có thể bỏ qua nếu chỉ dùng constructor mặc định và setters)
    // Tôi chỉ liệt kê các getters/setters cho mục đích này

    // --- GETTERS VÀ SETTERS CŨ ---
    public String getFirstName() { 
        return firstName; 
    }
    
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
    
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }

    // --- GETTERS VÀ SETTERS MỚI ---
    public String getDateOfBirth() { 
        return dateOfBirth; 
    }
    
    public void setDateOfBirth(String dateOfBirth) { 
        this.dateOfBirth = dateOfBirth; 
    }

    public String getHeardFrom() { 
        return heardFrom; 
    }
    
    public void setHeardFrom(String heardFrom) { 
        this.heardFrom = heardFrom; 
    }

    // Trong Model, chúng ta chỉ cần String để lưu giá trị.
    public String getContactOK() { 
        return contactOK; 
    }
    
    public void setContactOK(String contactOK) { 
        this.contactOK = contactOK; 
    }

    public String getEmailOK() { 
        return emailOK; 
    }
    
    public void setEmailOK(String emailOK) { 
        this.emailOK = emailOK; 
    }

    public String getContactMethod() { 
        return contactMethod; 
    }
    
    public void setContactMethod(String contactMethod) { 
        this.contactMethod = contactMethod; 
    }
}