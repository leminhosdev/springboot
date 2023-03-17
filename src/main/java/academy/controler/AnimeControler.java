package academy.controler;

import academy.domain.Anime;
import academy.requests.AnimeDTO;
import academy.requests.AnimeputDTO;
import academy.service.AnimeService;
import academy.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@Log4j2
@RestController
@RequestMapping("anime")
@RequiredArgsConstructor
public class AnimeControler {
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDateTimetoDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.Listall(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findBy(@PathVariable long id){
        return ResponseEntity.ok(animeService.findbyOrThrowBadResquestException(id));
    }
    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimeDTO anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimeputDTO animeputDTO){
        animeService.replace(animeputDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
