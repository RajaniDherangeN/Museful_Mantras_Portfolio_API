package com.portfolio_backend.backend.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio_backend.backend.model.Artwork;
import com.portfolio_backend.backend.repository.*;

@Service 
public class ArtworkService {
	 @Autowired
	    private ArtworkRepository artworkRepository;

	    public List<Artwork> getAllArtworks() {
	        return artworkRepository.findAll();
	    }

	    public Artwork saveArtwork(Artwork artwork) {
	        return artworkRepository.save(artwork);
	    }

	    public Artwork updateLikes(Long id) {
	        Artwork artwork = artworkRepository.findById(id).orElseThrow();
	        artwork.setLikes(artwork.getLikes() + 1);
	        return artworkRepository.save(artwork);
	    }

		public List<Artwork> getRandomArtworks() {
			  return artworkRepository.getRandomArtworks();
		}
}
