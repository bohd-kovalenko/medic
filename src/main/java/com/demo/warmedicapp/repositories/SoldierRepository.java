package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SoldierRepository extends JpaRepository<Soldier, Integer> {
    Optional<Soldier> findById(Integer id);

    @Query("SELECT s FROM Soldier s WHERE s.deletedAt IS NULL")
    List<Soldier> findAll();

    @Query("SELECT s FROM Soldier s WHERE " +
            "(CONCAT(s.name, ' ', s.surname, ' ', s.patronymic) LIKE %:search% OR " +
            "CONCAT(s.name, ' ', s.patronymic, ' ', s.surname) LIKE %:search% OR " +
            "CONCAT(s.surname, ' ', s.name, ' ', s.patronymic) LIKE %:search% OR " +
            "CONCAT(s.surname, ' ', s.patronymic, ' ', s.name) LIKE %:search% OR " +
            "CONCAT(s.patronymic, ' ', s.name, ' ', s.surname) LIKE %:search% OR " +
            "CONCAT(s.patronymic, ' ', s.surname, ' ', s.name) LIKE %:search%) AND " +
            "s.deletedAt IS NULL")
    List<Soldier> searchSoldiers(@Param("search") String search);

    List<Soldier> findByBrigade(String brigade);
}
