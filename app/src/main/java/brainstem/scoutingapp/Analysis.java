package brainstem.scoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Analysis extends AppCompatActivity {

    private int partnerAvgAnalyze;
    private boolean cap = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        Intent intent = getIntent();
        Bundle bun = intent.getExtras();

        double partnerAvg = bun.getInt("partnerAvg");

        double stemOneBall = 5;
        double stemTwoBall = 8;
        double stemThreeBall = 10;
        double stemFourBall = 11;
        double stemFiveBall = 15;

        double fiveToOne = stemOneBall/stemFiveBall;
        double fiveToTwo = stemTwoBall/stemFiveBall;
        double fiveToThree = stemThreeBall/stemFiveBall;
        double fiveToFour = stemFourBall/stemFiveBall;

        double partnerOne = partnerAvg * fiveToOne;
        double partnerTwo = partnerAvg * fiveToTwo;
        double partnerThree = partnerAvg * fiveToThree;
        double partnerFour = partnerAvg * fiveToFour;
        double partnerFive = partnerAvg;

        double ballsPerRound[] = new double [6];
        ballsPerRound[0] = stemFiveBall;
        ballsPerRound[1] = stemFourBall + partnerOne;
        ballsPerRound[2] = stemThreeBall + partnerTwo;
        ballsPerRound[3] = stemTwoBall + partnerThree;
        ballsPerRound[4] = stemOneBall + partnerFour;
        ballsPerRound[5] = partnerFive;

        double bps[] = new double[6];
        bps[0] = 90/ballsPerRound[0];
        bps[1] = 90/ballsPerRound[1];
        bps[2] = 90/ballsPerRound[2];
        bps[3] = 90/ballsPerRound[3];
        bps[4] = 90/ballsPerRound[4];
        bps[5] = 90/ballsPerRound[5];

        double efficiency[] = new double[6];

        double optimalScored = 0;
        for(int i = 0;i < 6; i++)
        {
            if(ballsPerRound[i] > optimalScored)
                optimalScored = ballsPerRound[i];
        }

        for(int i = 0; i < 6; i++)
        {
            efficiency[i] = ballsPerRound[i]/optimalScored * 100.0;
        }

        BigDecimal bd = new BigDecimal(bps[0]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        String spbAlliance = bd.toString();
        BigDecimal shotsBd = new BigDecimal(ballsPerRound[0]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        String totalScored = shotsBd.toString();
        BigDecimal efficiencyBd = new BigDecimal(efficiency[0]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        String efficiencyString = efficiencyBd.toString();
        TextView stats = (TextView)findViewById(R.id.stem5);
        stats.setText("Total Balls Scored " + totalScored + "\nSeconds per shot " + spbAlliance + " \nEfficiency % " + efficiencyString);

        bd = new BigDecimal(bps[1]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        spbAlliance = bd.toString();
        shotsBd = new BigDecimal(ballsPerRound[1]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        totalScored = shotsBd.toString();
        efficiencyBd = new BigDecimal(efficiency[1]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        efficiencyString = efficiencyBd.toString();
        stats = (TextView)findViewById(R.id.stem4);
        stats.setText("Total Balls Scored " + totalScored + "\nSeconds per shot " + spbAlliance + " \nEfficiency % " + efficiencyString);

        bd = new BigDecimal(bps[2]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        spbAlliance = bd.toString();
        shotsBd = new BigDecimal(ballsPerRound[2]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        totalScored = shotsBd.toString();
        efficiencyBd = new BigDecimal(efficiency[2]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        efficiencyString = efficiencyBd.toString();
        stats = (TextView)findViewById(R.id.stem3);
        stats.setText("Total Balls Scored " + totalScored + "\nSeconds per shot " + spbAlliance + " \nEfficiency % " + efficiencyString);

        bd = new BigDecimal(bps[3]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        spbAlliance = bd.toString();
        shotsBd = new BigDecimal(ballsPerRound[3]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        totalScored = shotsBd.toString();
        efficiencyBd = new BigDecimal(efficiency[3]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        efficiencyString = efficiencyBd.toString();
        stats = (TextView)findViewById(R.id.stem2);
        stats.setText("Total Balls Scored " + totalScored + "\nSeconds per shot " + spbAlliance + " \nEfficiency % " + efficiencyString);

        bd = new BigDecimal(bps[4]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        spbAlliance = bd.toString();
        shotsBd = new BigDecimal(ballsPerRound[4]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        totalScored = shotsBd.toString();
        efficiencyBd = new BigDecimal(efficiency[4]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        efficiencyString = efficiencyBd.toString();
        stats = (TextView)findViewById(R.id.stem1);
        stats.setText("Total Balls Scored " + totalScored + "\nSeconds per shot " + spbAlliance + " \nEfficiency % " + efficiencyString);

        bd = new BigDecimal(bps[5]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        spbAlliance = bd.toString();
        shotsBd = new BigDecimal(ballsPerRound[5]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        totalScored = shotsBd.toString();
        efficiencyBd = new BigDecimal(efficiency[5]).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        efficiencyString = efficiencyBd.toString();
        stats = (TextView)findViewById(R.id.stem0);
        stats.setText("Total Balls Scored " + totalScored + "\nSeconds per shot " + spbAlliance + " \nEfficiency % " + efficiencyString);
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
                Intent firstIntent = getIntent();
                Bundle bun = firstIntent.getExtras();
                Intent intent = new Intent(this, Comparison.class);
                intent.putExtra("partnerAvg", bun.getInt("partnerAvg"));
                intent.putExtra("capBall", cap);
                startActivity(intent);
                return true;
            }

            case R.id.partnerMenu: {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
