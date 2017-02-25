package com.hellohasan.webscrapingbyjsoup.Parser;

import com.hellohasan.webscrapingbyjsoup.Model.ArticleModel;


public interface ParserResponseInterface {

    void onParsingDone(ArticleModel articleModel);
}
