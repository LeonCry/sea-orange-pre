package com.voidis.sea_orange_pre.repository;

import com.voidis.sea_orange_pre.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
}
