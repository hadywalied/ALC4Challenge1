package com.test.challenge1

import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Color
import android.net.http.SslError
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val myWebView: WebView = findViewById(R.id.myWebView)
        // Configure related browser settings
        myWebView.settings.loadsImagesAutomatically = true
        myWebView.settings.javaScriptEnabled = true
        myWebView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        myWebView.loadUrl("https://andela.com/alc")

        // Configure the client to use when opening URLs
        myWebView.webViewClient = object : WebViewClient() {
            val layout: RelativeLayout = findViewById(R.id.webLayout)
            val progressBar = ProgressBar(this@Main2Activity, null, android.R.attr.progressBarStyleLarge);
            val params = RelativeLayout.LayoutParams(100, 100)

            override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
                handler.proceed() // Ignore SSL certificate errors
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                params.addRule(RelativeLayout.CENTER_IN_PARENT)
                layout.addView(progressBar, params)
                getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED))
                progressBar.setVisibility(View.VISIBLE)  //To show ProgressBar
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.setVisibility(View.GONE)
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        }
//        // Enable responsive layout
//        myWebView.settings.useWideViewPort = true
        // Zoom out if the content width is greater than the width of the viewport
        myWebView.settings.loadWithOverviewMode = true
        myWebView.settings.setSupportZoom(true)
        myWebView.settings.builtInZoomControls = true // allow pinch to zoom
        myWebView.settings.displayZoomControls = false // disable the default zoom controls on the page


    }
}
