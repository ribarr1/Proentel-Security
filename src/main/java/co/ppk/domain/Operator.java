package co.ppk.domain;

public class Operator {

    private final String id;
    private final String document_type;
    private final String document_number;
    private final String name;
    private final String last_name;
    private final String address;
    private final String personal_phone;
    private final String assigned_phone;
    private final String status;
    private final String createDate;
    private final String updateDate;




    private Operator(
            String id,
            String document_type,
            String document_number,
            String name,
            String last_name,
            String address,
            String personal_phone,
            String assigned_phone,
            String status,
            String createDate,
            String updateDate) {
        this.id = id;
        this.document_type = document_type;
        this.document_number = document_number;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.personal_phone = personal_phone;
        this.assigned_phone = assigned_phone;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public String getId() { return id; }
    public String getDocument_type() { return document_type; }
    public String getDocument_number() { return document_number; }
    public String getName() { return name; }
    public String getLast_name() { return last_name; }
    public String getAddress() { return address; }
    public String getPersonal_phone() { return personal_phone; }
    public String getAssigned_phone() { return assigned_phone; }
    public String getStatus() { return status; }
    public String getCreateDate() { return createDate; }
    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private  String id;
        private  String document_type;
        private  String document_number;
        private  String name;
        private  String last_name;
        private  String address;
        private  String personal_phone;
        private  String assigned_phone;
        private  String status;
        private  String createDate;
        private  String updateDate;


        public Operator.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Operator.Builder setDocument_type(String document_type) {
            this.document_type = document_type;
            return this;
        }

        public Operator.Builder setDocument_number(String document_number) {
            this.document_number = document_number;
            return this;
        }

        public Operator.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Operator.Builder setLast_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public Operator.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Operator.Builder setPersonal_phone(String personal_phone) {
            this.personal_phone = personal_phone;
            return this;
        }

        public Operator.Builder setAssigned_phone(String assigned_phone) {
            this.assigned_phone = assigned_phone;
            return this;
        }

        public Operator.Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Operator.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Operator.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Operator build() {
            return new Operator(id, document_type, document_number,  name, last_name, address, personal_phone, assigned_phone, status, createDate, updateDate);
        }
    }
}
