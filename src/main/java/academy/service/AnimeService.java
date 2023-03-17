package academy.service;

import academy.domain.Anime;
import academy.mapper.AnimeMapper;
import academy.repository.AnimeRepository;
import academy.requests.AnimeDTO;
import academy.requests.AnimeputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimeService {

    private final AnimeRepository animeRepository;
    public List<Anime> Listall(){
        return animeRepository.findAll();
    }
    public Anime findbyOrThrowBadResquestException(long id){
        return animeRepository.findById(id).orElseThrow(() ->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }
    public Anime save(AnimeDTO animedto){
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animedto));
    }

    public void delete(long id) {
       animeRepository.delete(findbyOrThrowBadResquestException(id));
    }

    public void replace(AnimeputDTO animeputDTO) {
       Anime savedAnime = findbyOrThrowBadResquestException(animeputDTO.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animeputDTO);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}
