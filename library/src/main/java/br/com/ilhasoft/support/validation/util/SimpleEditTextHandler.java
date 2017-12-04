package br.com.ilhasoft.support.validation.util;

import android.databinding.adapters.ListenerUtil;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;

/**
 * Created by C149306 on 15-11-2017.
 */

public class SimpleEditTextHandler {

    public static void removeError(TextView textView) {
        SimpleEditTextHandler.setError(textView, null);
    }

    public static void setError(TextView textView, String errorMessage) {
        if (null == errorMessage) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setText(errorMessage);
            textView.setTextColor(Color.RED);
            textView.setVisibility(View.VISIBLE);
        }
    }

    public static void disableErrorOnChanged(final EditText editText, final TextView textView) {
        final TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SimpleEditTextHandler.setError(textView, null);
            }
            @Override
            public void afterTextChanged(Editable s) { }
        };
        editText.addTextChangedListener(textWatcher);
    }
}
