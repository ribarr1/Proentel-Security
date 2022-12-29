package us.proentel.domain;

public class City {



    private final String id;
    private final String code;
    private final String name;
    private final String code_state;
    private final String isactive;
    private final String createBy;
    private final String updateBy;
    private final String createDate;
    private final String updateDate;

    private City(
            String id,
            String code,
            String name,
            String code_state,
            String isactive,
            String createBy,
            String updateBy,
            String createDate,
            String updateDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.code_state = code_state;
        this.isactive = isactive;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public String getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getCode_state() { return code_state; }
    public String getIsactive() { return isactive; }
    public String getCreateBy() { return createBy; }
    public String getUpdateBy() { return updateBy; }
    public String getCreateDate() { return createDate; }
    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private String id;
        private String code;
        private String name;
        private String code_state;
        private  String isactive;
        private  String createBy;
        private  String updateBy;
        private String createDate;
        private String updateDate;


        public City.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public City.Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public City.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public City.Builder setCode_state(String code_state) {
            this.code_state = code_state;
            return this;
        }

        public City.Builder setIsactive(String isactive) {
            this.isactive = isactive;
            return this;
        }

        public City.Builder setCreateBy(String createBy) {
            this.createBy = createBy;
            return this;
        }

        public City.Builder setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
            return this;
        }

        public City.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public City.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public City build() {
            return new City(id, code, name,code_state, isactive, createBy, updateBy,  createDate, updateDate);
        }
    }
}
