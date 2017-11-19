package id.web.faerul.iak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

  TextView mTextName;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    mTextName = findViewById(R.id.text_name);

    Bundle bundle = getIntent().getExtras();

    if (bundle != null) {
      mTextName.setText("Hello " + bundle.getString("username"));
    }
  }
}
