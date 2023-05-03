package es.take_a_book.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
	
	@Autowired
	private CacheManager cacheManager;
	
	@GetMapping(value="/cacheBooks")
	public Map<Object, Object> getBooksCacheContent(){
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("books");
		return cache.getNativeCache();
	}
	
	@GetMapping(value="/cacheAuthors")
	public Map<Object, Object> getAuthorsCacheContent(){
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("authors");
		return cache.getNativeCache();	
	}
	
}
