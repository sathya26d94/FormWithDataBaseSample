package com.example.sathya.formdemo;

import com.activeandroid.query.Select;

public class Util {
    public static int getDBSize() {
        return new Select().from(FormData.class).execute().size();
    }

    public static FormData getFormEntry(int index) {
        return new Select().from(FormData.class).executeSingle();
    }
}
