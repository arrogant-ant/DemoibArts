package inc.iris.demoibarts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Animation extends AppCompatActivity {

    ViewGroup parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        parent = findViewById(R.id.parentLayout);
        parent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                moveButton();
                return true;
            }
        });
    }

    private void moveButton() {
        Button bt = (Button) findViewById(R.id.anim_bt);
        TransitionManager.beginDelayedTransition(parent);

        //move the button
        RelativeLayout.LayoutParams move_rules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        move_rules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        move_rules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        bt.setLayoutParams(move_rules);

        //change the size of the button
        ViewGroup.LayoutParams size_rules = bt.getLayoutParams();
        size_rules.width = 450;
        size_rules.height = 300;
        bt.setLayoutParams(size_rules);

    }
}
