package sg.edu.np.mad.madpractical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String title = "Main Activity";

    User myUser = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(title, "Create!");

        Intent rec = getIntent();
        int value = rec.getIntExtra("id",0);
        myUser = ListActivity.userList.get(value);

        TextView name = findViewById(R.id.textView2);
        name.setText(myUser.getUserName());
        TextView description = findViewById(R.id.textView);
        description.setText(myUser.getUserDescription());
        setFollowBtn();
    }

    private void setFollowBtn() {
        Button follow = findViewById(R.id.followBtn);
        if(myUser.userFollowed) {
            follow.setText("Unfollow");
            Log.v(title,"Button: Follow clicked!");
        }
        else {
            follow.setText("Follow");
            Log.v(title,"Button: Unfollow clicked!");
        }
    }

    public void onFollowClick(View v) {
        myUser.userFollowed = !myUser.userFollowed;
        if(myUser.userFollowed)
            Toast.makeText(this, "Followed", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Unfollowed", Toast.LENGTH_SHORT).show();
        setFollowBtn();
    }
}