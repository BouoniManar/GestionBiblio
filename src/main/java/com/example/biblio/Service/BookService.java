package com.example.biblio.Service;

import java.util.List;

import com.example.biblio.Model.Book;
import com.example.biblio.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}



	//private LivreRepository livre;


	public List<Book> getAlllivre() {
		return this.bRepo.findAll();
	}


	public Book getOneLivreById(int id) {
		return this.bRepo.findById(id).orElse(null);
	}


}
