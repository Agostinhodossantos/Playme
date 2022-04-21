package app.play.me.database

import app.play.me.model.Music
import app.play.me.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<MusicCacheEntity, Music> {
    override fun mapFromEntity(entity: MusicCacheEntity): Music {
        return Music(
            id = entity.id,
            title = entity.title,
            url = entity.url,
            cover = entity.cover
        )
    }

    override fun mapToEntity(domainModel: Music): MusicCacheEntity {
        return MusicCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            url = domainModel.url,
            cover = domainModel.cover
        )
    }

    fun mapFromEntityList(entities: List<MusicCacheEntity>): List<Music> {
        return entities.map { mapFromEntity(it) }
    }
}
