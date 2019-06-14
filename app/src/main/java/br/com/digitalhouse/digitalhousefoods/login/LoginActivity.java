package br.com.digitalhouse.digitalhousefoods.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.home.HomeActivity;
import br.com.digitalhouse.digitalhousefoods.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnLogin;
    private Button btnFacebook;
    private Button btnRegister;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        final SharedPreferences preferences = getSharedPreferences("APP_LOGIN", MODE_PRIVATE);

        textInputLayoutEmail.getEditText().setText(preferences.getString("EMAIL", ""));
        textInputLayoutPassword.getEditText().setText(decrypt(preferences.getString("PASSWORD", "")));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateAndGo(preferences);
            }

        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.putExtra("PROFILE", "1");
                startActivity(intent);
            }
        });
    }


    private void validateAndGo(SharedPreferences preferencesLogin) {
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();

        if (!validateEmailFormat(email)) {
            textInputLayoutEmail.setError("Email not informed or invalid:(");
            return;
        } else {
            textInputLayoutEmail.setError(null);
        }

        if (password.isEmpty()) {
            textInputLayoutPassword.setError("Password not informed :(");
            return;
        } else {
            textInputLayoutPassword.setError(null);
        }

        final SharedPreferences preferences = getSharedPreferences("APP_REGISTER", MODE_PRIVATE);

        String emailValid = preferences.getString("EMAIL", "");
        String passwordValid = decrypt(preferences.getString("PASSWORD", ""));


        if (passwordValid != null && !password.equals(passwordValid) ||
                emailValid != null && !email.equals(emailValid)) {

            Snackbar.make(btnLogin, "Email or password invalid:(", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            return;
        } else {
            textInputLayoutEmail.setError(null);
            textInputLayoutPassword.setError(null);
        }

        if (checkBox.isChecked()) {


            preferencesLogin.edit().putString("EMAIL", email).commit();
            preferencesLogin.edit().putString("PASSWORD", encrypt(password)).commit();
        }

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    private boolean validateEmailFormat(final String email) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        return false;
    }


    private void initViews() {
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnRegister = findViewById(R.id.btnRegister);
        checkBox = findViewById(R.id.checkBox);
    }

    public String encrypt(String input) {
        return Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
    }

    public String decrypt(String input) {
        return new String(Base64.decode(input, Base64.DEFAULT));
    }
}