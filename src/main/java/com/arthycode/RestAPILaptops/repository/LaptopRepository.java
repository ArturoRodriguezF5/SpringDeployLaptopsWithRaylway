package com.arthycode.RestAPILaptops.repository;


import com.arthycode.RestAPILaptops.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
