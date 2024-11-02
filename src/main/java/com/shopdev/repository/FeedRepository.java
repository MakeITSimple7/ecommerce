package com.shopdev.repository;

import com.shopdev.entity.feed.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<FeedEntity, Long> {
}
