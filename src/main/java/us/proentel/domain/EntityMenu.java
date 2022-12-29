package us.proentel.domain;

public class EntityMenu {



    private final String idEntity;
    private final String numberEntity;
    private final String nameEntity;
    private final String path;



    private EntityMenu(
            String idEntity,
            String numberEntity,
            String nameEntity,
            String path) {
        this.idEntity = idEntity;
        this.numberEntity = numberEntity;
        this.nameEntity = nameEntity;
        this.path = path;
    }


    public String getIdEntity() { return idEntity; }
    public String getNumberEntity() { return numberEntity; }
    public String getNameEntity() { return nameEntity; }
    public String getPath() { return path; }

    public static class Builder {
        private String idEntity;
        private String numberEntity;
        private String nameEntity;
        private String path;


        public EntityMenu.Builder setIdEntity(String idEntity) {
            this.idEntity = idEntity;
            return this;
        }

        public EntityMenu.Builder setNumberEntity(String numberEntity) {
            this.numberEntity = numberEntity;
            return this;
        }

        public EntityMenu.Builder setNameEntity(String nameEntity) {
            this.nameEntity = nameEntity;
            return this;
        }

        public EntityMenu.Builder setPath(String path) {
            this.path = path;
            return this;
        }


        public EntityMenu build() {
            return new EntityMenu(idEntity, numberEntity,nameEntity, path);
        }
    }
}
