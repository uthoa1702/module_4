package com.example.first.repository;

import com.example.first.model.Tin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITinRepository extends JpaRepository<Tin,Integer> {

    @Query(value = "SELECT tin.* FROM tin INNER JOIN loai_tin LT ON tin.loai_tin_id = LT.id WHERE tin.tieu_de like :tieuDe and lt.id = :loaiTinId",nativeQuery = true)
    List<Tin> search(@Param("tieuDe") String tieuDe,@Param("loaiTinId") Integer loaiTinId);
}
