package co.ppk.domain;

public class Transaction {



    private final String id;
    private final String phone;
    private final String license_plate;
    private final String billboards_code;
    private final String start_date;
    private final String start_time;
    private final String end_date;
    private final String end_time;
    private final String time;
    private final String price;
    private final String closed;
    private final String createDate;
    private final String updateDate;




    private Transaction(
            String id,
            String phone,
            String license_plate,
            String billboards_code,
            String start_date,
            String start_time,
            String end_date,
            String end_time,
            String time,
            String price,
            String closed,
            String createDate,
            String updateDate) {
        this.id = id;
        this.phone = phone;
        this.license_plate = license_plate;
        this.billboards_code = billboards_code;
        this.start_date = start_date;
        this.start_time = start_time;
        this.end_date = end_date;
        this.end_time = end_time;
        this.time = time;
        this.price = price;
        this.closed = closed;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public String getId() { return id; }
    public String getPhone() { return phone; }
    public String getLicense_plate() { return license_plate; }
    public String getBillboards_code() { return billboards_code; }
    public String getStart_date() { return start_date; }
    public String getStart_time() { return start_time; }
    public String getEnd_date() { return end_date; }
    public String getEnd_time() { return end_time; }
    public String getTime() { return time; }
    public String getPrice() { return price; }
    public String getClosed() { return closed; }
    public String getCreateDate() { return createDate; }
    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private  String id;
        private  String phone;
        private  String license_plate;
        private  String billboards_code;
        private  String start_date;
        private  String start_time;
        private  String end_date;
        private  String end_time;
        private  String time;
        private  String price;
        private  String closed;
        private  String createDate;
        private  String updateDate;


        public Transaction.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Transaction.Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Transaction.Builder setLicense_plate(String license_plate) {
            this.license_plate = license_plate;
            return this;
        }

        public Transaction.Builder setBillboards_code(String billboards_code) {
            this.billboards_code = billboards_code;
            return this;
        }

        public Transaction.Builder setStart_date(String start_date) {
            this.start_date = start_date;
            return this;
        }

        public Transaction.Builder setStart_time(String start_time) {
            this.start_time = start_time;
            return this;
        }

        public Transaction.Builder setEnd_date(String end_date) {
            this.end_date = end_date;
            return this;
        }

        public Transaction.Builder setEnd_time(String end_time) {
            this.end_time = end_time;
            return this;
        }

        public Transaction.Builder setTime(String time) {
            this.time = time;
            return this;
        }

        public Transaction.Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public Transaction.Builder setClosed(String closed) {
            this.closed = closed;
            return this;
        }

        public Transaction.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Transaction.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Transaction build() {
            return new Transaction(id, phone, license_plate, billboards_code, start_date, start_time, end_date, end_time, time, price, closed, createDate, updateDate);
        }
    }
}
