package com.example.extreme_piash.androidbasic.core;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

/*
    public static AlertDialog showPleaseWaitDialog(BaseActivity fragmentActivity){
        LayoutInflater inflater = fragmentActivity.getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.layout_popup_please_wait, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(fragmentActivity, R.style.AppThemeGray));
        builder.setView(dialoglayout);
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        return  alertDialog;
    }

    public static void showFormValidationPopup(Activity activity, final String message){
        if(!activity.isFinishing()){
            new AlertDialog.Builder(activity)
                    .setTitle(R.string.error)
                    .setMessage(message)
                    .setPositiveButton(R.string.got_it, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(true)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }
    }
*/

}
