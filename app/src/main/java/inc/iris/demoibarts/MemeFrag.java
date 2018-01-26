package inc.iris.demoibarts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemeFrag extends Fragment {


    public MemeFrag() {
        // Required empty public constructor
    }

    TextView top_tx, bottom_tx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this memeGenerator
        View view = inflater.inflate(R.layout.fragment_meme, container, false);
        top_tx = view.findViewById(R.id.top);
        bottom_tx = view.findViewById(R.id.bottom);
        return view;
    }

    public void setValues(String top, String bottom) {
        top_tx.setText(top);
        bottom_tx.setText(bottom);

    }

}
