package com.trodev.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Developer extends AppCompatActivity {

    private ImageView facebook, instagram, linkedin, youtube, privacy, github;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        facebook = findViewById(R.id.facebook);
        instagram = findViewById(R.id.instagram);
        linkedin = findViewById(R.id.linkedin);
        youtube = findViewById(R.id.youtube);
        privacy = findViewById(R.id.policy);
        github = findViewById(R.id.github);


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenFacebookIntent());
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.instagram.com/trodevit/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/trodevit/")));
                }
            }
        });


        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://you"));

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/84349418"));

                startActivity(intent);
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Intent appIntent = new Intent(Intent.ACTION_VIEW);
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/@trodev"));
                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });


        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Intent appIntent = new Intent(Intent.ACTION_VIEW);
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/zobayerdev"));
                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Intent appIntent = new Intent(Intent.ACTION_VIEW);
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.app-privacy-policy.com/live.php?token=twLOvay2fWQGWdHV7HX59zaJQTEFl8hj"));
                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });

    }

    public Intent getOpenFacebookIntent() {
        try {
            getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/https://www.facebook.com/trodevit"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/trodevit"));
        }
    }

}