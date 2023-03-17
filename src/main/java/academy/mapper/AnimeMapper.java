package academy.mapper;

import academy.domain.Anime;
import academy.requests.AnimeDTO;
import academy.requests.AnimeputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimeDTO animeDTO);
    public abstract Anime toAnime(AnimeputDTO animeputDTO);

}
