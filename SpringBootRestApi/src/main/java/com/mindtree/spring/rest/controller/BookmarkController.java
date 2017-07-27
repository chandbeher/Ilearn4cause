package com.mindtree.spring.rest.controller;

import java.net.URI;
import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mindtree.spring.rest.entity.Account;
import com.mindtree.spring.rest.entity.Bookmark;
import com.mindtree.spring.rest.exception.UserNotFoundException;
import com.mindtree.spring.rest.repository.AccountRepository;
import com.mindtree.spring.rest.repository.BookmarkRepository;

@RestController
@RequestMapping("{username}/bookmarks")
public class BookmarkController {
	
	@Autowired
	private BookmarkRepository bookmarkRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Bookmark> readBookmarks(@PathVariable String username)throws Exception{
		this.validateUser(username);
		return this.bookmarkRepository.findByAccountUsername(username);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> add(@PathVariable String username, @RequestBody Bookmark input) throws Exception {
		validateUser(username);

		/*Bookmark boomark = bookmarkRepository.save(new Bookmark(account,
							input.getUri(), input.getDescription()));*/
		//return new ResponseEntity<Bookmark>(boomark, HttpStatus.CREATED);
		
		return this.accountRepository.findByUsername(username)
				.map(
					account -> {
						
					Bookmark result = bookmarkRepository.save(new Bookmark(account, input.getUri(), input.getDescription()));
					
					URI location = ServletUriComponentsBuilder
							.fromCurrentRequest().path("/{id}")
							.buildAndExpand(result.getId()).toUri();
					return ResponseEntity.created(location).build();
					
					})
				.orElse(ResponseEntity.noContent().build());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{bookmarkId}")
	public Bookmark readBookmark(@PathVariable String username, @PathVariable Long bookmarkId) throws Exception {
		this.validateUser(username);
		return this.bookmarkRepository.findOne(bookmarkId);
	}
	
	private void validateUser(String username)throws UserNotFoundException {
		/*Account acc = accountRepository.findByUsername(username).get();
		System.out.println(acc);
		if(acc == null || acc.getUsername() == null)
			throw new UserNotFoundException("Username not found : " + username);
		return acc;*/
		
			this.accountRepository.findByUsername(username)
					.orElseThrow(
					() -> new UsernameNotFoundException("Username not found : " + username));
						
						
	}
	
	
	public BookmarkRepository getBookmarkRepository() {
		return bookmarkRepository;
	}
	public void setBookmarkRepository(BookmarkRepository bookmarkRepository) {
		this.bookmarkRepository = bookmarkRepository;
	}
	public AccountRepository getAccountRepository() {
		return accountRepository;
	}
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
}
