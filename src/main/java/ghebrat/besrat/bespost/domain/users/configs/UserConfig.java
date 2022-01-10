package ghebrat.besrat.bespost.domain.users.configs;

import ghebrat.besrat.bespost.domain.users.models.User;
import ghebrat.besrat.bespost.domain.users.repos.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner (UserRepo userRepo){
        return args -> {
            User bes = new User("rafiki11", "realemail@email.com", "Bes", "Yellow");
            User robot = new User("pumbaaaa","email2","Redd","Foxx");
           userRepo.save(bes);
           userRepo.save(robot);
        };

    }

}
