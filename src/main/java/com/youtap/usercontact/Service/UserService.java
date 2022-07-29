package com.youtap.usercontact.Service;

import com.youtap.usercontact.DTO.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {


    public User getUserByParam(String param){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> responseEntity =
                restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
        User[] userArray = responseEntity.getBody();

        for(int i=0;i<userArray.length;i++){
            if(userArray[i].getUsername().equals(param) || userArray[i].getId().equals(param)){
                return User.builder().id(userArray[i].getId())
                        .email(userArray[i].getEmail())
                        .phone(userArray[i].getPhone())
                        .build();
            }
        }

        return null;

    }
}
