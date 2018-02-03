package inc.iris.demoibarts;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InvertImage extends AppCompatActivity {

    ImageView imageView;
    Drawable image;
    Bitmap image_bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invert_image);
        imageView=findViewById(R.id.imageView);
        image=getDrawable(R.drawable.squarelogo);
        image_bitmap=((BitmapDrawable)image).getBitmap();
        imageView.setImageBitmap(image_bitmap);
    }

    public void invert(View view) {
       image=imageView.getDrawable();
       image_bitmap=((BitmapDrawable)image).getBitmap();
       image_bitmap=invertBitmap(image_bitmap);
       imageView.setImageBitmap(image_bitmap);
    }

    private Bitmap invertBitmap(Bitmap original) {
        int pixelColor,height,width,a,r,g,b;
        width=original.getWidth();
        height=original.getHeight();
        Bitmap finalImage= Bitmap.createBitmap(width,height,original.getConfig());
        for(int x=0;x<width;x++)
            for(int y=0;y<height;y++)
            {
                pixelColor=original.getPixel(x,y);
                a= Color.alpha(pixelColor);
                r=Color.red(pixelColor);
                g=Color.green(pixelColor);
                b=Color.blue(pixelColor);
                r=255-r;
                g=255-g;
                b=255-b;
                finalImage.setPixel(x,y,Color.argb(a,r,g,b));
            }
        return finalImage;
    }
}
