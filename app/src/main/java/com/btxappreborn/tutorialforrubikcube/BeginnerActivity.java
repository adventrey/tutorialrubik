package com.btxappreborn.tutorialforrubikcube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class BeginnerActivity extends AppCompatActivity implements BeginnerInterfaces {
    boolean readyIntads = false;
    private String AD_B_ID, AD_I_ID;
    private FrameLayout adContainerView;
    private AdView adView;
    InterstitialAd interstitialAdB;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);


        adContainerView = findViewById(R.id.ad_view_container);
        AD_B_ID = getResources().getString(R.string.ad_banner_id);
        AD_I_ID = getResources().getString(R.string.ad_intersitial_id);
        interstitialAdB = new InterstitialAd(this);
        interstitialAdB.setAdUnitId(AD_I_ID);

        ToolbarBeginner();

        Ganti_Fragment(new BeginnerFragment());
        adContainerView.post(new Runnable() {
            @Override
            public void run() {
                loadBanner();
            }
        });

    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.

        if (interstitialAdB != null && interstitialAdB.isLoaded()) {
            interstitialAdB.show();
        } else {
           Ganti_Fragment(fragment);
        }


    }

    private void loadIntersitial() {
        if (readyIntads) {
            if (!interstitialAdB.isLoading() && !interstitialAdB.isLoaded()) {
                AdRequest adRequest = new AdRequest.Builder().build();
                interstitialAdB.loadAd(adRequest);

                interstitialAdB.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        Ganti_Fragment(fragment);
                        super.onAdClosed();
                    }

                    @Override
                    public void onAdLoaded() {

                        super.onAdLoaded();
//                        Toast.makeText(BeginnerActivity.this, "ed", Toast.LENGTH_SHORT).show();
                    }
                });
//                Toast.makeText(this, "load", Toast.LENGTH_SHORT).show();
                readyIntads = false;
                Ganti_Fragment(fragment);
            }

        } else {
//            Toast.makeText(this, "no load", Toast.LENGTH_SHORT).show();
            readyIntads = true;
            showInterstitial();
        }


    }

    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();

        if (adView != null) {
            adView.resume();
        }
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    private void loadBanner() {
        // Create an ad request.
        adView = new AdView(this);
        adView.setAdUnitId(AD_B_ID);
        adContainerView.removeAllViews();
        adContainerView.addView(adView);

        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);

        AdRequest adRequest = new AdRequest.Builder().build();

        // Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        // Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = outMetrics.density;

        float adWidthPixels = adContainerView.getWidth();

        // If the ad hasn't been laid out, default to the full screen width.
        if (adWidthPixels == 0) {
            adWidthPixels = outMetrics.widthPixels;
        }

        int adWidth = (int) (adWidthPixels / density);

        return AdSize.getCurrentOrientationBannerAdSizeWithWidth(this, adWidth);
    }

    private void ToolbarBeginner() {

        Toolbar toolbar = findViewById(R.id.toolbarx);
        toolbar.setTitle(getString(R.string.app_name) + "/ Beginner");
        toolbar.setBackgroundColor(getResources().getColor(R.color.button3));
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    private void Ganti_Fragment(Fragment fragmentx) {

        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fragmentPlaceBeginner, fragmentx)
                .commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentPlaceBeginner);
        if (fragment instanceof BeginnerFragment) {
            onBackPressed();

        } else {
            Ganti_Fragment(new BeginnerFragment());
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_notation) {
            startActivity(new Intent(this, NotationActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(

                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void moveFragment(int i) {
        if (i == 301) {
            fragment = new BeginnerCrosFragment();
        } else if (i == 302) {
            fragment = new BeginnerWhiteCornersFragment();
        } else if (i == 303) {
            fragment = new BeginnerSecondLayersFragment();
        } else if (i == 304) {
            fragment = new BeginnerOll1Fragment();
        } else if (i == 305) {
            fragment = new BeginnerOll2Fragment();
        } else if (i == 306) {
            fragment =new BeginnerPllFragment();
        }
        loadIntersitial();

    }


}