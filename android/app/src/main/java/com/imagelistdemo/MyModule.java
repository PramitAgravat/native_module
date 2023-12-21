package com.imagelistdemo;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.ArrayList;
import java.util.List;

public class MyModule extends ReactContextBaseJavaModule {
    //constructor
    public MyModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    //Mandatory function getName that specifies the module name
    @Override
    public String getName() {
        return "MyModule";
    }

    //Custom function that we are going to export to JS
    @ReactMethod
    public void showToast(String message) {
        System.out.println(message);
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @ReactMethod
    public void openImageSwiper(ReadableArray imageUrls) {
        System.out.println(imageUrls);
        try {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < imageUrls.size(); i++) {
                list.add(imageUrls.getString(i));
            }
            System.out.println(list);
        } catch (Exception e) {
            Toast.makeText(getReactApplicationContext(), "Error opening Image Swiper", Toast.LENGTH_SHORT).show();
        }
    }

}