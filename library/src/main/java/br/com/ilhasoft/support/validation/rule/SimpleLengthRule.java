package br.com.ilhasoft.support.validation.rule;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.util.SimpleEditTextHandler;

/**
 * Created by C149306 on 15-11-2017.
 */

public class SimpleLengthRule extends Rule<TextView, EditText> {

    private int minLength;
    private int maxLength;

    public SimpleLengthRule(EditText view, TextView label, Integer minValue, Integer maxValue, String errorMessage) {
        super(label, view, errorMessage);
        Log.i("SeekBar", "SimpleLengthRule: " + errorMessage);
        minLength = minValue;
        maxLength = maxValue;
    }

    @Override
    public boolean isValid(TextView view) {
        Log.i("SeekBar", "Length : " + value.getText().toString().length());
        return (value.getText().toString().length() > minLength && value.getText().toString().length() <= maxLength);
    }

    @Override
    public void onValidationSucceeded(TextView view) {
        SimpleEditTextHandler.removeError(view);
    }

    @Override
    public void onValidationFailed(TextView view) {
        SimpleEditTextHandler.setError(view, errorMessage);
    }
}