package sg.edu.np.mad.madpractical2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView txt;

    ImageView image;

    public UserViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.textView5);
        image = itemView.findViewById(R.id.imageView2);
    }
}
