package br.com.digitalhouse.digitalhousefoods.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.home.HomeActivity;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutRePassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();

        final SharedPreferences preferences = getSharedPreferences("APP_REGISTER", MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndGo(preferences);

            }
        });

    }

    //inicialização das views
    private void initViews() {
        textInputLayoutName = findViewById(R.id.textInputLayoutName);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        textInputLayoutRePassword = findViewById(R.id.textInputLayoutRePassword);

        btnRegister = findViewById(R.id.btnRegister);
    }

    //validação do cadastro
    private void validateAndGo(SharedPreferences preferences) {
        String name = textInputLayoutName.getEditText().getText().toString();
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();
        String rePassword = textInputLayoutRePassword.getEditText().getText().toString();


        if (name.isEmpty()) {
            textInputLayoutName.setError("Name not informed :(");
            return;
        }else {
            textInputLayoutName.setError(null);
        }

        if (!validateEmailFormat(email)) {
            textInputLayoutEmail.setError("Email not informed or invalid:(");
            return;
        }else {
            textInputLayoutEmail.setError(null);
        }

        if(!password.equals(rePassword)){
            textInputLayoutRePassword.setError("Password not equals :(");
            return;
        }

        if (password.isEmpty()) {
            textInputLayoutPassword.setError("Password not informed :(");
            return;
        }else {
            textInputLayoutPassword.setError(null);
        }

        if (rePassword.isEmpty()) {
            textInputLayoutRePassword.setError("Password not informed :(");
            return;
        }else {
            textInputLayoutRePassword.setError(null);
        }

        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);

        preferences.edit().putString("NOME",name).commit();
        preferences.edit().putString("EMAIL",email).commit();
        preferences.edit().putString("PASSWORD",encrypt(password)).commit();

        startActivity(intent);
        finish();
    }

    private boolean validateEmailFormat(final String email) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        return false;
    }

    //criptografia para senha
    public String encrypt(String input) {
        return Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
    }

}
