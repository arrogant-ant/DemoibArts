package inc.iris.demoibarts;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Sud on 1/11/18.
 */


public class MemeTextFrag extends Fragment {

    public interface MemeTextListner {
        void generateMeme(String top, String bottom);
    }

    MemeTextListner activity;

    EditText top_et, bottom_et;
    Button generate_bt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meme_text, container, false);
        top_et = view.findViewById(R.id.top_et);
        bottom_et = view.findViewById(R.id.bottom_et);
        generate_bt = view.findViewById(R.id.generate);
        generate_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.generateMeme(top_et.getText().toString(), bottom_et.getText().toString());

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MemeTextListner) context;
    }
}
