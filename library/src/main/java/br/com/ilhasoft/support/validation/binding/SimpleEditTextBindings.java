package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.EditText;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.MaxLengthRule;
import br.com.ilhasoft.support.validation.rule.MinLengthRule;
import br.com.ilhasoft.support.validation.rule.SimpleEmptyRule;
import br.com.ilhasoft.support.validation.rule.SimpleLengthRule;
import br.com.ilhasoft.support.validation.rule.SimpleRegexRule;
import br.com.ilhasoft.support.validation.util.SimpleEditTextHandler;
import br.com.ilhasoft.support.validation.util.ErrorMessageHelper;
import br.com.ilhasoft.support.validation.util.SimpleEditTextHandler;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by C149306 on 15-11-2017.
 */

public class SimpleEditTextBindings {

    @BindingAdapter(value = {"validateEditSelected", "validateEditMinLength", "validateEditMaxLength", "validateEditLengthMessage", "validateEditAutoDismiss"}, requireAll = false)
    public static void seekBarMinValidation(EditText view, TextView errorLabel, int minLength, int maxLength, String errorMessage, boolean autoDismiss) {
        if (autoDismiss) {
            SimpleEditTextHandler.disableErrorOnChanged(view, errorLabel);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_min_length, minLength);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new SimpleLengthRule(view, errorLabel, minLength, maxLength, handledErrorMessage));
    }

    @BindingAdapter(value = {"validateEditSelected", "validateEditEmpty", "validateEditEmptyMessage", "validateEditEmptyAutoDismiss"}, requireAll = false)
    public static void bindingEditEmpty(EditText view, TextView errorLabel, boolean empty, String errorMessage, boolean autoDismiss) {
        if (autoDismiss) {
            SimpleEditTextHandler.disableErrorOnChanged(view, errorLabel);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_empty_validation);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new SimpleEmptyRule
                (view, errorLabel, empty, handledErrorMessage));
    }

    // Email regex
    @BindingAdapter(value = {"validateEditSelected", "validateEditRegex", "validateEditRegexMessage", "validateEditRegexAutoDismiss"}, requireAll = false)
    public static void bindingEditRegex(EditText view, TextView errorLabel, String pattern, String errorMessage, boolean autoDismiss) {
        if (autoDismiss) {
            SimpleEditTextHandler.disableErrorOnChanged(view, errorLabel);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_regex_validation);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new SimpleRegexRule(view, errorLabel, pattern, handledErrorMessage));
    }
}
