package edu.washington.gulabry.lifecounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private int players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        players = 0;

        for(int i = 0; i < 4; i++) {
            addPlayer();
        }

        Button additional = (Button)findViewById(R.id.add);
        additional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPlayer();
            }

        });
    }

    public void addPlayer() {
        if (players < 8) {
            players++;
            System.out.println(players);

            //creating layout, one row, and each column with proper buttons
            LinearLayout layout = (LinearLayout)findViewById(R.id.LinearL);
            LinearLayout horizontalLayout = new LinearLayout(this);
            horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
            layout.addView(horizontalLayout);

            final Player player = new Player("P" + players);
            TextView label = new TextView(this);
            label.setTextSize(10);
            label.setText(player.getPlayerNumber()+": ");
            horizontalLayout.addView(label);

            final TextView life = new TextView(this);
            life.setText(String.valueOf(player.getLife()));
            horizontalLayout.addView(life);

            Button addOne = new Button(this);
            addOne.setText("+");
            addOne.setOnClickListener(new LifeOnClickListener(player, life) {
                @Override
                public void onClick(View v) {
                    player.setLife(1);
                    System.out.println(player.getLife());
                    life.setText(String.valueOf(player.getLife()));
                }
            });
            horizontalLayout.addView(addOne);

            Button subtractOne = new Button(this);
            subtractOne.setText("-");
            subtractOne.setOnClickListener(new LifeOnClickListener(player, life) {
                @Override
                public void onClick(View v) {
                    if(player.getLife() > 0) {
                        player.setLife(-1);
                        System.out.println(player.getLife());
                        life.setText(String.valueOf(player.getLife()));
                        if (player.getLife() <= 0) {
                            TextView lose = (TextView) findViewById(R.id.lose);
                            lose.setText(player.getPlayerNumber() + "Loses!");
                        }
                    }
                }
            });
            horizontalLayout.addView(subtractOne);

            Button addFive = new Button(this);
            addFive.setText("+5");
            addFive.setOnClickListener(new LifeOnClickListener(player, life) {
                @Override
                public void onClick(View v) {
                    player.setLife(5);
                    System.out.println(player.getLife());
                    life.setText(String.valueOf(player.getLife()));
                }
            });
            horizontalLayout.addView(addFive);

            Button subtractFive = new Button(this);
            subtractFive.setOnClickListener(new LifeOnClickListener(player, life) {
                @Override
                public void onClick(View v) {
                    if(player.getLife() > 0) {
                        player.setLife(-5);
                        System.out.println(player.getLife());
                        life.setText(String.valueOf(player.getLife()));
                        if (player.getLife() <= 0) {
                            TextView lose = (TextView) findViewById(R.id.lose);
                            lose.setText("Player " + player.getPlayerNumber() + " LOSES!!");
                        }
                    }
                }
            });
            subtractFive.setText("-5");
            horizontalLayout.addView(subtractFive);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class LifeOnClickListener implements View.OnClickListener
    {

        Player player;
        TextView life;
        public LifeOnClickListener(Player player, TextView life) {
            this.player = player;
            this.life = life;
        }

        @Override
        public void onClick(View v)
        {
            //
        }

    }


}