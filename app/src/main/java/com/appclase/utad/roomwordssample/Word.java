package com.appclase.utad.roomwordssample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    String mid;
    @ColumnInfo(name = "courseName")
    String mCourseName;
    @ColumnInfo(name = "numberOfStudents")
    String mNumberOfStudents;


    public Word(@NonNull String mid, String mCourseName, String mNumberOfStudents) {
        this.mid = mid;
        this.mCourseName = mCourseName;
        this.mNumberOfStudents = mNumberOfStudents;
    }

    @NonNull
    public String getMid() {
        return mid;
    }

    public void setMid(@NonNull String mid) {
        this.mid = mid;
    }

    public String getmCourseName() {
        return mCourseName;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public String getmNumberOfStudents() {
        return mNumberOfStudents;
    }

    public void setmNumberOfStudents(String mNumberOfStudents) {
        this.mNumberOfStudents = mNumberOfStudents;
    }
}