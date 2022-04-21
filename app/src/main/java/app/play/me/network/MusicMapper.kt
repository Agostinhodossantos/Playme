package app.play.me.network

import app.play.me.model.Music
import app.play.me.utils.EntityMapper
import javax.inject.Inject

class MusicMapper
@Inject
constructor() : EntityMapper<MusicObjectResponse, Music> {
    override fun mapFromEntity(entity: MusicObjectResponse): Music {
        return Music(
            id = entity.id,
            title = entity.title,
            url = entity.url,
            cover = entity.cover
        )
    }

    override fun mapToEntity(domainModel: Music): MusicObjectResponse {
        return MusicObjectResponse(
            id = domainModel.id,
            title = domainModel.title,
            url = domainModel.url,
            cover = domainModel.cover
        )
    }

    fun mapFromEntityList(entities: List<MusicObjectResponse>): List<Music> {
        return entities.map { mapFromEntity(it) }
    }

}