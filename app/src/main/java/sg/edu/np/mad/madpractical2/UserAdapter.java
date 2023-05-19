package sg.edu.np.mad.madpractical2;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> list_users;

    public UserAdapter(ArrayList<User> user){
        this.list_users = user;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        UserViewHolder holder = new UserViewHolder(view, list_users);
        return holder;
    }

    public void onBindViewHolder(UserViewHolder holder, int position){
        User list_items = list_users.get(position);
        String name = list_items.getUserName();
        String description = list_items.getUserDescription();
        SpannableString nameAndDescription = new SpannableString( name + "\n" + "\n" + "\n" + description);
        nameAndDescription.setSpan(new AbsoluteSizeSpan(24, true), 0, name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.txt.setText(nameAndDescription);
    }

    public int getItemCount(){
        return list_users.size();
    }
}
