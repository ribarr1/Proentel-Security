package us.proentel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MenuDto {
    private String parent;
    private String parent_order;
    private List<ItemsDto> items;

    @JsonProperty("parent")
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @JsonProperty("parent_order")
    public String getParent_order() {
        return parent_order;
    }

    public void setParent_order(String parent_order) {
        this.parent_order = parent_order;
    }

    @JsonProperty("items")
    public List<ItemsDto> getItems() {
        return items;
    }

    public void setItems(List<ItemsDto> items) {
        this.items = items;
    }



    @Override
    public String toString() {
        return "MenuDto{" +
                "parent='" + parent + '\'' +
                ", parent_order='" + parent_order + '\'' +
                ", items='" + items + '\'' +
                '}';
    }
}
