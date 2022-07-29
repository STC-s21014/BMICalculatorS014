package com.example.bmicalculators014;

import static android.app.AlertDialog.*;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class BMIlog extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new Builder(getActivity());
        builder.setTitle(R.string.log_title);
        builder.setMessage(R.string.log_tx);
        builder.setPositiveButton(R.string.log_ok, new DialogButtonClickListener());
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {


        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

        }
    }
}
