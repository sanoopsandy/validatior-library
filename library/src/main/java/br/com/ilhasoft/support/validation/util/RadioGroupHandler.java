package br.com.ilhasoft.support.validation.util;

import android.databinding.adapters.ListenerUtil;
import android.graphics.Color;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by C149306 on 8/11/2017.
 */

public class RadioGroupHandler {
    public static void removeError(TextView textView) {
        RadioGroupHandler.setError(textView, null);
    }

    public static void setError(TextView textView, String errorMessage) {
        if (null == errorMessage) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setText(errorMessage);
            textView.setTextColor(Color.RED);
        }
    }

    public static void disableErrorOnChanged(final RadioGroup radioGroup, final TextView textView) {
        if (radioGroup.isDirty())
            RadioGroupHandler.setError(textView, null);
    }
}
