package yte.intern.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Arrays;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

public class RestTemplateTest {


    RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";


    @Test
    void getPosts(){

        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        //restTemplate.exchange(requestEntity, List.class);
        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);
        System.out.println(Arrays.stream(response.getBody()).toList());

    }

    @Test
    void getSinglePost(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts","3")
                .build()
                .toUri();


        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        //restTemplate.exchange(requestEntity, List.class);
        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);
        System.out.println(response.getBody());
    }

    @Test
    void addPost(){
        URI uri = fromHttpUrl(BASE_URL)  // UriComponentsBuilder.fromHttpUrl  de yapılıyor ama ALt+Enter ile static import yaptık
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Post> request = RequestEntity
                .post(uri)
                .body(new Post(7L, null, "hebele", "hübele"));

        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);
        System.out.println(response.getBody());
    }

    @Test
    void getPostById(){
        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .queryParam("userId", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);
        System.out.println(response.getBody());
    }
/*
    @Test
    void updateComment(){
        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("comments", "5")
                .build()
                .toUri();
    }
*/
    @Test
    void deletePost(){
        URI uri = fromHttpUrl(BASE_URL)
                .pathSegment("comments", "5")
                .build()
                .toUri();

        RequestEntity<Void> request =RequestEntity.delete(uri).build();

        ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
        System.out.println(response.getStatusCode());
    }



    @Test
    void getComments(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = fromHttpUrl("https://jsonplaceholder.typicode.com/comments")
                .pathSegment("1")
                .queryParam("comments")
                .build()
                .toUri();

        RequestEntity requestEntity = RequestEntity.get(uri).header("key","value")
                .build();

        ResponseEntity<String> exchange = restTemplate.exchange(requestEntity, String.class);
        System.out.println(exchange);

    }
}
