package session.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import session.model.UserAccount;
import session.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserAccount user = userRepo.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("Invalid username or password");
    }

    return new CustomUserDetails(user);
  }
}