package slipp.web;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.PathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttchmentController {
	@GetMapping("/attachments")
	public ResponseEntity<PathResource> download() throws Exception {
		Path path = Paths.get("./pom.xml");
		PathResource resource = new PathResource(path);
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.TEXT_XML);
		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=pom.xml");
		header.setContentLength(resource.contentLength());
		return new ResponseEntity<PathResource>(resource, header, HttpStatus.OK);
	}
}
