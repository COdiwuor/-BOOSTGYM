package com.example.android.boostgym;

import android.app.Application;
import android.content.Context;

import com.example.android.boostgym.Helper.LocaleHelper;

import java.util.Locale;

public class MainApplication extends Application {



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
