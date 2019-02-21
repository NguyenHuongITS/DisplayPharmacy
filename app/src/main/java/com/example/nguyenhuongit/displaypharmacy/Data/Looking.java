package com.example.nguyenhuongit.displaypharmacy.Data;

public class Looking {
    public Looking(int image_data1, String string_data1) {
        this.image_data1 = image_data1;
        this.string_data1 = string_data1;
    }

    public Looking() {}

    public int getImage_data1() {
        return image_data1;
    }

    public void setImage_data1(int image_data1) {
        this.image_data1 = image_data1;
    }

    public String getString_data1() {
        return string_data1;
    }

    public void setString_data1(String string_data1) {
        this.string_data1 = string_data1;
    }

    int image_data1;
    String string_data1;
}
