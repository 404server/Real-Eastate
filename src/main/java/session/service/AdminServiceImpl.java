package session.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import session.model.Apartments;
import session.model.Role;
import session.model.UserAccount;
import session.model.UserProfile;
import session.repository.HouseRepository;
import session.repository.UserProfileRepository;
import session.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserProfileRepository userProfileRepo;

    @Autowired
    private HouseRepository houseRepository;


    @Override
    public void editUser(UserProfile profile) {
        UserProfile editedProfile = userProfileRepo.findById(profile.getIdProfile()).get();

        editedProfile.setFirstName(profile.getFirstName());
        editedProfile.setLastName(profile.getLastName());
        editedProfile.setPhoneNumber(profile.getPhoneNumber());
        editedProfile.setAddress(profile.getAddress());
        editedProfile.setAbout(profile.getAbout());

        userProfileRepo.save(editedProfile);
    }

    @Override
    public void markAsAdmin(int idUser) {
        UserAccount user = userRepo.findById(idUser).get();

        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        roles.add(role);

        for (Role r : roles) {
            r.setRole("ROLE_ADMIN");
            r.setUser(user);
        }

        user.setRoles(roles);
        user.setRole("ADMIN");

        userRepo.save(user);
    }

    @Override
    public List<UserAccount> listUser() {
        List<UserAccount> listUser = userRepo.findAll();

        listUser.removeIf(user -> user.getRole().equals("ADMIN"));
        return listUser;
    }

    @Override
    public List<UserAccount> listAdmin() {
        List<UserAccount> listAdmin = userRepo.findAll();

        listAdmin.removeIf(admin -> admin.getRole().equals("USER"));

        return listAdmin;
    }

    @Override
    public UserProfile getProfileById(int idProfile) {
        UserProfile profile = userProfileRepo.findById(idProfile).get();

        return profile;
    }

    @Override
    public List<Apartments> listHouses() {
        return houseRepository.findAll();
    }
}