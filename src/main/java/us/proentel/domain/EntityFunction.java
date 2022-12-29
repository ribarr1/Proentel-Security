package us.proentel.domain;

public class EntityFunction {



    private final String nameFunction;


    private EntityFunction(
            String nameFunction) {
        this.nameFunction = nameFunction;
    }


    public String getNameFunction() { return nameFunction; }

    public static class Builder {
        private String nameFunction;

        public EntityFunction.Builder setNameFunction(String nameFunction) {
            this.nameFunction = nameFunction;
            return this;
        }



        public EntityFunction build() {
            return new EntityFunction(nameFunction);
        }
    }
}
