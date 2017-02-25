package com.hellohasan.webscrapingbyjsoup.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hellohasan.webscrapingbyjsoup.Model.ArticleModel;
import com.hellohasan.webscrapingbyjsoup.Parser.HtmlParser;
import com.hellohasan.webscrapingbyjsoup.Parser.ParserResponseInterface;
import com.hellohasan.webscrapingbyjsoup.R;


public class MainActivity extends AppCompatActivity implements ParserResponseInterface{

    private TextView headlineTextView;
    private TextView articleTextView;
    private TextView errorMessageTextView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headlineTextView = (TextView) findViewById(R.id.headline);
        articleTextView = (TextView) findViewById(R.id.article);
        errorMessageTextView = (TextView) findViewById(R.id.errorMessage);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        //Execute AsyncTask for Parsing HTML
        new HtmlParser(this).execute("https://developer.android.com/training/index.html");

    }


    @Override
    public void onParsingDone(ArticleModel articleModel) {

        progressBar.setVisibility(View.GONE);

        if(articleModel!=null){
            headlineTextView.setText(articleModel.getHeadline());
            articleTextView.setText(articleModel.getArticle());
        }
        else
            errorMessageTextView.setText("Something wrong! Can't parse HTML");
    }

}
