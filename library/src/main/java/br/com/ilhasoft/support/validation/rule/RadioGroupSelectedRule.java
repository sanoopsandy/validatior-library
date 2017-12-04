package br.com.ilhasoft.support.validation.rule;

import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.util.RadioGroupHandler;
import br.com.ilhasoft.support.validation.util.SpinnerHandler;

/**
 * Created by C149306 on 8/11/2017.
 */

public class RadioGroupSelectedRule extends Rule<TextView, RadioGroup> {

    public RadioGroupSelectedRule(RadioGroup view, TextView label, String errorMessage) {
        super(label, view, errorMessage);
    }

    @Override
    public boolean isValid(TextView view) {
        return value.getCheckedRadioButtonId() != -1;
    }

    @Override
    public void onValidationSucceeded(TextView view) {
        RadioGroupHandler.removeError(view);
    }

    @Override
    public void onValidationFailed(TextView view) {
        RadioGroupHandler.setError(view, errorMessage);
    }
}
