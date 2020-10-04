package dao;

import model.AppUser;
import model.Tweet;

import java.util.List;

public interface TweetDao {

    void saveTweet(Tweet tweet);

    void delete (Long tweetId);

    List<Tweet> getUserTweets(AppUser user);

    Tweet getTweet(Long id);

}
