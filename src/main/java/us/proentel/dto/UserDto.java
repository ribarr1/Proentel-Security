package us.proentel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityDto {
    private String id;
    private String code;
    private String name;
    private String code_state;
    private  String isactive;
    private  String createBy;
    private  String updateBy;
    private String createDate;
    private String updateDate;

    @JsonProperty("id")
    public String getId() { return id;  }
    public void setId(String id) { this.id = id; }

    @JsonProperty("code")
    public String getCode() { return code;  }
    public void setCode(String code) { this.code = code;  }

    @JsonProperty("name")
    public String getName() { return name;  }
    public void setName(String name) { this.name = name;    }

    @JsonProperty("code_state")
    public String getCode_state() { return code_state; }
    public void setCode_state(String code_state) { this.code_state = code_state; }

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
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", code_state='" + code_state + '\'' +
                ", isactive='" + isactive + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}
