package service;


import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Foros;



@Service
public class PostService {

	private ConcurrentMap<Long, Foros> posts = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();

	public PostService() {
		save(new Foros("Pepe", "Vendo moto", "Barata, barata"));
		save(new Foros("Juan", "Compro coche", "Pago bien"));
	}

	public Collection<Foros> findAll() {
		return posts.values();
	}

	public Foros findById(long id) {
		return posts.get(id);
	}

	public void save(Foros post) {

		long id = nextId.getAndIncrement();

		post.setId(id);

		this.posts.put(id, post);
	}

	public void deleteById(long id) {
		this.posts.remove(id);
	}

}