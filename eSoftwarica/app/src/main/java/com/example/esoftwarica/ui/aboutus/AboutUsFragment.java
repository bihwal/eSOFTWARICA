package com.example.esoftwarica.ui.aboutus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.esoftwarica.R;

public class AboutUsFragment extends Fragment {

    private AboutUsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(AboutUsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_aboutus, container, false);
        WebView webView = root.findViewById(R.id.webview);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://softwarica.edu.np/");        return root;
    }
}