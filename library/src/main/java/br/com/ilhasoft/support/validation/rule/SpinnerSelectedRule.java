package br.com.ilhasoft.support.validation.rule;

import android.widget.Spinner;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.util.EditTextHandler;
import br.com.ilhasoft.support.validation.util.SpinnerHandler;

/**
 * Created by C149306 on 8/10/2017.
 */

public class SpinnerSelectedRule extends Rule<TextView, Spinner> {

    public SpinnerSelectedRule(Spinner view, TextView label, String errorMessage) {
        super(label, view, errorMessage);
    }

    @Override
    public boolean isValid(TextView view) {
        return value.getSelectedItemPosition() != 0;
    }

    @Override
    public void onValidationSucceeded(TextView view) {
        SpinnerHandler.removeError(view);
    }

    @Override
    public void onValidationFailed(TextView view) {
        SpinnerHandler.setError(view, errorMessage);
    }
}
