package com.studentmanagement.student;


//All data for student
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Using LomBok for avoiding boiler plate code
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor 
public class Student {

	//Primary key for Student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    public String getIdFormatted() {
        return String.format("%04d", id);
    }


  //Not allow Empty
    @NotBlank(message="Student name is required")
    private String studentName;
    
    //Not allow empty DOB
    @NotNull(message = "Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    
    //Formated input of email and not allow if the email is not in format
    @Pattern(regexp = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$", message = "Invalid email format")
    private String email;
    
    //Not allow empty father name
    @NotBlank(message="Student's Fahter name is required")
    private String fatherName;
    
    //Mobile number including 09
    @Pattern(regexp = "^(09|\\+959)[1-9]\\d{7}$", message = "Invalid phone number format. It should be a 11-digit include 09 number.")
    private String phone;
    
    //Enums State 
    @NotNull(message = "State is required")
    @Enumerated(EnumType.STRING)
    private State state;
    
    //Sutend Address
    @NotBlank(message="Student address is required")
    private String address;
    
    //Myanmar NRC Regular expression
    @Pattern(regexp = "^([0-9]{1,2})\\/([A-Z][a-z]|[A-Z][a-z][a-z])([A-Z][a-z]|[A-Z][a-z][a-z])([A-Z][a-z]|[A-Z][a-z][a-z])\\([N,P,E]\\)[0-9]{6}$", message = "Invalid studentNRC")
    private String studentNRC;

    
    //Creating E-nums for 14 States of Myanmar
    public enum State {
        Kachin,
        Kayah,
        Kayin,
        Chin,
        Sagaing,
        Tanintharyi,
        Bago,
        Magway,
        Mandalay,
        Mon,
        Rakhine,
        Shan,
        Yangon,
        Ayeyarwady
    }
}
