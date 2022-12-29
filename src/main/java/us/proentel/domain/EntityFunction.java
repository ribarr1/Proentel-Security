package us.proentel.domain;

public class Menu {



    private final String id;
    private final String name;
    private final String number;


    private Menu(
            String id,
            String name,
            String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }


    public String getId() { return id; }
    public String getName() { return name; }
    public String getNumber() { return number; }

    public static class Builder {
        private String id;
        private String name;
        private String number;


        public Menu.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Menu.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Menu.Builder setNumber(String number) {
            this.number = number;
            return this;
        }


        public Menu build() {
            return new Menu(id, name,number);
        }
    }
}
