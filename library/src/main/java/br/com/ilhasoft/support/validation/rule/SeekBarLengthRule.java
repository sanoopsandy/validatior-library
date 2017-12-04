package br.com.ilhasoft.support.validation.rule;

import android.util.Log;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.util.SeekBarHandler;
import br.com.ilhasoft.support.validation.util.SpinnerHandler;

/**
 * Created by C149306 on 8/11/2017.
 */

public class SeekBarLengthRule extends Rule<TextView, SeekBar> {

    private int minLength;
    private int maxLength;

    public SeekBarLengthRule(SeekBar view, TextView label, Integer minValue, Integer maxValue, String errorMessage) {
        super(label, view, errorMessage);
        Log.i("SeekBar", "SeekBarLengthRule: " + errorMessage);
        minLength = minValue;
        maxLength = maxValue;
    }

    @Override
    public boolean isValid(TextView view) {
        Log.i("SeekBar", "Progress : " + value.getProgress());
        return (value.getProgress() > minLength && value.getProgress() <= maxLength);
    }

    @Override
    public void onValidationSucceeded(TextView view) {
        SeekBarHandler.removeError(view);
    }

    @Override
    public void onValidationFailed(TextView view) {
        SeekBarHandler.setError(view, errorMessage);
    }
}