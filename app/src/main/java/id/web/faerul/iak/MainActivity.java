package id.web.faerul.iak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  Button mButtonLogin; // bener
  EditText mEditTextUsername;
  EditText mEditTextPassword;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mButtonLogin = (Button) findViewById(R.id.button_login);
    mEditTextUsername = (EditText) findViewById(R.id.edit_text_username);
    mEditTextPassword = (EditText) findViewById(R.id.edit_text_password);

    // if elseif else
    // switch case

    mButtonLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if (mEditTextUsername.getText().toString().equals("iak")
            && mEditTextPassword.getText()
            .toString()
            .equals("iak")) {

          // Cara pindah halaman
          Intent intent = new Intent(MainActivity.this,HomeActivity.class);
          intent.putExtra("username",mEditTextUsername.getText().toString());
          startActivity(intent);
        } else {
          // Kalo salah
          Toast.makeText(MainActivity.this,
              "Username atau password salah",
              Toast.LENGTH_SHORT)
              .show();
        }
      }
    });
  }
}
