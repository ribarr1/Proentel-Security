package co.ppk.domain;

public class Rate {



    private final String id;
    private final String date;
    private final String value;
    private final String status;
    private final String createDate;
    private final String updateDate;




    private Rate(
            String id,
            String date,
            String value,
            String status,
            String createDate,
            String updateDate) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public String getId() { return id; }
    public String getDate() { return date; }
    public String getValue() { return value; }
    public String getStatus() { return status; }
    public String getCreateDate() { return createDate; }
    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private  String id;
        private  String date;
        private  String value;
        private  String status;
        private  String createDate;
        private  String updateDate;


        public Rate.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Rate.Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Rate.Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Rate.Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Rate.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Rate.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Rate build() {
            return new Rate(id, date, value, status, createDate, updateDate);
        }
    }
}
