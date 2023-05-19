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

    String myRecvUsername;
    String myRecvDesc;
    String myRecvFollow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "Create!");

        //User myUser =  new User();

        //myUser.userFollowed = false;
        //myUser.isUserFollowed();

        //TextView tv = findViewById(R.id.textView2);
        //Intent myRecvIntent = getIntent();
        //String name = myUser.getUserName();
        //tv.setText(name);

        Intent myRecvIntent = getIntent();
        String userName = myRecvIntent.getStringExtra("userName");
        String userDescription = myRecvIntent.getStringExtra("userDescription");
        boolean userFollowed = myRecvIntent.getBooleanExtra("userFollowed", false);
        TextView tv = findViewById(R.id.textView2);
        tv.setText(userName);

        final boolean[] followed = {userFollowed};

        ToggleButton togBut1 = findViewById(R.id.toggleButton);
        togBut1.setText(userFollowed ? "Unfollow" : "Follow");

        togBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (followed[0]) {
                    togBut1.setText("Follow");
                    Log.v(TITLE, "Toggle Button: Unfollow clicked!");
                    followed[0] = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                } else {
                    togBut1.setText("Unfollow");
                    Log.v(TITLE, "Toggle Button: Follow clicked!");
                    followed[0] = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }

                for (User user : ListActivity.userList) {
                    if (user.getUserName().equals(myRecvUsername)) {
                        user.setUserFollowed(followed[0]);
                        break;
                    }
                }
            }
        });

        TextView tv1 = findViewById(R.id.textView);
        tv1.setText(userDescription);

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