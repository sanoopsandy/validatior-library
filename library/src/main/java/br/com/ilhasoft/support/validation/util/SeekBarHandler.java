package br.com.ilhasoft.support.validation.util;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by C149306 on 8/11/2017.
 */

public class SeekBarHandler {


    public static void removeError(TextView textView) {
        SeekBarHandler.setError(textView, null);
    }

    public static void setError(TextView textView, String errorMessage) {
        Log.i("SeekBar", "setError: " + errorMessage);
        textView.setText(errorMessage);
        textView.setTextColor(Color.RED);
        /*if (null == errorMessage) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setText(errorMessage);
            textView.setTextColor(Color.RED);
        }*/
    }

    public static void disableErrorOnChanged(final SeekBar seekBar, final TextView textView) {
        if (seekBar.isDirty())
            SeekBarHandler.setError(textView, null);
    }

}
