package com.example.biblio.Repository;

import com.example.biblio.Model.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyBookRepository extends JpaRepository<MyBookList,Integer>{

}
