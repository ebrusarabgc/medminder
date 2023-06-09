package dev.esara.medminder.service;

import dev.esara.medminder.entity.User;
import dev.esara.medminder.mapper.UserMapper;
import dev.esara.medminder.model.dto.UserDTO;
import dev.esara.medminder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

    public UserDTO getById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.toDTO(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
