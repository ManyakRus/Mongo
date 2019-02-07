/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.mongo.CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.stereotype.Component;
import sanek.mongo.models.User;

/**
 *
 * @author Sanek
 */
@Component
public class UserCRUD {
    @Autowired
    MongoTemplate mongoTemplate;
    
    public User findUserByName(String name) {
        User user;
        
        //Criteria criteria = new Criteria();
        
        //Query query = new Query();
        
        Query query = query(where("name").is(name)).limit(1);
        
        user = mongoTemplate.findOne(query, User.class);
        
        return user;
    }
    
}
