package com.sk.superkassa.repo;

import com.sk.superkassa.model.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {
}
