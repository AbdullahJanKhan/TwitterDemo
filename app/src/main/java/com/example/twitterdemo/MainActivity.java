package com.example.twitterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String consumer = "SnV1ZqjRSbr6PR7iwlX8KoSMz";
        String consumerSecret = "EC4I3zJzDooQ5pgKsCLeNLToSgqJUzhIR2rexIhniYPSXJXwvG ";

        String token = "753587374173614081-aWN6u4ggwGon7jADjJ7evxlbpmq5hZJ";
        String tokenSecret = "jIm0u9tte2XzPv5QlzpKHNdqYnq38owdTQzDQbFcreYWz ";

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumer)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(token)
                .setOAuthAccessTokenSecret(tokenSecret);

        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("Pakistan");
        QueryResult result = null;
        try {
            result = twitter.search(query);
            List tweets = result.getTweets();
            tweets.forEach( tweet ->
                    Log.i("ID: ", tweet.toString()));

        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
