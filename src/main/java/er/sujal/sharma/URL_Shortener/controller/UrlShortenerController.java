package er.sujal.sharma.URL_Shortener.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import er.sujal.sharma.URL_Shortener.exception.URLShortenerException;
import er.sujal.sharma.URL_Shortener.service.URLShortenerService;

@RestController
public class UrlShortenerController {
	@Autowired
	private URLShortenerService urlShortenerService;
	@PostMapping("/generate")
    public ResponseEntity<String> generateShortURL(@RequestParam String longURL) throws URLShortenerException {
        String shortURL = urlShortenerService.generateShortUrl(longURL);
        return new ResponseEntity<>(shortURL, HttpStatus.CREATED);
    }

    @GetMapping("/{shortURL}")
    public ResponseEntity<Void> fetchLongURL(@PathVariable String shortURL) throws URLShortenerException {
        String longURL = urlShortenerService.fetchLongUrl(shortURL);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(longURL));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
