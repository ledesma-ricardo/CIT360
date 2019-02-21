package JSON_Practice;

import com.fasterxml.jackson.annotation.JsonView;
import java.math.BigDecimal;

public class NBAPlayer {
    
    public interface View1 {};
    public interface View2 {};
    public interface View3 {};
    public interface View4 {};
    public interface View5 {};

    @JsonView(View1.class) private String firstName;
    @JsonView(View2.class) private String lastName;
    @JsonView(View3.class) private Integer numJersey;
    @JsonView(View4.class) private BigDecimal salary; 
    @JsonView(View5.class) private String nickName;
    
    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumjersey() {
        return numJersey;
    }

    public void setNumjersey(Integer numJersey) {
        this.numJersey = numJersey;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "NBAPlayer{" + "firstName=" + firstName + ", lastName=" + lastName + ", numJersey=" + numJersey + ", salary=" + salary + ", nickName=" + nickName + '}';
    }


}
