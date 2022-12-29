package us.proentel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FunctionDto {
    private String function;

    @JsonProperty("function")
    public String getFunction() { return function; }
    public void setFunction(String function) { this.function = function; }



    @Override
    public String toString() {
        return "FunctionDto{" +

                " functions='" + function + '\'' +

                '}';
    }
}
