package com.mindtree.spring.rest.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.spring.rest.entity.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long>{

	public Collection<Bookmark> findByAccountUsername(String username);
}
