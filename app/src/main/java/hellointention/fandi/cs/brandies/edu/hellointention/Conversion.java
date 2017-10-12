package hellointention.fandi.cs.brandies.edu.hellointention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Conversion extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        intent = new Intent(Conversion.this, MainActivity.class);
        back();
        convert();
        about();
        clear();
    }

    public void convert() {
        Button convert = (Button)findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText kiloText = (EditText) findViewById(R.id.kiloChildRes);
                TextView mileText = (TextView) findViewById(R.id.mileChildRes);
                try {
                    double kilos = Integer.parseInt(kiloText.getText().toString());
                    double miles = Math.round(0.621371 * kilos * 100.0)/100.0;
                    mileText.setText("" + miles);
                    Bundle extras = new Bundle();
                    extras.putString("output", "The last conversion was "  + miles);
                    extras.putString("kilos", "" + kilos);
                    extras.putString("miles", "" + miles);
                    intent.putExtras(extras);
                } catch (Exception e) {
                    warning();
                    kiloText.setText(R.string.empty);
                    Bundle extras = new Bundle();
                    extras.putString("output", getResources().getString(R.string.empty));
                    extras.putString("kilos", "0");
                    extras.putString("miles", "0");
                    intent.putExtras(extras);
                }
            }
        });
    }

    public void clear() {
        Button clear = (Button)findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inText = (EditText) findViewById(R.id.kiloChildRes);
                inText.setText(R.string.empty);
                TextView outText = (TextView) findViewById(R.id.mileChildRes);
                outText.setText(R.string.zero);
                Bundle extras = new Bundle();
                extras.putString("output", getResources().getString(R.string.empty));
                extras.putString("kilos", "0");
                extras.putString("miles", "0");
                intent.putExtras(extras);
            }
        });
    }

    public void back() {
        Button btn = (Button)findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    public void about() {
        Button about = (Button)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build = new AlertDialog.Builder(Conversion.this);
                build.setTitle("How it works?");
                build.setMessage("Miles = Kilometers * 0.621371");
                build.setNegativeButton("Back", null);
                AlertDialog alert = build.create();
                alert.show();
            }
        });
    }

    public void warning() {
        AlertDialog.Builder build = new AlertDialog.Builder(Conversion.this);
        build.setTitle("Please Enter an Integer");
        build.setNegativeButton("Back", null);
        AlertDialog alert = build.create();
        alert.show();
    }
}
