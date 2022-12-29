package us.proentel.domain;

public class User {



    private final String id;
    private final String email;
    private final String name;
    private final String username;
    private final String password;
    private final String isactive;
    private final String createBy;
    private final String updateBy;
    private final String createDate;
    private final String updateDate;

    private User(
            String id,
            String email,
            String name,
            String username,
            String password,
            String isactive,
            String createBy,
            String updateBy,
            String createDate,
            String updateDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isactive = isactive;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getIsactive() { return isactive; }
    public String getCreateBy() { return createBy; }
    public String getUpdateBy() { return updateBy; }
    public String getCreateDate() { return createDate; }
    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private String id;
        private String email;
        private String name;
        private String username;
        private String password;
        private  String isactive;
        private  String createBy;
        private  String updateBy;
        private String createDate;
        private String updateDate;


        public User.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public User.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public User.Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public User.Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User.Builder setIsactive(String isactive) {
            this.isactive = isactive;
            return this;
        }

        public User.Builder setCreateBy(String createBy) {
            this.createBy = createBy;
            return this;
        }

        public User.Builder setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
            return this;
        }

        public User.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public User.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public User build() {
            return new User(id, email, name,username, password, isactive, createBy, updateBy,  createDate, updateDate);
        }
    }
}
