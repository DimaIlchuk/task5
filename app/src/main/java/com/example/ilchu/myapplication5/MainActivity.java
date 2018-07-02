package com.example.ilchu.myapplication5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Bitmap bitmap;
    String URLIMAGE = "https://webiconspng.com/wp-content/uploads/2017/09/Simpsons-PNG-Image-29703.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.Margin);

       new  GetImageFromUrl(img).execute(URLIMAGE);

    }
    public  class  GetImageFromUrl extends AsyncTask<String,Void,Bitmap>{

        ImageView imageView;
        public GetImageFromUrl(ImageView imgV){
            this.imageView = imgV;

        }

        @Override
        protected Bitmap doInBackground(String... url) {

            String urldisplay = url[0];
            bitmap = null;
            try{

                InputStream srt = new java.net.URL(urldisplay).openStream();
                bitmap = BitmapFactory.decodeStream(srt);
            } catch (Exception e){
                e.printStackTrace();
            }

            return bitmap;

        }

        @Override
        protected void onPostExecute(Bitmap bitmap){

        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);

        }
    }
}
