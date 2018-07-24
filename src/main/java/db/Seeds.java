package db;

import models.Article;
import models.Category;
import models.Journalist;
import org.apache.commons.lang.time.DateUtils;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


public class Seeds {


    public static void seedData() {
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);

        Journalist journalist1 = new Journalist("Matt Blake", "Java Developer, Healthy Life Style Evangelist");
        Journalist journalist2 = new Journalist("Elisa Woodheart", "Front End Wizard, Mother of All Dragons");
        Journalist journalist3 = new Journalist("Randall Flagg", "Harbinger of The Dark Ahead, Python Enthusiast");
        DBHelper.save(journalist1);
        DBHelper.save(journalist2);
        DBHelper.save(journalist3);



        Article article1 = new Article("Java developers on Demand", "IT Companies demand Developers", Category.JAVA, journalist1);
        article1.setLikes(5);
        article1.setDislikes(2);
        article1.setDate(DateUtils.addDays(article1.getDate(),-5));
        DBHelper.save(article1);

        Article article2 = new Article("Java developers close to kill each others", "IT Companies demand Developers", Category.JAVA, journalist1);
        article2.setLikes(50);
        article2.setDislikes(20);
        article2.setDate(DateUtils.addDays(article2.getDate(),-2));
        DBHelper.save(article2);


        Article article3 = new Article("Elon Musk makes space-pancakes!", "He makes awesome pancakes and hipsters lose their minds.", Category.TECH, journalist2);
        article3.setLikes(1);
        article3.setDislikes(90);
        article3.setDate(DateUtils.addDays(article3.getDate(),-1));

        DBHelper.save(article3);

        Article article4 = new Article("Tourist lands on the Moon!", "And claims compensation for lack of oxygen", Category.HISTORY, journalist2);
        article4.setLikes(25);
        article4.setDislikes(3);

        DBHelper.save(article4);


        Article article5 = new Article("Cryptocurrency Mafia Kills Two More!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget ipsum a tellus ultricies facilisis ut eget arcu. Pellentesque diam libero, auctor non porttitor at, gravida eu ante. Nam quis metus lacus. Maecenas ut molestie felis. Nam aliquam commodo est, nec ullamcorper sem lacinia ullamcorper. Quisque sapien mauris, semper quis arcu at, tincidunt tincidunt nisl. Fusce non sem tempor, tristique mauris elementum, lacinia orci. Sed ac bibendum turpis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. <br> Nam rhoncus pretium orci sit amet convallis. Sed sed congue ipsum, suscipit mattis ipsum. Etiam scelerisque nec metus eu ultrices. Nulla ac varius enim. Aliquam erat volutpat. Fusce magna tellus, porttitor at posuere et, egestas sit amet dui. Ut vitae elit pretium, tristique metus et, rutrum enim. Cras eu tempus velit, ac ultrices arcu. Sed eget enim hendrerit, sollicitudin felis varius, pretium mi. Nullam at dignissim lectus. Nulla quis dolor ut purus egestas aliquet faucibus vel arcu.<br>Sed vitae facilisis purus. Nulla facilisi. Sed semper, turpis id faucibus dictum, sem nibh malesuada sem, non vehicula odio urna non augue. Fusce eu nisl in metus ullamcorper egestas. In libero quam, scelerisque eget facilisis at, tristique at justo. Nunc condimentum nibh sed dui feugiat pharetra. Phasellus purus arcu, pellentesque a augue laoreet, vehicula hendrerit augue. Donec bibendum orci diam, nec mattis arcu tristique sed. Sed sem orci, rutrum id dolor in, malesuada tempus sem. Donec nec lacus non dui semper tempus at eget ligula. Duis sed finibus neque, quis congue ante. Curabitur aliquam volutpat ante, et ultrices lorem egestas quis.<br>In scelerisque id quam sed egestas. Praesent vitae dui tortor. Nunc interdum mattis sollicitudin. Pellentesque molestie magna eu nulla auctor tincidunt. Proin ac finibus velit, sit amet euismod dui. Ut sed mattis augue. Vivamus at massa ac elit accumsan vulputate vestibulum in mi. Donec auctor lectus id tellus viverra, eu faucibus libero consequat.<br>Curabitur varius blandit porta. Proin pulvinar malesuada magna, vitae pretium justo mattis a. Nam venenatis lectus justo, in maximus mi sagittis vel. Sed velit lectus, euismod id dapibus et, pulvinar non odio. Donec ut sem sed eros bibendum consectetur ut ac massa. Nullam ut justo accumsan sapien suscipit consectetur. Aenean orci velit, auctor in congue at, elementum sit amet nulla. Aliquam sapien nulla, vestibulum at libero id, iaculis elementum mi. Sed non neque lectus. Donec non velit tempor, scelerisque massa id, feugiat dui. Curabitur ac tincidunt orci. Cras bibendum bibendum mollis. Praesent varius neque ante, a aliquam libero ultricies eget. Quisque posuere congue massa id ultricies. Phasellus ac felis elit. Cras quis purus velit.", Category.HISTORY, journalist3);
        article5.setLikes(3);
        article5.setDislikes(4);
        article5.setDate(DateUtils.addDays(article3.getDate(),1));
        DBHelper.save(article5);













    }





    }








