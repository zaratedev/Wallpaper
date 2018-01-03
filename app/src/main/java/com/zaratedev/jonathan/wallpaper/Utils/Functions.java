package com.zaratedev.jonathan.wallpaper.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.zaratedev.jonathan.wallpaper.R;

/**
 * Created by zaratedev on 02/01/2018.
 */

public class Functions {
    public static void changeMainFragment(FragmentActivity fragmentActivity, Fragment fragment) {
        fragmentActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }
}
