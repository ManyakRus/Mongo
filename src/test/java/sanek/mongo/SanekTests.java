/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.mongo;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sanek.mongo.models.User;
import sanek.mongo.JPA.UserJPA;

/**
 *
 * @author Sanek
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SanekTests {
        @Autowired
        private UserJPA userJPA;
        

    
        @Test
        public void saveUser() {
            
            User user = new User();
            user.setName("Sanek");
            user.setPassword("pass");
            user.getList().add(1);
            user.getList().add("2");
            user.getList().add(LocalDateTime.now());
            
            //userJPA.save(user);
            
            user = userJPA.findTop1ByName("Sanek");
            log.info("user: " + user);
            
        }        
}
