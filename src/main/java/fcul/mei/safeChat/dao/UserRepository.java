package fcul.mei.safeChat.dao;

import fcul.mei.safeChat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

 /*   private final EntityManager entityManager;
    private final UserMapper userMapper;

    public UserRepository(EntityManager entityManager, UserMapper userMapper) {
        this.entityManager = entityManager;
        this.userMapper =  userMapper;
    }

    @Override
    public User get(String username) {
        return userMapper.get(username);
    }

    public Boolean save(User user){
        return userMapper.save(user);
    }*/


}
