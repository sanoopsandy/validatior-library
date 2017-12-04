package br.com.ilhasoft.support.validation.util;

import android.databinding.adapters.ListenerUtil;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewParent;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by C149306 on 8/10/2017.
 */

public class SpinnerHandler {

    public static void removeError(TextView textView) {
        SpinnerHandler.setError(textView, null);
    }

    public static void setError(TextView textView, String errorMessage) {
        if (null == errorMessage) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setText(errorMessage);
            textView.setTextColor(Color.RED); //Can comment out this line and add color to the textview in XML
            textView.setVisibility(View.VISIBLE);
        }
    }

    public static void disableErrorOnChanged(final Spinner spinner, final TextView textView) {
        if (spinner.isDirty())
            SpinnerHandler.setError(textView, null);
    }

}
