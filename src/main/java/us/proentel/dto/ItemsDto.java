package us.proentel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ItemsDto {
    private String order;
    private String name;
    private String path;
    private List<FunctionDto> function;



    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("functions")
    public List<FunctionDto> getFunction() {
        return function;
    }

    public void setFunction(List<FunctionDto> function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "ItemsDto{" +
                "order='" + order + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", functions='" + function + '\'' +
                '}';
    }
}
