package com.crio.qcontest.services;

 import java.util.Collections;
import java.util.List;

import com.crio.qcontest.constants.UserOrder;
import com.crio.qcontest.entities.User;
import com.crio.qcontest.repositories.IUserRepository;

public class UserService{

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of createUser method
    // Implementation must take care of the following cases:-
    // 1) Create and store user in the repository.

    public User createUser(String name) {
     User u = new User(name);
     return userRepository.save(u);
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of getAllUser method
    // Implementation must take care of the following cases:-
    // 1) Get all the users in ascending Order w.r.t score.
    // 2) Get all the users in descending Order w.r.t score.

    public List<User> getUsers(UserOrder userOrder) {
     List<User> users = userRepository.findAll();
     if(userOrder == UserOrder.SCORE_ASC)
     {
       Collections.sort(users,(p1,p2)->{ return Integer.compare(p1.getTotalScore(), p2.getTotalScore());});
     }
     else
     {
        Collections.sort(users,(p1,p2)->{ return Integer.compare(p2.getTotalScore(), p1.getTotalScore());});
     }

     return users;
    } 
}
