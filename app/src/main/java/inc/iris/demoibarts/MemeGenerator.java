package inc.iris.demoibarts;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MemeGenerator extends AppCompatActivity implements MemeTextFrag.MemeTextListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_generator);
    }

    @Override
    public void generateMeme(String top, String bottom) {

        MemeFrag meme = (MemeFrag) getSupportFragmentManager().findFragmentById(R.id.meme_frag);
        meme.setValues(top, bottom);
    }
}
