package com.example.sathya.formdemo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;


@Table(name = "FormData")
public class FormData extends Model {

    public FormData() {
        super();
    }

    @Column(name = "name")
    public String name;

    @Column(name = "dob")
    public String dob;

    @Column(name = "gender")
    public String gender;

    @Column(name = "single")
    public boolean single;

    @Column(name = "interest")
    public List<String> interest = new ArrayList<>();

    @Column(name = "rating")
    public float rating;

}
