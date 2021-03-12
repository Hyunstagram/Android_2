package com.kang.part_2;

public class Address {

    // Member Variable
    private String name;
    private String phone;
    private String email;
    private int icon;

    // Constructor Method
    public Address(String name, String phone, String email, int icon) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.icon = icon;
    }
    // Getter / Setter Method

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
