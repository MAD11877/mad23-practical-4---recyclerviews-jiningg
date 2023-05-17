package sg.edu.np.mad.madpractical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    final String TITLE = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "Create!");

        User myUser =  new User();
        myUser.userName = "MAD";

        myUser.userFollowed = false;
        myUser.isUserFollowed();

        TextView tv = findViewById(R.id.textView2);
        int randomInt = getIntent().getIntExtra("randomInt", 0);
        String name = myUser.getUserName();
        tv.setText(name + " " + randomInt);

        TextView tv1 = findViewById(R.id.textView);
        tv1.setText("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");

        ToggleButton togBut1 = findViewById(R.id.toggleButton);
        togBut1.setText(myUser.isUserFollowed() ? "Unfollow" : "Follow");

        togBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myUser.isUserFollowed()) {
                    togBut1.setText("Follow");
                    Log.v(TITLE, "Toggle Button: Unfollow clicked!");
                    myUser.setUserFollowed(false);
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                } else {
                    togBut1.setText("Unfollow");
                    Log.v(TITLE, "Toggle Button: Follow clicked!");
                    myUser.setUserFollowed(true);
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ToggleButton togBut2 = findViewById(R.id.toggleButton3);
        togBut2.setText("Message");

        togBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togBut2.getTextOn();
                Log.v(TITLE, "Toggle Button: Message clicked!");
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "Start!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE, "Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TITLE, "Paused");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE, "Stop!");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.v(TITLE, "Restart");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "Destroy");
    }
}