package adneom.image_poc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import adneom.image_poc.Utils.StringUtil;
import adneom.image_poc.models.Media;

import static android.R.attr.start;

/**
 *
 */

public class PreviewActivity extends AppCompatActivity {

    public static final String KEY_MEDIA = "Key_media";

    private ImageView image;

    private Media media;

    public static Intent newIntent(Context context, Media media) {
        Intent intent = new Intent(context, PreviewActivity.class);
        intent.putExtra(KEY_MEDIA, media);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        image = (ImageView) findViewById(R.id.preview);

        if (savedInstanceState == null) {
            if (getIntent() != null) {
                media = getIntent().getExtras().getParcelable(KEY_MEDIA);
                updateView();
            }
        }
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


    private void updateView() {
        if (media != null && image != null) {
            switch (media.getType()) {
                case 0:
                    Uri uri = Uri.parse(media.getName());
                    /*try {
                        ParcelFileDescriptor parcelFileDescriptor = getContentResolver().openFileDescriptor(uri, "r");
                        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
                        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                        parcelFileDescriptor.close();
                        image.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Log.e("E", e.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("E", e.getMessage());
                    }*/
                    Picasso.with(this)
                            .load(uri)
                            .resize(300, 300)
                            .into(image);
                    break;
                case 1:
                    break;
            }
        }
    }

}
