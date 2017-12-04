package br.com.ilhasoft.support.validation.rule;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.util.SimpleEditTextHandler;

/**
 * Created by C149306 on 15-11-2017.
 */

public class SimpleEmptyRule extends Rule<TextView, EditText>{
    public SimpleEmptyRule(EditText view, TextView label, Boolean value, String errorMessage) {
        super(label, view, errorMessage);
    }

    @Override
    public boolean isValid(TextView view) {
        return !TextUtils.isEmpty(value.getText());
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
