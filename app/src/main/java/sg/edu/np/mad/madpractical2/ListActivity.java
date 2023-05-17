package sg.edu.np.mad.madpractical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    final String title = "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(title, "Create!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(title, "Resume");

        ImageView imageView = findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(title, "Image clicked!");
                viewProfile();
            }
        });
    }

    private int randomInteger(){
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(Integer.MAX_VALUE - 1) + 1;
        return myRandomNumber;
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