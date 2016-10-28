package com.example.desen.dsspinneradapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by desen on 2016-10-27.
 */

public class DSAlert {
    public static void showMessageDialog(Context context,
                                         String message,
                                         String positiveButtonText,
                                         String negativeButtonText,
                                         DialogInterface.OnClickListener ok) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton(positiveButtonText, ok);
        builder.setNegativeButton(negativeButtonText, null);
        builder.setMessage(message);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();
    }

    public static void showMessageDialog(Context context,
                                         String message,
                                         String positiveButtonText,
                                         DialogInterface.OnClickListener ok) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton(positiveButtonText, ok);
        builder.setMessage(message);

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();
    }


    /*
    * END of dialogs
    * */

    public static void showSimpleTextDialog(Context context,
                                            String title,
                                            CharSequence message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton("Ok", null);
        builder.setTitle(title);
        builder.setMessage(message);

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();

    }
}
