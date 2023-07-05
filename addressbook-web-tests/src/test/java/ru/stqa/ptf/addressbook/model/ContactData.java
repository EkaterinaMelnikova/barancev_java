package ru.stqa.ptf.addressbook.model;

public class ContactData {
    private int id;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String mobile;
    private final String workphone;
    private final String fax;
    private final String emeil;
    private final String emeil2;
    private final String emeil3;
    private final String homepage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String aday;
    private final String amonth ;
    private final String ayear;
    private final String address2;
    private final String phone2;
    private final String notes;





    public ContactData(String firstname, String middlename, String lastname, String nickname,
                       String title, String company, String address, String home, String mobile,
                       String work, String fax, String emeil, String emeil2, String emeil3,
                       String homepage, String bday, String bmonth, String byear, String aday,
                       String amonth, String ayear, String address2, String phone2, String notes) {
        this.id = 0;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.workphone = work;
        this.fax = fax;
        this.emeil = emeil;
        this.emeil2 = emeil2;
        this.emeil3 = emeil3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    public ContactData(int id, String firstname, String middlename, String lastname, String nickname,
                       String title, String company, String address, String home, String mobile,
                       String work, String fax, String emeil, String emeil2, String emeil3,
                       String homepage, String bday, String bmonth, String byear, String aday,
                       String amonth, String ayear, String address2, String phone2, String notes) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.workphone = work;
        this.fax = fax;
        this.emeil = emeil;
        this.emeil2 = emeil2;
        this.emeil3 = emeil3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmeil() {
        return emeil;
    }

    public String getEmeil2() {
        return emeil2;
    }

    public String getEmeil3() {
        return emeil3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAday() {
        return aday;
    }

    public String getAmonth() {return amonth;}

    public String getAyear() {
        return ayear;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return middlename != null ? middlename.equals(that.middlename) : that.middlename == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }
}
