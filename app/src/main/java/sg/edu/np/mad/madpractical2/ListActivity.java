package sg.edu.np.mad.madpractical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    ArrayList<User> userList = new ArrayList<>();
    final String title = "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(title, "Create!");

        for (int i = 0; i < 20; i++) {
            String randomName = generateRandomName();
            String randomDescription = generateRandomDescription();
            boolean randomFollowed = generateRandomFollowedValue();

            User user = new User(randomName, randomDescription, randomFollowed);
            userList.add(user);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }


    private int randomInteger(){
        Random ran = new Random();
        int myRandomNumber = ran.nextInt();
        return myRandomNumber;
    }

    private String generateRandomName(){
        String name = "Name";
        Integer num = randomInteger();
        return name + num;
    }

    private String generateRandomDescription(){
        String desc = "Description ";
        Integer num = randomInteger();
        return desc + num;
    }

    private boolean generateRandomFollowedValue(){
        Random random = new Random();
        return random.nextBoolean();
    }

    private void viewProfile(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness");
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title, "View Profile");
                int randomInt = randomInteger();

                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("randomInt", randomInt);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.v(title, "Close");
                dialogInterface.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }
}