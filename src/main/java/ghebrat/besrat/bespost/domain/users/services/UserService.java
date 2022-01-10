package ghebrat.besrat.bespost.domain.users.services;

import ghebrat.besrat.bespost.domain.users.exceptions.UserNotFoundException;
import ghebrat.besrat.bespost.domain.users.models.User;
import ghebrat.besrat.bespost.domain.users.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService (UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public void createUser(User user) throws UserNotFoundException {
        if (userRepo.findByEmail(user.getEmail()).isPresent()){
            throw new UserNotFoundException("email in use");
        }
        userRepo.save(user);
    }

    public void findById(Long userId){
        userRepo.findById(userId);
    }

    public Optional<User> findByEmail(String userEmail){
        return  userRepo.findByEmail(userEmail);
    }

    public void deleteUser(Long userId) throws UserNotFoundException{
        if(!userRepo.existsById(userId)){
            throw new UserNotFoundException("User with " + userId + " doesn't exist");
        }
        userRepo.deleteById(userId);
    }
}
