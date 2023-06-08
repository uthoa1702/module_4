package com.codegym.repository;

import com.codegym.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
}
