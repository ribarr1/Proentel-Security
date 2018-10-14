package co.ppk.domain;

public class TemporalTransaction {



    private final String id;
    private final String phone;
    private final String license_plate;
    private final String billboards_code;
    private final String date;
    private final String hour;
    private final String time;
    private final String price;
    private final String action;
    private final String createDate;
    private final String updateDate;




    private TemporalTransaction(
            String id,
            String phone,
            String license_plate,
            String billboards_code,
            String date,
            String hour,
            String time,
            String price,
            String action,
            String createDate,
            String updateDate) {
        this.id = id;
        this.phone = phone;
        this.license_plate = license_plate;
        this.billboards_code = billboards_code;
        this.date = date;
        this.hour = hour;
        this.time = time;
        this.price = price;
        this.action = action;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public String getId() { return id; }
    public String getPhone() { return phone; }
    public String getLicense_plate() { return license_plate; }
    public String getBillboards_code() { return billboards_code; }
    public String getDate() { return date; }
    public String getHour() { return hour; }
    public String getTime() { return time; }
    public String getPrice() { return price; }
    public String getAction() { return action; }
    public String getCreateDate() { return createDate; }
    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private  String id;
        private  String phone;
        private  String license_plate;
        private  String billboards_code;
        private  String date;
        private  String hour;
        private  String time;
        private  String price;
        private  String action;
        private  String createDate;
        private  String updateDate;


        public TemporalTransaction.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public TemporalTransaction.Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public TemporalTransaction.Builder setLicense_plate(String license_plate) {
            this.license_plate = license_plate;
            return this;
        }

        public TemporalTransaction.Builder setBillboards_code(String billboards_code) {
            this.billboards_code = billboards_code;
            return this;
        }


        public TemporalTransaction.Builder setDate(String end_date) {
            this.date = date;
            return this;
        }

        public TemporalTransaction.Builder setHour(String end_time) {
            this.hour = hour;
            return this;
        }

        public TemporalTransaction.Builder setTime(String time) {
            this.time = time;
            return this;
        }

        public TemporalTransaction.Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public TemporalTransaction.Builder setAction(String closed) {
            this.action = action;
            return this;
        }

        public TemporalTransaction.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public TemporalTransaction.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public TemporalTransaction build() {
            return new TemporalTransaction(id, phone, license_plate, billboards_code,  date, hour, time, price, action, createDate, updateDate);
        }
    }
}
