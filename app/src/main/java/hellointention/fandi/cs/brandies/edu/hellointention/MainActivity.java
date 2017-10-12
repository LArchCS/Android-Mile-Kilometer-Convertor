package hellointention.fandi.cs.brandies.edu.hellointention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go();
        alertResult();
        updateTextView();
    }

    public void go() {
        Button btn = (Button) findViewById(R.id.go);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Conversion.class));
            }
        });
    }

    public void updateTextView() {
        if (getIntent().getExtras() != null) {
            /*TextView outputView = (TextView) findViewById(R.id.output);
            String res = getIntent().getExtras().getString("output");
            if (res.equals("")) {
                res = getResources().getString(R.string.waiting);
            }
            outputView.setText(res);*/
            TextView kView = (TextView) findViewById(R.id.kilosRes);
            TextView mView = (TextView) findViewById(R.id.milesRes);
            String k = getIntent().getExtras().getString("kilos");
            String m = getIntent().getExtras().getString("miles");
            kView.setText(k + " kilometers =");
            mView.setText(m + " miles");

        }
    }

    public void alertResult() {
        if (getIntent().getExtras() != null) {
            String res = getIntent().getExtras().getString("output");
            if (res.equals("")) {
                return;
            }
            AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
            build.setTitle("Conversion Result");
            build.setMessage(res);
            build.setNegativeButton("Back", null);
            AlertDialog alert = build.create();
            alert.show();
        }
    }
}
