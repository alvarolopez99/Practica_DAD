package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Foros;

import service.PostService;

@Controller
public class ForoController {

	
	@Autowired
	private PostService postService;
	


	@GetMapping("/")
	public String showPosts(Model model) {

		model.addAttribute("posts", postService.findAll());
		model.addAttribute("welcome", session.isNew());

		return "index";
	}

	@GetMapping("/post/new")
	public String newPostForm(Model model) {

		model.addAttribute("user", userSession.getUser());

		return "new_post";
	}
	
	@PostMapping("/post/new")
	public String newPost(Model model, Foros post) {

		postService.save(post);
		
		userSession.setUser(post.getUser());
		userSession.incNumPosts();
		
		model.addAttribute("numPosts", userSession.getNumPosts());

		return "saved_post";
	}

	@GetMapping("/post/{id}")
	public String showPost(Model model, @PathVariable long id) {

		Foros post = postService.findById(id);

		model.addAttribute("post", post);

		return "show_post";
	}
	
	@GetMapping("/post/{id}/delete")
	public String deletePost(Model model, @PathVariable long id) {

		postService.deleteById(id);

		return "deleted_post";
	}
	
	
}
