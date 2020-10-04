import dao.AppUserDao;
import dao.TweetDao;
import dao.impl.MySQLTweetDao;
import dao.impl.MySQLUserDao;
import model.AppUser;
import model.Tweet;

import java.util.List;

public class TempTest {
    public static void main(String[] args) {
        AppUserDao dao = new MySQLUserDao();
        TweetDao tweetDao = new MySQLTweetDao();
        AppUser u1 = AppUser.UserBuilder.getBuilder()
                .name("Kinga")
                .email("rk@gmail.com")
                .lastName("Ryc")
                .password("haslo")
                .login("kamdi")
                .build();

        AppUser u2 = AppUser.UserBuilder.getBuilder()
                .name("Cytryna")
                .email("cytryna@gmail.com")
                .lastName("Marakuja")
                .password("1234")
                .login("papaja")
                .build();

        AppUser u3 = AppUser.UserBuilder.getBuilder()
                .name("Zdzichu")
                .email("zd@gmail.com")
                .lastName("Wąsacz")
                .password("qwerty")
                .login("zdzichu1955")
                .build();

        dao.saveUser(u1);
        dao.saveUser(u2);
        dao.saveUser(u3);
        dao.follow(u1, u2);
//        System.out.println("Followed of user1");
//        dao.getFollowedUsers(u1).forEach(System.out::println);
//        System.out.println("Followers of user2");
//        dao.getFollowers(u2).forEach(System.out::println);

//        System.out.println("-------------------unfollow");
//        dao.unfollow(u1,u2);
//        System.out.println("Followed of user1");
//        dao.getFollowedUsers(u1).forEach(System.out::println);
//        System.out.println("Followers of user2");
//        dao.getFollowers(u2).forEach(System.out::println);

//        System.out.println("------------------deleteUser");
//        dao.deleteUser(u2);
//        dao.getAll().forEach(System.out::println);
//
//        System.out.println("------------------userByEmail");
//        System.out.println(dao.getUserByEmail("zd@gmail.com"));

        Tweet tweet1 = new Tweet(u1.getLogin(), "pierwszy Tweet");
        tweetDao.saveTweet(tweet1);

        System.out.println("--------------pierwszy tweet");
        List<Tweet> userTweets = tweetDao.getUserTweets(u1);
        userTweets.forEach(System.out::println);

        System.out.println("--------------usuń usera1");
        dao.deleteUser(u1);



    }
}
