package com.example.mynodes.Dialog;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import java.util.Date;
import java.util.Calendar;

public class CustomSave extends DialogFragment
{
    @NonNull
    public Dialog onCreateDialog(Bundle savedInst)
    {
        Date currentTime = Calendar.getInstance().getTime();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle(String.valueOf(currentTime)).setTitle("Сохранено!").setPositiveButton("Клик!", null).create();
    }
}