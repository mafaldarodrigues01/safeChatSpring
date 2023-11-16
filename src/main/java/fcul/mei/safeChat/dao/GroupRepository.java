package fcul.mei.safeChat.dao;

import fcul.mei.safeChat.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

   /* @Query(value = "select * from groupp g where g in (select gu.gid from group_user gu where gu.username = :username", nativeQuery = true)
    List<Group> getAllGroupsFromAnUser(@Param("username") String username);
*/
}
