package sg.edu.np.mad.madpractical2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    TextView desc;
    ImageView image;

    public UserViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.textView5);
        desc = itemView.findViewById(R.id.textView6);
        image = itemView.findViewById(R.id.imageView2);
    }
}
