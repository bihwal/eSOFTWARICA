package com.example.esoftwarica.ui.addstudent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddStudentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddStudentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Add Student");
    }

    public LiveData<String> getText() {
        return mText;
    }
}