package us.proentel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    private String id;
    private String email;
    private String name;
    private String username;
    private String password;
    private  String isactive;
    private  String createBy;
    private  String updateBy;
    private String createDate;
    private String updateDate;

    @JsonProperty("id")
    public String getId() { return id;  }
    public void setId(String id) { this.id = id; }

    @JsonProperty("email")
    public String getEmail() { return email;  }
    public void setEmail(String email) { this.email = email;  }

    @JsonProperty("name")
    public String getName() { return name;  }
    public void setName(String name) { this.name = name;    }

    @JsonProperty("username")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @JsonProperty("password")
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @JsonProperty("isactive")
    public String getIsactive() { return isactive; }
    public void setIsactive(String isactive) { this.isactive = isactive; }

    @JsonProperty("createBy")
    public String getCreateBy() { return createBy; }
    public void setCreateBy(String createBy) { this.createBy = createBy; }

    @JsonProperty("updateBy")
    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }

    @JsonProperty("createDate")
    public String getCreateDate() { return createDate; }
    public void setCreateDate(String createDate) { this.createDate = createDate; }

    @JsonProperty("updateDate")
    public String getUpdateDate() { return updateDate;  }
    public void setUpdateDate(String updateDate) { this.updateDate = updateDate;  }

    @Override
    public String toString() {
        return "OperatorDto{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isactive='" + isactive + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}
