package za.co.itq.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.itq.assesment.entity.UserEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Override
    List<UserEntity> findAll();

    UserEntity findUserEntityById(UUID id);

}
