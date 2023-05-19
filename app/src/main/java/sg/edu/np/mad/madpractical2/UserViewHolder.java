package sg.edu.np.mad.madpractical2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    ImageView image;
    ArrayList<User> list_users;

    public UserViewHolder(View itemView, ArrayList<User> list_users){
        super(itemView);
        txt = itemView.findViewById(R.id.textView5);
        image = itemView.findViewById(R.id.imageView2);
        this.list_users = list_users;

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = list_users.get(getAdapterPosition()).getUserName();
                showDialog(name);
            }
        });

        /*itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MainActivity to show the profile page
                Context context = v.getContext();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });*/
    }

    /*private void showDialog(String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
        builder.setTitle("Profile");
        builder.setMessage(name);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }*/

    private void showDialog(String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
        builder.setTitle("Profile");
        builder.setMessage(name);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(itemView.getContext(), MainActivity.class);
                intent.putExtra("userName", name);
                intent.putExtra("userDescription", list_users.get(getAdapterPosition()).getUserDescription());
                intent.putExtra("userFollowed", list_users.get(getAdapterPosition()).isUserFollowed());
                itemView.getContext().startActivity(intent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
