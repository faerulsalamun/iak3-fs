package id.web.faerul.iak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainPesananActivity extends AppCompatActivity {

  Button mButtonMinusQuantity;
  Button mButtonPlusQuantity;
  TextView mTextQuantity;
  EditText mEditTextName;
  CheckBox mWhispedCream;
  CheckBox mChocolate;
  TextView mTextNameSummary;
  Button mButtonOrder;

  private int quantity = 1;
  private int total = 0;
  private int defaultPriceItem = 500;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_pesanan);

    mButtonMinusQuantity = (Button) findViewById(R.id.button_minus_quantity);
    mButtonPlusQuantity = (Button) findViewById(R.id.button_plus_quantity);
    mTextQuantity = (TextView) findViewById(R.id.text_quantity);
    mEditTextName = (EditText) findViewById(R.id.edit_text_name);
    mWhispedCream = (CheckBox) findViewById(R.id.check_box_whisped_cream);
    mChocolate = (CheckBox) findViewById(R.id.check_box_chocolate);
    mTextNameSummary = (TextView) findViewById(R.id.text_name_summary);
    mButtonOrder = (Button) findViewById(R.id.button_order);

    // Jika checkbox whisped cream di check atau uncheck
    mWhispedCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        // Check
        sumTotal(b);
      }
    });

    // Jika checkbox chocolate di check atau uncheck
    mChocolate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        // Check
        sumTotal(b);
      }
    });

    // Jika button order di click
    mButtonOrder.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        int sumTotalPrice = (defaultPriceItem + total) * quantity;
        mTextNameSummary.setText(String.valueOf(sumTotalPrice));
      }
    });

    // Jika button minus di click
    mButtonMinusQuantity.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        // Validasi jika sudah kurang dari 1
        if (quantity == 1) {
          Toast.makeText(MainPesananActivity.this, "Minimal pemesanan adalah 1", Toast.LENGTH_SHORT)
              .show();
        } else {
          quantity -= 1;
          mTextQuantity.setText(String.valueOf(quantity));
        }
      }
    });

    // Jika button plus di click
    mButtonPlusQuantity.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        quantity += 1;
        mTextQuantity.setText(String.valueOf(quantity));
      }
    });
  }

  private void sumTotal(boolean condition) {
    if (condition) {
      total += 1000;
    } else {
      total -= 1000;
    }
  }
}
