package inc.iris.demoibarts.ListView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import inc.iris.demoibarts.R;

/**
 * Created by Sud on 1/21/18.
 */

public class CustomAdapter extends ArrayAdapter<Info> {
    int resource;
    Context context;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Info> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customRow = inflater.inflate(resource, parent, false);
        TextView name = customRow.findViewById(R.id.name);
        TextView post = customRow.findViewById(R.id.post);
        ImageView pic = customRow.findViewById(R.id.pic);
        name.setText(getItem(position).getName());
        post.setText(getItem(position).getPost());
        //setting display pic
        byte[] dp_byte = getItem(position).getDp();
        if (dp_byte==null);
        else {
            Bitmap dp = toBitmap(dp_byte);
            pic.setImageBitmap(dp);
        }
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            pic.setImageDrawable(context.getDrawable(getItem(position).getDp()));
        }*/
        return customRow;
    }

    private Bitmap toBitmap(byte[] dp) {

        return BitmapFactory.decodeByteArray(dp, 0, dp.length);
    }

}
