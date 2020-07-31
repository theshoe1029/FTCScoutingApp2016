package brainstem.scoutingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.projectionMenu: {
                boolean cap = false;
                CheckBox capBox = (CheckBox)findViewById(R.id.capBox);
                if(capBox.isChecked())
                    cap = true;

                EditText boxOne = (EditText)findViewById(R.id.avgCenter);
                String allianceCenter = boxOne.getText().toString();
                int partnerAvg = Integer.parseInt(allianceCenter);

                Intent intent = new Intent(this, Comparison.class);
                intent.putExtra("partnerAvg", partnerAvg);
                intent.putExtra("capBall", cap);
                startActivity(intent);
                return true;
            }

            case R.id.analysisMenu:
                boolean cap = false;
                CheckBox capBox = (CheckBox)findViewById(R.id.capBox);
                if(capBox.isChecked())
                    cap = true;

                EditText boxOne = (EditText)findViewById(R.id.avgCenter);
                String allianceCenter = boxOne.getText().toString();
                int partnerAvg = Integer.parseInt(allianceCenter);

                Intent intent = new Intent(this, Analysis.class);
                intent.putExtra("partnerAvg", partnerAvg);
                intent.putExtra("capBall", cap);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
