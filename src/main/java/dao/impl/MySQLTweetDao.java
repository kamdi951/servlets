package dao.impl;

import dao.AbstractMySQLDao;
import dao.TweetDao;
import model.AppUser;
import model.Tweet;

import javax.persistence.TypedQuery;
import java.util.List;


public class MySQLTweetDao extends AbstractMySQLDao implements TweetDao {

    @Override
    public void saveTweet(Tweet tweet) {
        hibernateUtil.save((tweet));
    }


    @Override
    public void delete(Long tweetId) {
        hibernateUtil.delete(Tweet.class, tweetId);
    }

    @Override
    public List<Tweet> getUserTweets(AppUser user) {
        TypedQuery<Tweet> query = em.createQuery("select t from Tweet t where t.author=:login",Tweet.class);
        query.setParameter("login", user.getLogin());
        return query.getResultList();
        //return new ArrayList<Tweet>(query.getResultList());
    }

    @Override
    public Tweet getTweet(Long id) {
        return em.find( Tweet.class, id);
    }
}
