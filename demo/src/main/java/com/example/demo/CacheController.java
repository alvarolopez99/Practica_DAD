package com.example.demo;

import com.hazelcast.spring.cache.HazelcastCache;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// Controlador para visualizar el contenido cacheado
@RestController
public class CacheController {
	
	@Autowired
	private CacheManager cacheManager;
	
	/*@RequestMapping(value="/cache", method=RequestMethod.GET)
	public Map<Object, Object> getCacheContent() {
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("cacheSapiotheca");
		LOGGER.info(cache.toString());
		return cache.getNativeCache();
	}*/
	
	@RequestMapping(value = "/cacheUsuarios",method=RequestMethod.GET)
    public Map<Object, Object> getCacheUsuariosContent() {

        HazelcastCacheManager hazelcastCacheManager = (HazelcastCacheManager) cacheManager;
        HazelcastCache hazelcastCache = (HazelcastCache) hazelcastCacheManager.getCache("cacheUsuarios");
        return hazelcastCache.getNativeCache();
    }
	
	@RequestMapping(value = "/cacheCursos",method=RequestMethod.GET)
    public Map<Object, Object> getCacheCursosContent() {

        HazelcastCacheManager hazelcastCacheManager = (HazelcastCacheManager) cacheManager;
        HazelcastCache hazelcastCache = (HazelcastCache) hazelcastCacheManager.getCache("cacheCursos");
        return hazelcastCache.getNativeCache();
    }
	
	@RequestMapping(value = "/cacheAnuncios",method=RequestMethod.GET)
    public Map<Object, Object> getCacheAnunciosContent() {

        HazelcastCacheManager hazelcastCacheManager = (HazelcastCacheManager) cacheManager;
        HazelcastCache hazelcastCache = (HazelcastCache) hazelcastCacheManager.getCache("cacheAnuncios");
        return hazelcastCache.getNativeCache();
    }
	
	@RequestMapping(value = "/cacheForos",method=RequestMethod.GET)
    public Map<Object, Object> getCacheForosContent() {

        HazelcastCacheManager hazelcastCacheManager = (HazelcastCacheManager) cacheManager;
        HazelcastCache hazelcastCache = (HazelcastCache) hazelcastCacheManager.getCache("cacheForos");
        return hazelcastCache.getNativeCache();
    }
}