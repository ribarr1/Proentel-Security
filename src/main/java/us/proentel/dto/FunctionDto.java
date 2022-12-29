package us.proentel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDto {
    private String username;
    private String password;


    @JsonProperty("username")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @JsonProperty("password")
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }



    @Override
    public String toString() {
        return "OperatorDto{" +

                ", username='" + username + '\'' +
                ", password='" + password + '\'' +

                '}';
    }
}
