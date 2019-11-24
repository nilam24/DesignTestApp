package com.example.codemingleapp.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.codemingleapp.model.Example;

import java.util.List;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<Example>mutableLiveData;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mutableLiveData=new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setResponseProfile(List<Example>list){

        for (Example example1:list
             ) {

            mutableLiveData.setValue(example1);
        }


    }
    public LiveData<Example> getProfileDetail(){
        return mutableLiveData;
    }
}