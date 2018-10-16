package co.ppk.domain;

public class Billboard {



    private final String id;
    private final String code;
    private final String address;
    private final String createDate;
    private final String updateDate;




    private Billboard(
            String id,
            String code,
            String address,
            String createDate,
            String updateDate) {
        this.id = id;
        this.code = code;
        this.address = address;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public String getId() { return id; }
    public String getCode() { return code; }
    public String getAddress() { return address; }
    public String getCreateDate() { return createDate; }
    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private  String id;
        private  String code;
        private  String address;
        private  String createDate;
        private  String updateDate;


        public Billboard.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Billboard.Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Billboard.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Billboard.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Billboard.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Billboard build() {
            return new Billboard(id, code, address,  createDate, updateDate);
        }
    }
}
