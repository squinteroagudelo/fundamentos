package com.springboot.fundamentos.repository;

import com.springboot.fundamentos.dto.UserDto;
import com.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findUserByName(String name);

    List<User> findByNameContaining(String name);

    //… where x.firstname like ?1
    List<User> findByNameLike(String name);

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate start, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    //    Named Parameter
    @Query("select new com.springboot.fundamentos.dto.UserDto(u.id, u.name, u.email, u.birthDate)" +
            " from User u " +
            " where u.birthDate=:birth" +
            " and u.email=:mail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("birth") LocalDate date, @Param("mail") String email);
}
