package us.proentel.domain;

public class UserRol {



    private final String id;
    private final String userId;
    private final String rolId;
    private final String isactive;
    private final String createBy;
    private final String updateBy;
    private final String createDate;
    private final String updateDate;

    private UserRol(
            String id,
            String userId,
            String rolId,
            String isactive,
            String createBy,
            String updateBy,
            String createDate,
            String updateDate) {
        this.id = id;
        this.userId = userId;
        this.rolId = rolId;
        this.isactive = isactive;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getRolId() { return rolId; }
    public String getIsactive() { return isactive; }
    public String getCreateBy() { return createBy; }
    public String getUpdateBy() { return updateBy; }
    public String getCreateDate() { return createDate; }
    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private String id;
        private String userId;
        private  String rolId;
        private  String isactive;
        private  String createBy;
        private  String updateBy;
        private String createDate;
        private String updateDate;


        public UserRol.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public UserRol.Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserRol.Builder setRolId(String rolId) {
            this.rolId = rolId;
            return this;
        }
        public UserRol.Builder setIsactive(String isactive) {
            this.isactive = isactive;
            return this;
        }

        public UserRol.Builder setCreateBy(String createBy) {
            this.createBy = createBy;
            return this;
        }

        public UserRol.Builder setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
            return this;
        }

        public UserRol.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public UserRol.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public UserRol build() {
            return new UserRol(id,  userId, rolId, isactive, createBy, updateBy,  createDate, updateDate);
        }
    }
}
