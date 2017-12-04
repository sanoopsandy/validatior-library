package br.com.ilhasoft.support.validation.rule;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.util.SimpleEditTextHandler;

/**
 * Created by C149306 on 20-11-2017.
 */

public class SimpleRegexRule extends Rule<TextView, EditText>{

    String regexPattern;

    public SimpleRegexRule(EditText view, TextView label, String pattern, String errorMessage) {
        super(label, view, errorMessage);
        regexPattern = pattern;
    }

    @Override
    public boolean isValid(TextView view) {
        return value.getText().toString().matches(regexPattern);
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

