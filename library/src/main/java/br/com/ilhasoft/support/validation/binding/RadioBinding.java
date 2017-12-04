package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.RadioGroupSelectedRule;
import br.com.ilhasoft.support.validation.rule.SpinnerSelectedRule;
import br.com.ilhasoft.support.validation.util.ErrorMessageHelper;
import br.com.ilhasoft.support.validation.util.RadioGroupHandler;
import br.com.ilhasoft.support.validation.util.SpinnerHandler;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by C149306 on 8/11/2017.
 */

public class RadioBinding {
    @BindingAdapter(value = {"validateRadioSelected", "validateRadioSelectedMessage", "validateRadioAutoDismiss"}, requireAll = false)
    public static void radioButtonSelected(RadioGroup view, TextView errorLabel, String errorMessage, boolean autoDismiss) {
        if (autoDismiss) {
            RadioGroupHandler.disableErrorOnChanged(view, errorLabel);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(errorLabel,
                errorMessage, R.string.error_message_empty_validation);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new RadioGroupSelectedRule(view, errorLabel, handledErrorMessage));
    }
}
