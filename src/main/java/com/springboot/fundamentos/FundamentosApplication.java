package com.springboot.fundamentos;

import com.springboot.fundamentos.bean.IBeanWithProperties;
import com.springboot.fundamentos.bean.IMyBean;
import com.springboot.fundamentos.bean.IMyBeanWithDependency;
import com.springboot.fundamentos.component.IComponentDependency;
import com.springboot.fundamentos.entity.Post;
import com.springboot.fundamentos.entity.User;
import com.springboot.fundamentos.pojo.UserPojo;
import com.springboot.fundamentos.repository.IPostRepository;
import com.springboot.fundamentos.repository.IUserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

    private final IComponentDependency componentDependency;
    private final IMyBean myBean;
    private final IMyBeanWithDependency myBeanWithDependency;
    private final IBeanWithProperties beanWithProperties;
    private final UserPojo userPojo;
    private final IUserRepository userRepository;
    private final IPostRepository postRepository;

    public FundamentosApplication(@Qualifier("componentAnotherImpl") IComponentDependency componentDependency, IMyBean myBean, IMyBeanWithDependency myBeanWithDependency, IBeanWithProperties beanWithProperties, UserPojo userPojo, IUserRepository userRepository, IPostRepository postRepository) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.beanWithProperties = beanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initializeUsers();
        getInfoJpqlFromUser();
    }

    private void initializeUsers() {
        User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 15));
        User user2 = new User("Julie", "julie@domain.com", LocalDate.of(2019, 5, 20));
        User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 3, 25));
        User user4 = new User("Oscar", "oscar@domain.com", LocalDate.now());
        User user5 = new User("Test1", "test1@domain.com", LocalDate.of(2015, 9, 7));
        User user6 = new User("Test2", "test2@domain.com", LocalDate.of(2020, 6, 1));
        User user7 = new User("Test3", "test3@domain.com", LocalDate.of(2022, 2, 1));
        User user8 = new User("Test4", "test4@domain.com", LocalDate.of(2022, 1, 13));
        User user9 = new User("Test5", "test5@domain.com", LocalDate.of(2017, 7, 28));
        User user10 = new User("Test6", "test6@domain.com", LocalDate.of(2000, 1, 3));
        User user11 = new User("Test7", "test7@domain.com", LocalDate.of(2020, 3, 19));
        User user12 = new User("Test8", "test8@domain.com", LocalDate.of(1998, 1, 30));
        User user13 = new User("Test9", "test9@domain.com", LocalDate.of(1995, 5, 4));
        List<User> list = Arrays.asList(user4, user1, user3, user2, user5, user6, user7, user8, user9, user10, user11, user12, user13);
        userRepository.saveAll(list);
        /*postRepository.save(new Post("Post user12", user12));
        postRepository.save(new Post("Post user13", user13));
        postRepository.save(new Post("Post user13", user13));*/
    }

    private void getInfoJpqlFromUser() {
        LOGGER.info("User by email: " + userRepository
                .findByUserEmail("julie@domain.com")
                .orElseThrow(() -> new RuntimeException("User not found!")));

        userRepository.findAndSort("Test", Sort.by("id")
                        .descending())
                .forEach(user -> LOGGER.info("User sorted by id - Query JPQL: " + user));
    }

    private void oldLessons() {
        componentDependency.greet();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        System.out.println(beanWithProperties.function());
        System.out.printf("User info%nemail: %s%nPassword: %s%nAge: %d%n", userPojo.getEmail(), userPojo.getPassword(), userPojo.getAge());
        try {
            int value = 10 / 0;
        } catch (Exception e) {
            LOGGER.error("This is message error - Divide by zero: " + e.getMessage());
        }
    }
}
