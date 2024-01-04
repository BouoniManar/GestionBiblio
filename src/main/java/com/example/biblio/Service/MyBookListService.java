package com.example.biblio.Service;

import java.util.List;

import com.example.biblio.Model.MyBookList;
import com.example.biblio.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyBookListService {
	
	@Autowired
	private MyBookRepository mybook;
	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deleteById(Integer id) {
		mybook.deleteById(id);
	}
}
