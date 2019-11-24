package com.example.codemingleapp.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.codemingleapp.api.ApiClient;
import com.example.codemingleapp.api.ApiInterface;
import com.example.codemingleapp.model.Example;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<Example>> mutableLiveData;
    ApiInterface api;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        mutableLiveData=new MutableLiveData<>();
        api=ApiClient.getClient();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void getResponse(String userid){

        String api_key=" ";

        Single<List<Example>> call= api.getResponseData(api_key,userid);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Example>>() {
                    @Override
                    public void onSuccess(List<Example> examples) {
                        mutableLiveData.setValue(examples);
                        Log.e("response",""+examples.get(0));
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("responseError",""+e.getMessage());
                    }
                });


    }

    public LiveData<List<Example>> getResponseData(){

        return mutableLiveData;
    }

}