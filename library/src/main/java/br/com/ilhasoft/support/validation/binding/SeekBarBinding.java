package br.com.ilhasoft.support.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import br.com.ilhasoft.support.validation.R;
import br.com.ilhasoft.support.validation.rule.SeekBarLengthRule;
import br.com.ilhasoft.support.validation.util.ErrorMessageHelper;
import br.com.ilhasoft.support.validation.util.SeekBarHandler;
import br.com.ilhasoft.support.validation.util.ViewTagHelper;

/**
 * Created by C149306 on 8/11/2017.
 */

public class SeekBarBinding {

    @BindingAdapter(value = {"validateSeekBarSelected", "validateSeekBarMinLength", "validateSeekBarMaxLength", "validateSeekBarLengthMessage", "validateSeekBarAutoDismiss"}, requireAll = false)
    public static void seekBarMinValidation(SeekBar view, TextView errorLabel, int minLength, int maxLength, String errorMessage, boolean autoDismiss) {
        if (autoDismiss) {
            SeekBarHandler.disableErrorOnChanged(view, errorLabel);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_min_length, minLength);
        ViewTagHelper.appendValue(R.id.validator_rule, view, new SeekBarLengthRule(view, errorLabel, minLength, maxLength, handledErrorMessage));
    }
}
