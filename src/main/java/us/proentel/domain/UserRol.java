package us.proentel.domain;

public class Rol {



    private final String id;
    private final String name;
    private final String isactive;
    private final String createBy;
    private final String updateBy;
    private final String createDate;
    private final String updateDate;

    private Rol(
            String id,
            String name,
            String isactive,
            String createBy,
            String updateBy,
            String createDate,
            String updateDate) {
        this.id = id;
        this.name = name;
        this.isactive = isactive;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public String getId() { return id; }
    public String getName() { return name; }
    public String getIsactive() { return isactive; }
    public String getCreateBy() { return createBy; }
    public String getUpdateBy() { return updateBy; }
    public String getCreateDate() { return createDate; }
    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private String id;
        private String name;
        private  String isactive;
        private  String createBy;
        private  String updateBy;
        private String createDate;
        private String updateDate;


        public Rol.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Rol.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Rol.Builder setIsactive(String isactive) {
            this.isactive = isactive;
            return this;
        }

        public Rol.Builder setCreateBy(String createBy) {
            this.createBy = createBy;
            return this;
        }

        public Rol.Builder setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
            return this;
        }

        public Rol.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Rol.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Rol build() {
            return new Rol(id,  name, isactive, createBy, updateBy,  createDate, updateDate);
        }
    }
}
