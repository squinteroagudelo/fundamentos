package com.springboot.fundamentos.service;

import com.springboot.fundamentos.entity.User;
import com.springboot.fundamentos.repository.IUserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOGGER = LogFactory.getLog(UserService.class);
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users) {
        users.stream().peek(user -> LOGGER.info("User recorded: " + user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User user, Long id) {
        return userRepository.findById(id).map(u -> {
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setBirthDate(user.getBirthDate());
            return userRepository.save(user);
        }).get();
    }
}
