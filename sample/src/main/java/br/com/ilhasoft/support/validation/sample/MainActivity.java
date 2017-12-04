package br.com.ilhasoft.support.validation.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import br.com.ilhasoft.support.validation.Validator;
import br.com.ilhasoft.support.validation.sample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(this);
        validator = new Validator(binding);
        validator.setSkipValidation(false);
        validator.setValidationListener(this);
        validator.enableFormValidationMode();
    }

    public void validate(View view) {
        validator.toValidate();
    }

    @Override
    public void onValidationSuccess() {
        Toast.makeText(this, "validation Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationError() {
        Toast.makeText(this, "validation not successful", Toast.LENGTH_SHORT).show();
    }

    public void toggleLayout(View view){
        CheckBox checkBox = (CheckBox) view;
        boolean b = checkBox.isChecked();
        if (b){
            binding.llToggle.setVisibility(View.VISIBLE);
//            binding.edt1.setVisibility(View.VISIBLE);
//            binding.emailRegex.setVisibility(View.VISIBLE);
        }else{
            binding.llToggle.setVisibility(View.GONE);
//            binding.edt1.setVisibility(View.GONE);
//            binding.emailRegex.setVisibility(View.GONE);
        }
    }

}
